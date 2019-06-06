package karpes_dev.trilogy_pazzle.abstractions;

import android.support.v4.app.DialogFragment;
import android.view.View;

public abstract class ADialogColor extends DialogFragment {

    public abstract void setListenerAndView(IColorPickerListener getColorPickerListener, View coloredView);
}
