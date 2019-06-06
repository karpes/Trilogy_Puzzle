package karpes_dev.trilogy_pazzle.version1.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import karpes_dev.trilogy_pazzle.version1.abstractions.IPoint2;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@SuppressWarnings("deprecation")
public class PolygonAndPointsTests {

    private IPolygon polygonWithNotNullPoints;
    private IPoint2 point1, point2, point3;
    private int x1, y1, x2, y2, x3, y3;

    @Before
    public void setup(){
        x1 = 1;
        y1 = 1;

        x2 = 2;
        y2 = 0;

        x3 = 3;
        y3 = 2;

        //6 координат, правильно
        polygonWithNotNullPoints = new Polygon(new float[]{x1, y1, x2, y2, x3, y3});

        point1 = polygonWithNotNullPoints.getPoint1();
        point2 = polygonWithNotNullPoints.getPoint2();
        point3 = polygonWithNotNullPoints.getPoint3();
    }
    @Test
    public void checkNotNullPoints() {
        assertEquals(point1.getX(), x1, 0.01f);
        assertEquals(point1.getY(), y1, 0.01f);

        assertEquals(point2.getX(), x2, 0.01f);
        assertEquals(point2.getY(), y2, 0.01f);

        assertEquals(point3.getX(), x3, 0.01f);
        assertEquals(point3.getY(), y3, 0.01f);
    }

    @Test
    public void checkPolygonColoredIsFalse(){
        assertFalse(polygonWithNotNullPoints.isColored());
    }

    @After
    public void clear(){
        polygonWithNotNullPoints = null;
        point1 = point2 = point3 = null;
    }
}