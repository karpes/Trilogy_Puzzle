package karpes_dev.trilogy_pazzle.version2.interfaces.database;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.constants.Database;

public interface IDatabaseLoader<T> {

    public List<T> load();
}
