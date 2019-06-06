package karpes_dev.trilogy_pazzle.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.abstractions.ADialogColor;
import karpes_dev.trilogy_pazzle.abstractions.IColorPickerListener;
import karpes_dev.trilogy_pazzle.abstractions.IPackage;
import karpes_dev.trilogy_pazzle.abstractions.ISettingModel;
import karpes_dev.trilogy_pazzle.common.Common;
import karpes_dev.trilogy_pazzle.dialog.DialogColor;
import karpes_dev.trilogy_pazzle.managers.ColorPickerPackage;
import karpes_dev.trilogy_pazzle.models.SettingSaveModel;
import io.paperdb.Paper;

public class SettingActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private View pathColor, numbersColor;
    private SeekBar sb_difficulty;

    private ISettingModel settingSaveModel;

    private IPackage<IColorPickerListener> colorPickerListenerIPackage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        settingSaveModel = Paper.book().read(Common.SETTING_SAVE_MODEL);
        if(settingSaveModel == null){
            settingSaveModel = new SettingSaveModel(Color.WHITE, Color.WHITE, 5);
        }

        colorPickerListenerIPackage = new ColorPickerPackage(settingSaveModel);

        sb_difficulty = findViewById(R.id.sb_difficulty);
        sb_difficulty.setOnSeekBarChangeListener(this);
        sb_difficulty.setProgress(settingSaveModel.getDifficulty());

        pathColor = findViewById(R.id.pathColor);
        pathColor.setBackgroundColor(settingSaveModel.getPathColor());

        numbersColor = findViewById(R.id.numbersColor);
        numbersColor.setBackgroundColor(settingSaveModel.getNumbersColor());

    }

    @Override
    public void onBackPressed() {
        Paper.book().write(Common.SETTING_SAVE_MODEL, settingSaveModel);
        super.onBackPressed();
        finish();
    }

    //View Click method
    public void setPathColor(View view){
        ADialogColor dialogColor = new DialogColor();
        dialogColor.setListenerAndView(colorPickerListenerIPackage.get(Common.PATH), pathColor);
        dialogColor.show(getSupportFragmentManager(), getString(R.string.path_color));
    }
    //View Click method
    public void setNumbersColor(View view){
        ADialogColor dialogColor = new DialogColor();
        dialogColor.setListenerAndView(colorPickerListenerIPackage.get(Common.NUMBERS), numbersColor);
        dialogColor.show(getSupportFragmentManager(), getString(R.string.numbers_color));
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(progress < 1)
            settingSaveModel.setDifficulty(1);
        else
            settingSaveModel.setDifficulty(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Заглушка
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Заглушка
    }
}
