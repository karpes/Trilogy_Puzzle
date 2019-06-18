package karpes_dev.trilogy_pazzle.version2.interfaces.item;

import karpes_dev.trilogy_pazzle.version1.abstractions.IPoint2;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.version1.models.Point;

public class MathPolygon implements IMathPolygon {

    private int difficulty;

    public MathPolygon() {
        difficulty = 5;
    }

    @Override
    public float getMaxX(IPolygon polygon) {

        IPoint2 point1 = polygon.getPoint1();
        IPoint2 point2 = polygon.getPoint2();
        IPoint2 point3 = polygon.getPoint3();

        float maxX = findMax(point1.getX(), point2.getX(), point3.getX());

        return maxX;
    }

    @Override
    public float getMaxY(IPolygon polygon) {
        IPoint2 point1 = polygon.getPoint1();
        IPoint2 point2 = polygon.getPoint2();
        IPoint2 point3 = polygon.getPoint3();

        float maxY = findMax(point1.getY(), point2.getY(), point3.getY());

        return maxY;
    }

    @Override
    public float getRadiusInscribedCircle(IPolygon polygon) {

        float x1 = polygon.getPoint1().getX();
        float y1 = polygon.getPoint1().getY();
        float x2 = polygon.getPoint2().getX();
        float y2 = polygon.getPoint2().getY();
        float x3 = polygon.getPoint3().getX();
        float y3 = polygon.getPoint3().getY();

        //Найти длины сторон
        float a = (float) (Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2)));
        float b = (float) (Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2)));
        float c = (float) (Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2)));
        //Найти периметр треугольника
        float p = (a + b + c) / 2;

        float radius = (float) Math.sqrt(((p - a) * (p - b) * (p - c)) / p);

        return radius;
    }

    @Override
    public IPoint2 getCentre(IPolygon polygon) {

        float x1 = polygon.getPoint1().getX();
        float y1 = polygon.getPoint1().getY();
        float x2 = polygon.getPoint2().getX();
        float y2 = polygon.getPoint2().getY();
        float x3 = polygon.getPoint3().getX();
        float y3 = polygon.getPoint3().getY();

        float xCenter = ((x1 + x2 + x3) / 3);
        float yCenter = ((y1 + y2 + y3) / 3);

        IPoint2 centre = new Point(xCenter, yCenter);

        return centre ;
    }

    @Override
    public float[] getNullCoordinates(IPolygon polygon) {
        float[] points;
        float[] pointsX = new float[3];
        float[] pointsY = new float[3];

        pointsX[0] = polygon.getPoint1().getX();
        pointsY[0] = polygon.getPoint1().getY();

        pointsX[1] = polygon.getPoint2().getX();
        pointsY[1] = polygon.getPoint2().getY();

        pointsX[2] = polygon.getPoint3().getX();
        pointsY[2] = polygon.getPoint3().getY();

        float minX = 10000, minY = 10000;

        for (float p : pointsX)
            if (minX > p)
                minX = p;

        for (float p : pointsY)
            if (minY > p)
                minY = p;

        points = new float[6];
        points[0] = pointsX[0] - minX;
        points[1] = pointsY[0] - minY;

        points[2] = pointsX[1] - minX;
        points[3] = pointsY[1] - minY;

        points[4] = pointsX[2] - minX;
        points[5] = pointsY[2] - minY;
        return points;
    }

    @Override
    public float findMax(float... points){
        float max = 0;
        for(float p : points){
            if(max < p)
                max = p;
        }
        return max;
    }

    @Override
    public float scalePolygon(IPolygon polygon, int width, int height) {
        float[] points = getNullCoordinates(polygon);
        float maxX = findMax(points[0], points[2], points[4]);
        float maxY = findMax(points[1], points[3], points[5]);

        float heightCorrect = height - 50;

        float scale = 1;
        if(maxX > width && maxY > heightCorrect){
            float x = maxX - width;
            float y = maxY - heightCorrect;

            if(x > y){
                scale = width / maxX;
            }else
                scale = height / maxY;
        }else if(maxX > width && maxY <= heightCorrect){
            scale = width / maxX;
        }else if(maxX <= width && maxY > heightCorrect){
            scale = height / maxY;
        }else if(maxX <= width && maxY <= heightCorrect){
            float x = width - maxX;
            float y = height - maxY;

            if(x > y)
                scale = heightCorrect / maxY;
            else
                scale = width / maxX;
            scale *= 0.8f;
        }
        return scale;
    }

    @Override
    public boolean checkPosition(IPolygon polygon, float x1, float y1, float scale) {
        float xa = polygon.getPoint1().getX() * scale;
        float ya = polygon.getPoint1().getY() * scale;
        float LENGTH_VECTORS = difficulty;

        float[] nullCoordinates = getNullCoordinates(polygon);

        float x = x1 + nullCoordinates[0] * scale;
        float y = y1 + nullCoordinates[1] * scale;

        boolean b = (x - LENGTH_VECTORS < xa && x + LENGTH_VECTORS > xa &&
                y - LENGTH_VECTORS < ya && y + LENGTH_VECTORS > ya);
        return b;
    }

    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
