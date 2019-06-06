package karpes_dev.trilogy_pazzle.version1.math;

import java.util.List;

import karpes_dev.trilogy_pazzle.version1.abstractions.IFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;

public class MathFigure implements IMathFigure {

    private IMathPolygon mathPolygon;

    public MathFigure(IMathPolygon mathPolygon) {
        this.mathPolygon = mathPolygon;
    }

    @Override
    public float scaleFigure(IFigure figure, int width, int height) {
        float size = 0;
        List<IPolygon> polygons = figure.getPolygons();
        float[] w = new float[polygons.size()];
        float[] h = new float[polygons.size()];
        int count = 0;
        for(IPolygon t : polygons){
            w[count] = mathPolygon.getMaxX(t);
            h[count] = mathPolygon.getMaxY(t);
            count++;
        }

        float maxX = mathPolygon.findMax(w);
        float maxY = mathPolygon.findMax(h);

        float sizeX, sizeY;

        sizeX = width / maxX;
        sizeY = (height - 150) / maxY;

        if(sizeX > sizeY)
            size = sizeY;
        else
            size = sizeX;

        size *= 0.9f;

        return size;
    }
}
