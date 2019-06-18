package karpes_dev.trilogy_pazzle.version2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.item.IImageItem;
import karpes_dev.trilogy_pazzle.version2.viewholder.ImageViewHolder;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private List<IImageItem> imageItems;

    public ImageAdapter(List<IImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }
}
