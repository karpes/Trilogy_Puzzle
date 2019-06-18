package karpes_dev.trilogy_pazzle.version2.database;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.DataSnapshotMapper;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import karpes_dev.trilogy_pazzle.version2.constants.Database;
import karpes_dev.trilogy_pazzle.version2.interfaces.database.IDatabaseLoader;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.ICategoryItem;
import karpes_dev.trilogy_pazzle.version2.item.CategoryItem;

public class CategoryLoader implements IDatabaseLoader<ICategoryItem> {

    @Override
    public List<ICategoryItem> load() {

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference()
                .child(Database.CATEGORY.getUrl());
        RxFirebaseDatabase.observeSingleValueEvent(ref, DataSnapshotMapper.listOf(CategoryItem.class))
                .subscribe(blogPost -> {
                    Log.d("RXJAVA", blogPost.size() + "< ");
                });
        final List<ICategoryItem> categoryItems = new ArrayList<>();
        return categoryItems;
    }
}
