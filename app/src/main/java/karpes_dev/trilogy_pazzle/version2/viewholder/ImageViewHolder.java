package karpes_dev.trilogy_pazzle.version2.viewholder;

import android.support.v7.widget.RecyclerView;

import karpes_dev.trilogy_pazzle.version2.interfaces.AFigureView;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private AFigureView figureView;

    public ImageViewHolder(AFigureView figureView) {
        super(figureView);
        this.figureView = figureView;
    }

    public AFigureView getFigureView() {
        return figureView;
    }
}
