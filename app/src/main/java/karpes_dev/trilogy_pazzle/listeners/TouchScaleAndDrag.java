package karpes_dev.trilogy_pazzle.listeners;

import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Calendar;

public class TouchScaleAndDrag extends GestureDetector.SimpleOnGestureListener {


    private final int MAX_CLICK_DURATION = 150;
    private final int MAX_CLICK_DISTANCE = 3;
    private long startClickTime, clickDuration;
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    private float dx;
    private float dy;

    /*public boolean onClick(MotionEvent event, int x, int y) {
        int action = event.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
            {
                startClickTime = Calendar.getInstance().getTimeInMillis();
                x1 = event.getX();
                y1 = event.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                x2 = event.getX();
                y2 = event.getY();
                dx = x2-x1;
                dy = y2-y1;

                if(isMove()) {
                    return event.getX() > x * Common.RECTSIZE && event.getX() < (x * Common.RECTSIZE) + Common.RECTSIZE
                            && event.getY() > y * Common.RECTSIZE && event.getY() < (y * Common.RECTSIZE) + Common.RECTSIZE;
                }

            }
        }
        return false;
    }*/

    public boolean onClick(MotionEvent event) {
        int action = event.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
            {
                startClickTime = Calendar.getInstance().getTimeInMillis();
                x1 = event.getX();
                y1 = event.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                x2 = event.getX();
                y2 = event.getY();
                dx = x2-x1;
                dy = y2-y1;

                return isMove();

            }
        }
        return false;
    }

    public boolean isMove(){
        return  (clickDuration < MAX_CLICK_DURATION && dx < MAX_CLICK_DISTANCE && dy < MAX_CLICK_DISTANCE);
    }

}

