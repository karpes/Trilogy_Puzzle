package karpes_dev.trilogy_pazzle.version1.abstractions;

import java.util.List;

public interface IFigure  extends IDrawFigure{

    public List<IPolygon> getPolygons();
    public void setPolygons(List<IPolygon> polygons);
}
