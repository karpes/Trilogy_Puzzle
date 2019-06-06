package karpes_dev.trilogy_pazzle.version1.abstractions;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class AFigureView extends View implements INeedScale {

    public AFigureView(Context context) {
        super(context);
    }

    public AFigureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AFigureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public abstract void setDrawFigure(IDrawFigure drawFigure);
    public abstract void setSettingModel(ISettingModel settingModel);

}
