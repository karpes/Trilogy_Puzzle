package karpes_dev.trilogy_pazzle.version1.abstractions;

public interface IPolygonViewManager<T> {
    public T create(IPolygon polygon, float x, float y, float scale);
    public void remove(T t);
}
