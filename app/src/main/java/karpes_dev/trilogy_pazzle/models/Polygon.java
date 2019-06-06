package karpes_dev.trilogy_pazzle.models;
import karpes_dev.trilogy_pazzle.abstractions.IPoint2;
import karpes_dev.trilogy_pazzle.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.exceptions.PolygonInitializationException;

public class Polygon implements IPolygon {

    /* ******IPolygon*********/
    //Точки
    private IPoint2 point1;
    private IPoint2 point2;
    private IPoint2 point3;
    //Цвет
    private String color;
    //Закрашен ли треуголник
    private boolean colored;
    //Номер треугольника
    private int number;
    /* ********************/

    public Polygon(float[] points) {
         if(points.length == 6){
             point1 = new Point(points[0], points[1]);
             point2 = new Point(points[2], points[3]);
             point3 = new Point(points[4], points[5]);
             colored = false;
         }else {
             try {
                 throw new PolygonInitializationException();
             } catch (PolygonInitializationException e) {
                 e.printStackTrace();
             }
         }

    }

    /* ***IPolygon interface****/
    @Override
    public IPoint2 getPoint1() {
        return point1;
    }
    @Override
    public IPoint2 getPoint2() {
        return point2;
    }
    @Override
    public IPoint2 getPoint3() {
        return point3;
    }
    @Override
    public int getNumber() {
        return number;
    }
    @Override
    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String getColor() {
        if(color == null) return "#000000";
        return color;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public boolean isColored() {
        return colored;
    }
    @Override
    public void setColored(boolean colored) {
        this.colored = colored;
    }
    /* *************************/
}
