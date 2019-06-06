package karpes_dev.trilogy_pazzle.version1.abstractions;

import android.support.v7.widget.RecyclerView;

public interface IAdapter {
    public RecyclerView.Adapter getRecyclerAdapter();
    public void startListening();
    public void stopListening();
}
