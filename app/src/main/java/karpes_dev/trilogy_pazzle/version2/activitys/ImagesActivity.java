package karpes_dev.trilogy_pazzle.version2.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_presenter.IPresenterImages;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_view.IViewImages;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;
import karpes_dev.trilogy_pazzle.version2.mvp_presenter.PresenterImages;

public class ImagesActivity extends AppCompatActivity implements IViewImages {

    @BindView(R.id.rv_category) RecyclerView rv_category;
    private IPresenterImages presenterImages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        ButterKnife.bind(this);

        int categoryId = getIntent().getIntExtra("categoryId", 0);
        presenterImages = new PresenterImages(this, categoryId);
        presenterImages.loadImageItems();
    }

    @Override
    public void showCategory(List<ImageItem> categoryItems) {

    }

    @Override
    public void showError(String error) {

    }
}
