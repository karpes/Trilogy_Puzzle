package karpes_dev.trilogy_pazzle.listeners;

import android.view.MotionEvent;
import android.view.View;

import com.easyandroidanimations.library.BounceAnimation;

import karpes_dev.trilogy_pazzle.abstractions.ICustomTouchListener;
import karpes_dev.trilogy_pazzle.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.abstractions.IPolygonViewManager;
import karpes_dev.trilogy_pazzle.managers.PolygonViewManager;

public class PolygonTouchListener implements ICustomTouchListener {

    private View touchPolygonView;
    private IPolygon polygon;
    private IPolygonViewManager polygonViewManager;
    private float figureScale;

    private final float LENGTH_UP = 50;

    private float yEnd = 0;
    private float yStart = 0;

    public PolygonTouchListener(View touchPolygonView, IPolygon polygon, IPolygonViewManager polygonViewManager, float figureScale) {
        this.touchPolygonView = touchPolygonView;
        this.polygon = polygon;
        this.polygonViewManager = polygonViewManager;
        this.figureScale = figureScale;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                yStart = (int) event.getRawY();
                new BounceAnimation(touchPolygonView)
                        .setDuration(1000)
                        .animate();
                break;
            case MotionEvent.ACTION_UP:
                    polygonViewManager.remove(null);
                break;
            case MotionEvent.ACTION_MOVE:
                yEnd = event.getRawY();
                if(isLength(yStart, yEnd)){
                    PolygonViewManager.s = polygon.getNumber();
                    polygonViewManager.create(polygon, event.getRawX(), event.getRawY(), figureScale);
                    polygonViewManager.remove(touchPolygonView);
                }
                break;
        }
        return true;
    }
    //Проверка на протяжку
    private boolean isLength(float start, float end){
        return start - end > LENGTH_UP;
    }

    @Override
    public void setFigureScale(float figureScale) {
        this.figureScale = figureScale;
    }
}
