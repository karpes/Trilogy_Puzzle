package karpes_dev.trilogy_pazzle.version1.managers;

import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import karpes_dev.trilogy_pazzle.version1.adapters.FirebaseDatabaseAdapter;
import karpes_dev.trilogy_pazzle.version1.common.Common;
import karpes_dev.trilogy_pazzle.version1.abstractions.IAdapter;
import karpes_dev.trilogy_pazzle.version1.models.ImageModel;
import karpes_dev.trilogy_pazzle.version1.viewholders.ImageViewHolder;

public class FirebaseAdapterManager implements IAdapter {

    private FirebaseRecyclerAdapter<ImageModel, ImageViewHolder> adapter;

    public FirebaseAdapterManager() {
        adapter = new FirebaseDatabaseAdapter(init());
    }

    private FirebaseRecyclerOptions<ImageModel> init(){
        Query query = FirebaseDatabase
                .getInstance()
                .getReference(Common.STR_IMAGES);
        return new FirebaseRecyclerOptions.Builder<ImageModel>()
                .setQuery(query, ImageModel.class)
                .build();
    }

    @Override
    public RecyclerView.Adapter getRecyclerAdapter() {
        return adapter;
    }

    @Override
    public void startListening() {
        adapter.startListening();
    }

    @Override
    public void stopListening() {
        adapter.stopListening();
    }
}
