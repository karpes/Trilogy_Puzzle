package karpes_dev.trilogy_pazzle.version2.interfaces;

import android.support.v7.widget.RecyclerView;

public interface IModel {

    public void init(ICommand command);
    public void showCategory(RecyclerView rv);
}
