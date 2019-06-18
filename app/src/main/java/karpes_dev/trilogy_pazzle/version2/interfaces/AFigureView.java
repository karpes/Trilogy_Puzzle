package karpes_dev.trilogy_pazzle.version2.interfaces;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import karpes_dev.trilogy_pazzle.version2.interfaces.item.IDrawFigure;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.INeedScale;
import karpes_dev.trilogy_pazzle.version1.abstractions.ISettingModel;

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
