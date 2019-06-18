package karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;

public interface IViewImages extends IViewError {

    public void showCategory(List<ImageItem> categoryItems);
}
