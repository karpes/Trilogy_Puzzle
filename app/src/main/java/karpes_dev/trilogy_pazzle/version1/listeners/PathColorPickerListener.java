package karpes_dev.trilogy_pazzle.version1.listeners;

import android.content.DialogInterface;
import android.view.View;

import karpes_dev.trilogy_pazzle.version1.abstractions.IColorPickerListener;
import karpes_dev.trilogy_pazzle.version1.abstractions.ISettingModel;

public class PathColorPickerListener implements IColorPickerListener {

    private ISettingModel settingModel;
    private View coloringView;

    public PathColorPickerListener(ISettingModel settingModel) {
        this.settingModel = settingModel;
    }

    @Override
    public void setColoredView(View coloringView) {
        this.coloringView = coloringView;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int selectedColor, Integer[] integers) {
        settingModel.setPathColor(selectedColor);
        if(coloringView != null)
            coloringView.setBackgroundColor(selectedColor);
    }
}
