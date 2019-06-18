package karpes_dev.trilogy_pazzle.version2.interfaces.item;


import karpes_dev.trilogy_pazzle.version1.abstractions.IPoint2;

public interface IPolygon {
    public IPoint2 getPoint1();
    public IPoint2 getPoint2();
    public IPoint2 getPoint3();
    public String getColor();
    public void setColor(String color);
    public int getNumber();
    public void setNumber(int number);
    public boolean isColored();
    public void setColored(boolean colored);
}
