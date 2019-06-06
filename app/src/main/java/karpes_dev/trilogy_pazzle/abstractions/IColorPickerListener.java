package karpes_dev.trilogy_pazzle.abstractions;

import android.view.View;

import com.flask.colorpicker.builder.ColorPickerClickListener;

public interface IColorPickerListener extends ColorPickerClickListener {
    void setColoredView(View view);
}
