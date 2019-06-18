package karpes_dev.trilogy_pazzle.version2.dagger_module;

import dagger.Module;
import dagger.Provides;
import karpes_dev.trilogy_pazzle.version2.database.DatabaseLoaderManager;
import karpes_dev.trilogy_pazzle.version2.interfaces.database.IDatabaseLoaderManager;

@Module
public class DatabaseLoaderManagerModule {

    @Provides
    public IDatabaseLoaderManager getLoaderManager(){
        return new DatabaseLoaderManager();
    }
}
