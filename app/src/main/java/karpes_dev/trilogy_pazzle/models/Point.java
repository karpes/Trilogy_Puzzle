package karpes_dev.trilogy_pazzle.models;

import karpes_dev.trilogy_pazzle.abstractions.IPoint2;

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

