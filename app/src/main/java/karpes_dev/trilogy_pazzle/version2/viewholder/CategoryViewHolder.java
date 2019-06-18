package karpes_dev.trilogy_pazzle.version2.viewholder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import butterknife.BindView;
import butterknife.ButterKnife;
import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.help.GlideUrlWithQueryParameter;
import karpes_dev.trilogy_pazzle.version2.activitys.ImagesActivity;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.ICategoryItem;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ci_category) ImageView ci_category;
    @BindView(R.id.tv_category) TextView tv_category;

    private View parent;

    public CategoryViewHolder(@NonNull View parent) {
        super(parent);
        ButterKnife.bind(this, parent);
        this.parent = parent;

        int categoryId = getAdapterPosition();
        setClickListener(parent, categoryId);
    }

    public void bind(ICategoryItem categoryItem){
        Glide.with(parent)
                .load(new GlideUrlWithQueryParameter(categoryItem.getImageUrl(), "source", "feed"))
                .thumbnail(0.1f)
                .into(ci_category);
        tv_category.setText(categoryItem.getName());
    }

    private void setClickListener(View view, int categoryId){
        view.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ImagesActivity.class);
            intent.putExtra("categoryId", categoryId);
            view.getContext().startActivity(intent);
        });
    }
}
