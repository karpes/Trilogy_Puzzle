package karpes_dev.trilogy_pazzle.version2.interfaces;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;

public interface IAdapterCategory {

    public void initialize(RecyclerView recyclerView, List<CategoryItem> categoryItems);
}
