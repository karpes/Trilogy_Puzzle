package karpes_dev.trilogy_pazzle.version2.rx_observer;

import java.util.List;

import io.reactivex.disposables.Disposable;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.ICategoryItem;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view.IViewCategory;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import rx.Observer;

public class ObserverCategoryItems implements Observer<List<CategoryItem>> {

    private IViewCategory viewCategory;

    public ObserverCategoryItems(IViewCategory viewCategory) {
        this.viewCategory = viewCategory;
    }


    @Override
    public void onNext(List<CategoryItem> categoryItems) {
        viewCategory.showCategory(categoryItems);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        viewCategory.showError(e.getMessage());
    }

}
