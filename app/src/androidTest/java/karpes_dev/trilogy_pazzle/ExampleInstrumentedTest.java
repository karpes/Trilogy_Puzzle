package karpes_dev.trilogy_pazzle;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;

import karpes_dev.trilogy_pazzle.abstractions.IAdapter;
import karpes_dev.trilogy_pazzle.managers.FirebaseAdapterManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("iluck.lowpolygon", appContext.getPackageName());
    }

    /* *FigureListActivity*/
    @Test
    public void initRecyclerAdapter() {
        IAdapter firebaseAdapter = new FirebaseAdapterManager();
        RecyclerView.Adapter adapter = firebaseAdapter.getRecyclerAdapter();
        assertNotNull("Firebase initialization error!(check firebase query)",adapter);
    }
    /* ********************/

    /* *FigureColoringActivity*/
    @Test
    public void q(){
    }
    /* ***********************/
}
