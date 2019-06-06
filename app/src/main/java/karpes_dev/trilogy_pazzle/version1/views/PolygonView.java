package karpes_dev.trilogy_pazzle.version1.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import karpes_dev.trilogy_pazzle.version1.abstractions.APolygonView;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;

public class PolygonView extends APolygonView {

    private IMathPolygon mathPolygon;
    private Paint paint;
    private Path path;
    private float scale;
    private float widthPolygon;
    private float heightPolygon;
    private float[] points;

    private boolean isScaled;
    private IPolygon polygon;

    public PolygonView(Context context) {
        super(context);
        initCanvas();
    }
    public PolygonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCanvas();
    }
    public PolygonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCanvas();
    }

    public PolygonView(Context context, IPolygon polygon, float scale, IMathPolygon mathPolygon) {
        super(context);
        this.polygon = polygon;
        this.mathPolygon = mathPolygon;
        initCanvas();
        isScaled = false;
        this.scale = scale;
        points = mathPolygon.getNullCoordinates(polygon);
        widthPolygon = mathPolygon.findMax(points[0], points[2], points[4]) * scale;
        heightPolygon = mathPolygon.findMax(points[1], points[3], points[5]) * scale;
    }

    /* APolygonView методы**/
    @Override
    public float getWidthPolygon() {
        return widthPolygon;
    }
    @Override
    public float getHeightPolygon() {
        return heightPolygon;
    }
    @Override
    public void setMathPolygon(IMathPolygon mathPolygon){
        this.mathPolygon = mathPolygon;
    }
    @Override
    public void setPolygon(IPolygon polygon){
        this.polygon = polygon;
    }
    @Override
    public IPolygon getPolygon() {
        return polygon;
    }
    /* **********************/

    @Override
    protected void onDraw(Canvas canvas) {
        float points[] = mathPolygon.getNullCoordinates(polygon);
        if(points.length == 6) {
            if(isScaled) {
                int h = getHeight() - 50;
                scale = mathPolygon.scalePolygon(polygon, getWidth(),h);
            }
            canvas.drawColor(Color.TRANSPARENT);

            paint.setColor(Color.parseColor(polygon.getColor()));
            path.moveTo(points[0] * scale, points[1] * scale);
            path.lineTo(points[2] * scale, points[3] * scale);
            path.lineTo(points[4] * scale, points[5] * scale);
            path.lineTo(points[0] * scale, points[1] * scale);
            canvas.drawPath(path, paint);

            drawText(canvas);
        }
    }

    private void initCanvas(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
        scale = 1;
        paint.setStyle(Paint.Style.FILL);
        isScaled = true;
        //красивые линии и текст
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        //закругление углов
        paint.setPathEffect(new CornerPathEffect(2));
    }
    private void drawText(Canvas canvas){
        if(isScaled){
            paint.setTextSize(getHeight() / 7);
            float xt = paint.getTextSize();
            float yt = getHeight() - paint.getTextSize();
            canvas.drawText(polygon.getNumber() + "",xt, yt, paint);
        }
    }
}
