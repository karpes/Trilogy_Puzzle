package karpes_dev.trilogy_pazzle.version1.listeners;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import karpes_dev.trilogy_pazzle.version1.models.Vector2D;

public class ScaleAndDragTouchListener implements View.OnTouchListener {

    private static final int INVALID_POINTER_ID = -1;
    private boolean isTranslateEnabled = true;
    private boolean isScaleEnabled = true;
    private float minimumScale = 0.8f;
    private float maximumScale = 4f;
    int width = 0;
    private int mActivePointerId = INVALID_POINTER_ID;
    private float mPrevX;
    private float mPrevY;
    private MyScaleGestureDetector mMyScaleGestureDetector;
    private static float scale = 1;

    private TouchScaleAndDrag drag;

    public ScaleAndDragTouchListener() {
        mMyScaleGestureDetector = new MyScaleGestureDetector(new ScaleGestureListener());
        drag = new TouchScaleAndDrag();
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private static void move(View view, TransformInfo info) {
        computeRenderOffset(view, info.pivotX, info.pivotY);
        scale = view.getScaleX() * info.deltaScale;
        scale = Math.max(info.minimumScale, Math.min(info.maximumScale, scale));
        view.setScaleX(scale);
        view.setScaleY(scale);

    }

    private static void adjustTranslation(View view, float deltaX, float deltaY) {
            float[] deltaVector = {deltaX, deltaY};
            view.getMatrix().mapVectors(deltaVector);
            view.setTranslationX(view.getTranslationX() + deltaVector[0]);
            view.setTranslationY(view.getTranslationY() + deltaVector[1]);
    }

    private static void computeRenderOffset(View view, float pivotX, float pivotY) {
        if (view.getPivotX() == pivotX && view.getPivotY() == pivotY) {
            return;
        }
        float[] prevPoint = {0.0f, 0.0f};
        view.getMatrix().mapPoints(prevPoint);

        view.setPivotX(pivotX);
        view.setPivotY(pivotY);

        float[] currPoint = {0.0f, 0.0f};
        view.getMatrix().mapPoints(currPoint);

        float offsetX = currPoint[0] - prevPoint[0];
        float offsetY = currPoint[1] - prevPoint[1];
        view.setTranslationX(view.getTranslationX() - offsetX);
        view.setTranslationY(view.getTranslationY() - offsetY);
    }

    private void scaleView(final View v, float x, float y){
        final TransformInfo info = new TransformInfo();
        info.pivotX = x;
        info.pivotY = y;
        info.deltaScale = 1.0f;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        mMyScaleGestureDetector.onTouchEvent(view, event);
        if (!isTranslateEnabled) {
            return true;
        }
        drag.onClick(event);

        int action = event.getAction();
        switch (action & event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                mPrevX = event.getX();
                mPrevY = event.getY();
                mActivePointerId = event.getPointerId(0);
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                int pointerIndex = event.findPointerIndex(mActivePointerId);
                if (pointerIndex != -1) {
                    float currX = event.getX(pointerIndex);
                    float currY = event.getY(pointerIndex);
                    if (!mMyScaleGestureDetector.isInProgress()) {
                        adjustTranslation(view, currX - mPrevX, currY - mPrevY);
                    }
                }

                break;
            }

            case MotionEvent.ACTION_CANCEL:
                mActivePointerId = INVALID_POINTER_ID;
                break;

            case MotionEvent.ACTION_UP:
                mActivePointerId = INVALID_POINTER_ID;

                if(view.getScaleX() == 1f && drag.isMove())
                    scaleView(view, event.getX(), event.getY());

                break;

            case MotionEvent.ACTION_POINTER_UP: {
                int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                int pointerId = event.getPointerId(pointerIndex);
                if (pointerId == mActivePointerId) {
                    int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mPrevX = event.getX(newPointerIndex);
                    mPrevY = event.getY(newPointerIndex);
                    mActivePointerId = event.getPointerId(newPointerIndex);
                }

                break;
            }
        }
        return true;
    }

    private class ScaleGestureListener extends MyScaleGestureDetector.SimpleOnScaleGestureListener {

        private float mPivotX;
        private float mPivotY;
        private Vector2D mPrevSpanVector = new Vector2D();
        private TransformInfo info;

        @Override
        public boolean onScaleBegin(View view, MyScaleGestureDetector detector) {
            mPivotX = detector.getFocusX();
            mPivotY = detector.getFocusY();
            Log.d("QQQWWQQQQ", "x = " + mPivotX + ", y = " + mPivotY);
            mPrevSpanVector.set(detector.getCurrentSpanVector());
            return true;
        }

        @Override
        public boolean onScale(View view,MyScaleGestureDetector detector) {
            info = new TransformInfo();
            info.deltaScale = isScaleEnabled ? detector.getScaleFactor() : 1.0f;
            info.pivotX = mPivotX;
            info.pivotY = mPivotY;
            info.minimumScale = minimumScale;
            info.maximumScale = maximumScale;
            move(view,info);
           return false;
        }
    }

    private class TransformInfo {
        float deltaScale;
        float pivotX;
        float pivotY;
        float minimumScale;
        float maximumScale;
    }
}