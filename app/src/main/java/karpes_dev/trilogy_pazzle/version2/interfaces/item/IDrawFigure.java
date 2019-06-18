package karpes_dev.trilogy_pazzle.version2.interfaces.item;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public interface IDrawFigure {
    public void draw(Canvas canvas, Paint paint, Path path, int pathColor, int numberColor, float size);
}
