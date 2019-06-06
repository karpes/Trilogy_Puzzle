package karpes_dev.trilogy_pazzle.version1.models;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IReader;

@RunWith(AndroidJUnit4.class)
public class ReaderSVGTest {

    private IReader<IPolygon> reader;
    private final int testId = 1000;

    @Before
    public void init(){
        reader = new ReaderSVG(InstrumentationRegistry.getContext(), testId);
    }

    @Test
    public void readerSVGTest(){

    }


}
