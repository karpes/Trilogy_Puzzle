package karpes_dev.trilogy_pazzle.abstractions;

import android.view.ViewTreeObserver;

public interface ISetScaleGlobalLayoutListener extends ViewTreeObserver.OnGlobalLayoutListener {

    void addNeedScales(INeedScale ...iNeedScales);
}
