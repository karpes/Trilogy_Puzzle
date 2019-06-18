package karpes_dev.trilogy_pazzle.version2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version2.interfaces.IAdapterCategory;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import karpes_dev.trilogy_pazzle.version2.viewholder.CategoryViewHolder;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> implements IAdapterCategory {

    private List<CategoryItem> categoryItems;

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item, viewGroup, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewholder, int i) {
        categoryViewholder.bind(categoryItems.get(i));
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    @Override
    public void initialize(RecyclerView recyclerView, List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
        recyclerView.setAdapter(this);
    }
}
