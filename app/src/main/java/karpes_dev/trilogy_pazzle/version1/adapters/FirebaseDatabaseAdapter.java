package karpes_dev.trilogy_pazzle.version1.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.help.GlideImageLoader;
import karpes_dev.trilogy_pazzle.version1.help.GlideUrlWithQueryParameter;
import karpes_dev.trilogy_pazzle.version1.models.ImageModel;
import karpes_dev.trilogy_pazzle.version1.viewholders.ImageViewHolder;

public class FirebaseDatabaseAdapter extends FirebaseRecyclerAdapter<ImageModel, ImageViewHolder> {

    public FirebaseDatabaseAdapter(@NonNull FirebaseRecyclerOptions<ImageModel> options) {
        super(options);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.wallpaper_item, viewGroup, false);
        int height = viewGroup.getMeasuredHeight();
        itemView.setMinimumHeight(height);
        return new ImageViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ImageViewHolder holder, int position, @NonNull final ImageModel model) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_error_black_24dp)
                .priority(Priority.HIGH);

        new GlideImageLoader(holder.image, holder.pb)
                .load(new GlideUrlWithQueryParameter(model.getImageSVG(), "source", "feed").toStringUrl(), options);
        //holder.setItemClickListener(new OnImageModelClickListener());
    }


}
