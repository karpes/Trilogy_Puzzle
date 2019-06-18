package karpes_dev.trilogy_pazzle.version1.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.abstractions.OnItemClickListener;
import karpes_dev.trilogy_pazzle.version1.models.FigureModel;

public class ImageViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{

    private OnItemClickListener onItemClickListener;

    public View itemView;
    public ImageView image;
    public ProgressBar pb;


    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        image = itemView.findViewById(R.id.pixelImage);
        pb = itemView.findViewById(R.id.pb);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onClick(image, getAdapterPosition());
    }

    public void bind(@NonNull FigureModel figureModel, int position) {

    }
   /* public void bind(@NonNull FigureModel figureModel, int position){
        new FadeInAnimation(image).animate();
        Glide.with(itemView)
                .load(figureModel.getPng())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        pb.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(image);

        image.setOnClickListener(new OnImageModelClickListener(position));
    }*/


    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
