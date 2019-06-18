package karpes_dev.trilogy_pazzle.version2.mvp_presenter;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_model.IModelImages;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_presenter.IPresenterImages;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view.IViewImages;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;
import karpes_dev.trilogy_pazzle.version2.mvp_model.ModelImages;
import karpes_dev.trilogy_pazzle.version2.rx_observer.ObserverImageItems;
import rx.Observer;

public class PresenterImages implements IPresenterImages {

    private IModelImages modelImages;
    private Observer<List<ImageItem>> observer;

    public PresenterImages(IViewImages viewImages, int categoryId) {
        observer = new ObserverImageItems(viewImages);
        modelImages = new ModelImages(categoryId);
    }

    @Override
    public void loadImageItems() {
        modelImages.loadCategoryItems(observer);
    }
}
