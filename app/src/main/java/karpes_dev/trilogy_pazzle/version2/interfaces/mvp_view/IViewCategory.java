package karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.item.ICategoryItem;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;

public interface IViewCategory extends IViewError{

    public void showCategory(List<CategoryItem> categoryItems);
}
