package karpes_dev.trilogy_pazzle.version2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.AFigureView;
import karpes_dev.trilogy_pazzle.version2.interfaces.IAdapterImage;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IImageItem;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IMathPolygon;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IPolygon;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IReaderSVG;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;
import karpes_dev.trilogy_pazzle.version2.view.FigureView;
import karpes_dev.trilogy_pazzle.version2.viewholder.ImageViewHolder;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements IAdapterImage {

    private List<IImageItem> imageItems;
    private IReaderSVG readerSVG;
    private IMathPolygon mathPolygon;

    public ImageAdapter(IReaderSVG readerSVG, IMathPolygon mathPolygon) {
        this.readerSVG = readerSVG;
        this.mathPolygon = mathPolygon;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AFigureView figureView = new FigureView(viewGroup.getContext());
        ImageViewHolder imageViewHolder = new ImageViewHolder(figureView);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        String svg = imageItems.get(i).getSvg();
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    @Override
    public void initialize(RecyclerView recyclerView, List<IImageItem> imageItems) {
        this.imageItems = imageItems;
        recyclerView.setAdapter(this);
    }
}
