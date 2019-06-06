package karpes_dev.trilogy_pazzle.managers;

import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import karpes_dev.trilogy_pazzle.adapters.FirebaseDatabaseAdapter;
import karpes_dev.trilogy_pazzle.common.Common;
import karpes_dev.trilogy_pazzle.abstractions.IAdapter;
import karpes_dev.trilogy_pazzle.models.ImageModel;
import karpes_dev.trilogy_pazzle.viewholders.ImageViewHolder;

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
