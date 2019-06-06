package karpes_dev.trilogy_pazzle.version1.models;

import karpes_dev.trilogy_pazzle.version1.abstractions.IPoint2;

public class Point implements IPoint2 {
    
    private float x;
    private float y;

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }
    @Override
    public float getY() {
        return y;
    }
}

