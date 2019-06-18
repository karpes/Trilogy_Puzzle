package karpes_dev.trilogy_pazzle.version2.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import karpes_dev.trilogy_pazzle.version2.constants.Database;
import karpes_dev.trilogy_pazzle.version2.interfaces.database.IDatabaseLoader;
import karpes_dev.trilogy_pazzle.version2.interfaces.item.IImageItem;
import karpes_dev.trilogy_pazzle.version2.item.ImageItem;

public class ImageLoader implements IDatabaseLoader<IImageItem> {
    @Override
    public List<IImageItem> load() {
        final List<IImageItem> imageItems = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference()
                .child(Database.IMAGES.getUrl());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, ImageItem>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, ImageItem>>() {};
                Map<String, ImageItem> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                assert objectHashMap != null;
                imageItems.addAll(objectHashMap.values());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return imageItems;
    }
}
