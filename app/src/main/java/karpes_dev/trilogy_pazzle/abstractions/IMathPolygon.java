package karpes_dev.trilogy_pazzle.abstractions;

public interface IMathPolygon {

    //Найти самое большое значение X и Y
    float getMaxX(IPolygon polygon);
    float getMaxY(IPolygon polygon);

    //Найти раудиус вписанной окружности и центр треугольника
    float getRadiusInscribedCircle(IPolygon polygon);
    IPoint2 getCentre(IPolygon polygon);

    //Координаты точек от нуля, тоесть точка с наименьшим значением, будет равна нулю по одной из систем координат
    float[] getNullCoordinates(IPolygon polygon);

    float findMax(float...s);
    float scalePolygon(IPolygon polygon, int width, int height);

    boolean checkPosition(IPolygon polygon, float x, float y, float scale);

    void setDifficulty(int difficulty);
}
