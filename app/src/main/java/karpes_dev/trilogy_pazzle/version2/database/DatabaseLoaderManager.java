package karpes_dev.trilogy_pazzle.version2.database;

import java.util.HashMap;
import java.util.Map;

import karpes_dev.trilogy_pazzle.version2.constants.Database;
import karpes_dev.trilogy_pazzle.version2.interfaces.database.IDatabaseLoader;
import karpes_dev.trilogy_pazzle.version2.interfaces.database.IDatabaseLoaderManager;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.ICategoryItem;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IImageItem;

public class DatabaseLoaderManager implements IDatabaseLoaderManager {

    private Map<Database, IDatabaseLoader> loaderMap;

    public DatabaseLoaderManager() {
        loaderMap = new HashMap<>();
        init();
    }

    private void init() {
        IDatabaseLoader<ICategoryItem> categoryLoader = new CategoryLoader();
        loaderMap.put(Database.CATEGORY, categoryLoader);

        IDatabaseLoader<IImageItem> imageLoader = new ImageLoader();
        loaderMap.put(Database.IMAGES, imageLoader);
    }

    @Override
    public IDatabaseLoader getLoader(Database database) {
        return loaderMap.get(database);
    }
}
