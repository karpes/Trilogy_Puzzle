package karpes_dev.trilogy_pazzle.exceptions;

public class PolygonInitializationException extends Exception {

    @Override
    public String getMessage() {
        return "PolygonInitializationException: float array size not equal 6!";
    }
}
