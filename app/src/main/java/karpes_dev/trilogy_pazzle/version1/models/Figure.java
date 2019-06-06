package karpes_dev.trilogy_pazzle.version1.models;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.List;

import karpes_dev.trilogy_pazzle.version1.abstractions.IDrawFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPoint2;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;


public class Figure implements IFigure, IDrawFigure {

    private List<IPolygon> polygons;
    private IMathPolygon mathPolygon;

    public Figure(List<IPolygon> polygons, IMathPolygon mathPolygon) {
        this.polygons = polygons;
        this.mathPolygon = mathPolygon;
    }

    /**
     *  Отрисовка треугольников по списку обьектов класса Polygon(треугольник).
     * @param path Обьект класса Path2D.
     * @param size Размер чертежа.
     */
    @Override
    public void draw(Canvas canvas,Paint paint, Path path, int pathColor, int numberColor, float size) {
        for(IPolygon p : polygons){
            if(p.isColored()) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.parseColor(p.getColor()));
            }
            else {
                //Draw number
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(numberColor);

                float radius = mathPolygon.getRadiusInscribedCircle(p);
                float textSize = radius * size * 0.9f;

                paint.setTextSize(textSize);

                IPoint2 centerPoint = mathPolygon.getCentre(p);

                float xText = (centerPoint.getX() * size) - (paint.getTextSize() / 2);
                float yText = (centerPoint.getY() * size) + (paint.getTextSize() / 2);

                canvas.drawText(String.valueOf(p.getNumber()),
                        xText,
                        yText,
                        paint);
                paint.setColor(pathColor);
                //End
            }
            //Draw trigon
            path.moveTo((p.getPoint1().getX()) * size, (p.getPoint1().getY()) * size);
            path.lineTo((p.getPoint2().getX()) * size, (p.getPoint2().getY()) * size);
            path.lineTo((p.getPoint3().getX()) * size, (p.getPoint3().getY()) * size);
            path.lineTo((p.getPoint1().getX()) * size, (p.getPoint1().getY()) * size);
            canvas.drawPath(path, paint);
            path.reset();
            //End
        }
        path.close();
    }

    @Override
    public List<IPolygon> getPolygons() {
        return polygons;
    }

    @Override
    public void setPolygons(List<IPolygon> polygons) {
        this.polygons = polygons;
    }
}
