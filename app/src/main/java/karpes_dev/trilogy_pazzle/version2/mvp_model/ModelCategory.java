package karpes_dev.trilogy_pazzle.version2.mvp_model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.DataSnapshotMapper;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import java.util.List;

import karpes_dev.trilogy_pazzle.version2.constants.Database;
import karpes_dev.trilogy_pazzle.version2.interfaces.mvp_model.IModelCategory;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;
import rx.Observer;

public class ModelCategory implements IModelCategory {

    @Override
    public void loadCategoryItems(Observer<List<CategoryItem>> observer) {
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference()
                .child(Database.CATEGORY.getUrl());
        RxFirebaseDatabase.observeSingleValueEvent(ref, DataSnapshotMapper.listOf(CategoryItem.class))
                .subscribe(observer);
    }
}
