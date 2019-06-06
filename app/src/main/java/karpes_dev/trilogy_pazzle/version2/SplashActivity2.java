package karpes_dev.trilogy_pazzle.version2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.easyandroidanimations.library.FadeOutAnimation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.paperdb.Paper;
import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version2.constants.Database;
import karpes_dev.trilogy_pazzle.version2.model.CategoryItem;

public class SplashActivity2 extends AppCompatActivity {

    /**
     *ReaderSVG
     *Glide
     */

    private View parent;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        parent = findViewById(R.id.splash_parent);
        Paper.init(this);
        get();

        Log.d("onNext()", "End");

    }


    private List<CategoryItem> get(){
        final List<CategoryItem> imageItems = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference()
                .child(Database.CATEGORY.getUtl());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, CategoryItem>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, CategoryItem>>() {};
                Map<String, CategoryItem> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                assert objectHashMap != null;
                imageItems.addAll(objectHashMap.values());
                Log.d("onNext()", "All list size = " + imageItems.size());
                Toast.makeText(SplashActivity2.this, "All", Toast.LENGTH_SHORT).show();
                FadeOutAnimation animation = new FadeOutAnimation(parent);
                animation.setListener(animation1 -> setContentView(R.layout.instruction_layout));
                animation.animate();


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return imageItems;
    }

}
