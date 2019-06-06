package karpes_dev.trilogy_pazzle.abstractions;

import android.view.View;

public interface IPolygonListenerManager extends INeedScale{

    public void setListener(View viewOnClick, IPolygon polygon);
    public void setManager(IPolygonViewManager manager);
}
