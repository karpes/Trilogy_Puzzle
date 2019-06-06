package karpes_dev.trilogy_pazzle.version1.activitys;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.abstractions.ACustomPagerAdapter;
import karpes_dev.trilogy_pazzle.version1.abstractions.AFigureView;
import karpes_dev.trilogy_pazzle.version1.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.version1.abstractions.IFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IManager;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPermission;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygonListenerManager;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygonViewManager;
import karpes_dev.trilogy_pazzle.version1.abstractions.IReader;
import karpes_dev.trilogy_pazzle.version1.abstractions.ISetScaleGlobalLayoutListener;
import karpes_dev.trilogy_pazzle.version1.abstractions.ISettingModel;
import karpes_dev.trilogy_pazzle.version1.adapters.PolygonViewPagerAdapter;
import karpes_dev.trilogy_pazzle.version1.common.Common;
import karpes_dev.trilogy_pazzle.version1.help.SaveTask;
import karpes_dev.trilogy_pazzle.version1.listeners.PolygonTouchListenerManager;
import karpes_dev.trilogy_pazzle.version1.listeners.ScaleAndDragTouchListener;
import karpes_dev.trilogy_pazzle.version1.listeners.SetScaleGlobalLayoutListener;
import karpes_dev.trilogy_pazzle.version1.managers.ButtonClickManager;
import karpes_dev.trilogy_pazzle.version1.managers.PolygonViewManager;
import karpes_dev.trilogy_pazzle.version1.math.MathFigure;
import karpes_dev.trilogy_pazzle.version1.math.MathPolygon;
import karpes_dev.trilogy_pazzle.version1.models.Figure;
import karpes_dev.trilogy_pazzle.version1.models.ReaderSVG;
import karpes_dev.trilogy_pazzle.version1.models.SaveModel;
import karpes_dev.trilogy_pazzle.version1.models.SettingSaveModel;
import karpes_dev.trilogy_pazzle.version1.views.CustomViewPager;
import io.paperdb.Paper;
import permission.auron.com.marshmallowpermissionhelper.ActivityManagePermission;

public class FigureColoringActivity extends ActivityManagePermission implements View.OnClickListener, IPermission {


    //Главный контейнер
    private View viewParent;
    //Номер фигуры
    private int id;
    //Движение фигуры и масштабирование
    private View.OnTouchListener scaleAndDragTouchListener;
    //Контейнер для фигуры и полигонов
    private ViewGroup relativeLayoutContainer;
    //Список цветных полигонов
    private CustomViewPager viewPager;
    //Математические операции с фигурой
    private IMathFigure mathFigure;
    //Математические операции с полигоном
    private IMathPolygon mathPolygon;
    //Фигура
    private IFigure figure;
    //Установить масштаб по отношению размера фигуры к размеру экрана после загрузки View
    private ISetScaleGlobalLayoutListener setScaleGlobalListener;
    //
    private AFigureView figureView;
    //Менеджер для управления, добавления и удаления полигонов в контейнере
    private IPolygonViewManager polygonViewManager;
    //Слушатель касаний п ополигону из списка
    private IPolygonListenerManager polygonListenerManager;
    private ACustomPagerAdapter polygonAdapter;
    //Настройки цвета и сложности
    private ISettingModel settingModel;
    //Менеджер обработчиков кнопок
    private IManager<ICommand> managerBtnClick;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing);

        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resId > 0) {
            Common.SIZE = getResources().getDimensionPixelSize(resId);
        }

        viewParent = findViewById(R.id.cl);

        mathPolygon = new MathPolygon();
        mathFigure = new MathFigure(mathPolygon);

        initSetting();

        id = Common.id_model + 1;
        initPicture();
        initFigureView();

        setScaleGlobalListener = new SetScaleGlobalLayoutListener(figureView, figure, mathFigure);
        polygonListenerManager = new PolygonTouchListenerManager(setScaleGlobalListener);
        scaleAndDragTouchListener = new ScaleAndDragTouchListener();

        relativeLayoutContainer = findViewById(R.id.rl);
        relativeLayoutContainer.setOnTouchListener(scaleAndDragTouchListener);

        viewPager = findViewById(R.id.rv);
        polygonAdapter = new PolygonViewPagerAdapter(figure, polygonListenerManager, mathPolygon);
        viewPager.setAdapter(polygonAdapter);

        polygonViewManager = new PolygonViewManager(relativeLayoutContainer, figureView, polygonAdapter, viewPager, mathPolygon);

        polygonListenerManager.setManager(polygonViewManager);
        setScaleGlobalListener.addNeedScales(polygonListenerManager, figureView);

        managerBtnClick = new ButtonClickManager(id, figure, viewParent, this, figureView, mathPolygon, polygonListenerManager, relativeLayoutContainer);
    }

    private void initSetting(){
        ISettingModel settingModel2 = Paper.book().read(Common.SETTING_SAVE_MODEL);
        if(settingModel2 == null){
            settingModel = new SettingSaveModel(Color.WHITE, Color.WHITE, 5);
            mathPolygon.setDifficulty(settingModel.getDifficulty());
        }else {
            if(settingModel == null)
                settingModel = new SettingSaveModel(settingModel2.getPathColor(), settingModel2.getNumbersColor(), settingModel2.getDifficulty());
            settingModel.setDifficulty(settingModel2.getDifficulty());
            settingModel.setNumbersColor(settingModel2.getNumbersColor());
            settingModel.setPathColor(settingModel2.getPathColor());
            mathPolygon.setDifficulty(settingModel.getDifficulty());
        }

    }
    private void initPicture(){
        SaveModel saveModel = Paper.book().read("figure " + String.valueOf(id));
        if(saveModel != null){
            figure = saveModel.getFigure();
        }else {
            IReader readerSVG = new ReaderSVG(this, id);
            figure = new Figure(readerSVG.read(), mathPolygon);
        }
    }
    private void initFigureView(){
        figureView = findViewById(R.id.df);
        figureView.setDrawFigure(figure);
        figureView.setSettingModel(settingModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(polygonAdapter != null)
            polygonAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onResume() {
        super.onResume();
        initSetting();
    }
    @Override
    protected void onDestroy() {
        SaveTask saveTask = new SaveTask();
        saveTask.setModel(new SaveModel(figure, id), Common.CODE_SAVE_LOAD + id);
        saveTask.execute();
        super.onDestroy();
    }

    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id != -1){
            managerBtnClick.get(id).execute(viewParent);
        }else {
            Toast.makeText(this, getString(R.string.restart_er), Toast.LENGTH_SHORT).show();
        }
    }
}
