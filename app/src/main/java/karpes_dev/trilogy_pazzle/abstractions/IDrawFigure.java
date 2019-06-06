package karpes_dev.trilogy_pazzle.abstractions;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public interface IDrawFigure {
    public void draw(Canvas canvas,Paint paint, Path path, int pathColor, int numberColor, float size);
}
