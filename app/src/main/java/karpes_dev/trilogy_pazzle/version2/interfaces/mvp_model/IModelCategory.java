package karpes_dev.trilogy_pazzle.version2.interfaces.mvp_model;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import rx.Observer;

public interface IModelCategory {

    public void loadCategoryItems(Observer<List<CategoryItem>> observer);
}
