package karpes_dev.trilogy_pazzle.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.abstractions.ADialogColor;
import karpes_dev.trilogy_pazzle.abstractions.IColorPickerListener;

public class DialogColor extends ADialogColor {

    private IColorPickerListener getColorPickerListener;

    @Override
    public void setListenerAndView(IColorPickerListener getColorPickerListener, View coloredView){
        this.getColorPickerListener = getColorPickerListener;
        getColorPickerListener.setColoredView(coloredView);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Context context = getContext();

        return ColorPickerDialogBuilder
                .with(context)
                .setTitle(getString(R.string.set_color))
                .showAlphaSlider(false)
                .initialColor(Color.GREEN)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setPositiveButton("Ok", getColorPickerListener)
                .setNegativeButton(getString(R.string.end), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build();
    }

}