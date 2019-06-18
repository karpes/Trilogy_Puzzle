package karpes_dev.trilogy_pazzle.version2.mvp_presenter;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_model.IModelCategory;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_presenter.IPresenterCategory;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view.IViewCategory;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import karpes_dev.trilogy_pazzle.version2.mvp_model.ModelCategory;
import karpes_dev.trilogy_pazzle.version2.rx_observer.ObserverCategoryItems;
import rx.Observer;

public class PresenterCategory implements IPresenterCategory {

    private Observer<List<CategoryItem>> observer;
    private IModelCategory categoryModel;

    public PresenterCategory(IViewCategory viewCategory) {
        observer = new ObserverCategoryItems(viewCategory);
        categoryModel = new ModelCategory();
    }

    @Override
    public void loadCategoryItems() {
        categoryModel.loadCategoryItems(observer);
    }
}
