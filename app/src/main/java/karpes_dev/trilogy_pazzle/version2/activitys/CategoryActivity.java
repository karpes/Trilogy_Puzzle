package karpes_dev.trilogy_pazzle.version2.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version2.adapter.CategoryAdapter;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_presenter.IPresenterCategory;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view.IViewCategory;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import karpes_dev.trilogy_pazzle.version2.mvp_presenter.PresenterCategory;

public class CategoryActivity extends AppCompatActivity implements IViewCategory {

    @BindView(R.id.rv_category) RecyclerView rv_category;

    private RecyclerView.LayoutManager layoutManager;

    private CategoryAdapter categoryAdapter;
    private IPresenterCategory presenterCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        ButterKnife.bind(this);
        initRecyclerView();
        categoryAdapter = new CategoryAdapter();
        presenterCategory = new PresenterCategory(this);
        presenterCategory.loadCategoryItems();
    }

    private void initRecyclerView() {
        layoutManager =  new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_category.setLayoutManager(layoutManager);
        rv_category.setHasFixedSize(true);
    }

    @Override
    public void showCategory(List<CategoryItem> categoryItems) {
        categoryAdapter.initialize(rv_category, categoryItems);
    }

    @Override
    public void showError(String error) {

    }
}
