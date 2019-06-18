package karpes_dev.trilogy_pazzle.version2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import karpes_dev.trilogy_pazzle.version2.interfaces.AFigureView;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IDrawFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.ISettingModel;

public class FigureView extends AFigureView {

    private Paint paint;
    private Path path;
    private IDrawFigure drawFigure;
    private ISettingModel settingModel;
    //Масштаб размеров фигуры к размеру экрана
    private float drawScale;

    /* *Базовые конструкторы*/
    public FigureView(Context context) {
        super(context);
        init();

    }
    public FigureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public FigureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    /* ***********************/

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //красивые линии и текст
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        path = new Path();
        drawScale = 1;
    }

    /* *Методы класса View*/
    @Override
    protected void onDraw(Canvas canvas) {
        int pathColor = Color.WHITE;
        int numbersColor = Color.WHITE;
        if(settingModel != null){
            pathColor = settingModel.getPathColor();
            numbersColor = settingModel.getNumbersColor();
        }
        drawFigure.draw(canvas, paint, path, pathColor, numbersColor, drawScale);
    }
    /* *********************/

    /* *Методы класса AFigureView*/
    @Override
    public void setDrawFigure(IDrawFigure drawFigure) {
        this.drawFigure = drawFigure;
    }

    @Override
    public void setSettingModel(ISettingModel settingModel) {
        this.settingModel = settingModel;
    }

    /* ***************************/

    /* Методы интерфейса INeedScale*/
    @Override
    public void setFigureScale(float figureScale) {
        this.drawScale = figureScale;
    }
    /* *****************************/
}
