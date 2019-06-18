package karpes_dev.trilogy_pazzle.version2.interfaces.database;

import karpes_dev.trilogy_pazzle.version2.constants.Database;

public interface IDatabaseLoaderManager {

    public IDatabaseLoader getLoader(Database database);
}
