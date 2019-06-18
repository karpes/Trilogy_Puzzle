package karpes_dev.trilogy_pazzle.version2.interfaces.mvp_model;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.item.ImageItem;
import rx.Observer;

public interface IModelImages {

    public void loadCategoryItems(Observer<List<ImageItem>> observer);
}
