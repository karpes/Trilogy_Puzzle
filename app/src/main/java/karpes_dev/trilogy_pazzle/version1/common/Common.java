package karpes_dev.trilogy_pazzle.version1.common;

import android.Manifest;
import android.graphics.Bitmap;
import android.view.View;

public class Common {


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] x = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static final int STEP_POLYGON = 5;
    public static final int STEP_FIGURE = 5;

    public static int SIZE = 30;

    public static int id_model = 0;
    public static final int CODE_RESTART = 0;
    public static final int CODE_SAVE_LOAD = 1;

    /* *Константы для сохранения настроек и прохождения*/
    public final static String SETTING_SAVE_MODEL = "SETTING";
    /* *************************************************/

    /* *Подключение к базе данных*/
    public static final String STR_IMAGES = "Images";
    /* ***************************/
    
    /**Setting*/
    public final static String PATH = "PATH";
    public final static String NUMBERS = "NUMBERS";

    /**End setting*/
    

    public static Bitmap getBitmapFromView(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache();

        Bitmap b = bitmap.copy(Bitmap.Config.ARGB_4444, false);
        view.setDrawingCacheEnabled(false);
        return b;
    }
}
