package karpes_dev.trilogy_pazzle.version1.abstractions;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class APolygonView extends View {

    public APolygonView(Context context) {
        super(context);
    }
    public APolygonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public APolygonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract float getWidthPolygon();
    public abstract float getHeightPolygon();
    public abstract void setMathPolygon(IMathPolygon mathPolygon);
    public abstract void setPolygon(IPolygon polygon);
    public abstract IPolygon getPolygon();
}
