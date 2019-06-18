package karpes_dev.trilogy_pazzle.version2.rx_observer;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view.IViewImages;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;
import rx.Observer;

public class ObserverImageItems implements Observer<List<ImageItem>> {

    private IViewImages viewImages;

    public ObserverImageItems(IViewImages viewImages) {
        this.viewImages = viewImages;
    }


    @Override
    public void onNext(List<ImageItem> imageItems) {
        viewImages.showCategory(imageItems);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        viewImages.showError(e.getMessage());
    }
}
