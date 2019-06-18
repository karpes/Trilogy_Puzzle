package karpes_dev.trilogy_pazzle.version2.interfaces;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.interfaces.item.IImageItem;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;

public interface IAdapterImage {

    public void initialize(RecyclerView recyclerView, List<IImageItem> imageItems);
}
