package karpes_dev.trilogy_pazzle.managers;

import android.support.v7.widget.RecyclerView;

import karpes_dev.trilogy_pazzle.abstractions.IAdapter;
import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.adapters.RecyclerAdapter;
import karpes_dev.trilogy_pazzle.viewholders.ImageViewHolder;

public class RecyclerAdapterManager implements IAdapter {

    public RecyclerAdapterManager() {
        recyclerAdapter = new RecyclerAdapter();
    }

    RecyclerView.Adapter<ImageViewHolder> recyclerAdapter;


    @Override
    public RecyclerView.Adapter getRecyclerAdapter() {
        return recyclerAdapter;
    }

    @Override
    public void startListening() {
        //
    }

    @Override
    public void stopListening() {
        //
    }
}
