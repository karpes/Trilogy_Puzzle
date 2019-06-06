package karpes_dev.trilogy_pazzle.version1.listeners;

import android.view.View;

import karpes_dev.trilogy_pazzle.version1.abstractions.ICustomTouchListener;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygonListenerManager;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygonViewManager;
import karpes_dev.trilogy_pazzle.version1.abstractions.ISetScaleGlobalLayoutListener;

public class PolygonTouchListenerManager implements IPolygonListenerManager {

    private IPolygonViewManager<View> polygonViewManager;
    private ISetScaleGlobalLayoutListener setScaleGlobalLayoutListener;
    private float figureScale;

    public PolygonTouchListenerManager(ISetScaleGlobalLayoutListener setScaleGlobalLayoutListener) {
        this.setScaleGlobalLayoutListener = setScaleGlobalLayoutListener;
        figureScale = 1;
    }

    @Override
    public void setManager(IPolygonViewManager polygonViewManager) {
        this.polygonViewManager = polygonViewManager;
    }

    @Override
    public void setFigureScale(float figureScale) {
        this.figureScale = figureScale;
    }

    @Override
    public void setListener(final View touchPolygonView, final IPolygon polygon){
        ICustomTouchListener listener = new PolygonTouchListener(touchPolygonView, polygon, polygonViewManager, figureScale);
        touchPolygonView.setOnTouchListener(listener);
        setScaleGlobalLayoutListener.addNeedScales(listener);
    }
}
