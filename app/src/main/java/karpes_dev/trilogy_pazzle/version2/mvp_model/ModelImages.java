package karpes_dev.trilogy_pazzle.version2.mvp_model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.DataSnapshotMapper;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.constants.Database;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_model.IModelImages;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;
import rx.Observer;

public class ModelImages implements IModelImages {

    private int categoryId;

    public ModelImages(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public void loadCategoryItems(Observer<List<ImageItem>> observer) {
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference(Database.IMAGES.getUrl())
                .orderByChild("categoryId")
                .equalTo(categoryId)
                .getRef();
        RxFirebaseDatabase.observeSingleValueEvent(ref, DataSnapshotMapper.listOf(ImageItem.class))
                .subscribe(observer);
    }
}
