package karpes_dev.trilogy_pazzle.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.models.FigureModel;
import karpes_dev.trilogy_pazzle.viewholders.ImageViewHolder;


public class RecyclerAdapter extends RecyclerView.Adapter<ImageViewHolder>{


    private FigureList figureList;

    public RecyclerAdapter() {
        if(figureList == null){
            figureList = new FigureList();
        }
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.wallpaper_item, viewGroup, false);
        int height = viewGroup.getMeasuredHeight();
        itemView.setMinimumHeight(height);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, int i) {
        holder.bind(figureList.figureModels.get(i), i);
    }

    @Override
    public int getItemCount() {
        return figureList.getFigureModels().size();
    }

    class FigureList{

        public FigureList() {
            init();
        }

        public List<FigureModel> figureModels = new ArrayList<>();

        private void init() {
            FigureModel k1 =  new FigureModel( R.drawable.png1 );
            FigureModel k2 =  new FigureModel( R.drawable.png2 );
            FigureModel k3 =  new FigureModel( R.drawable.png3 );
            FigureModel k4 =  new FigureModel( R.drawable.png4 );
            FigureModel k5 =  new FigureModel( R.drawable.png5 );
            FigureModel k6 =  new FigureModel( R.drawable.png6 );
            FigureModel k7 =  new FigureModel( R.drawable.png7 );
            FigureModel k8 =  new FigureModel( R.drawable.png8 );
            FigureModel k9 =  new FigureModel( R.drawable.png9 );
            FigureModel k10 = new FigureModel( R.drawable.png10);

            figureModels.add(k1);
            figureModels.add(k2);
            figureModels.add(k3);
            figureModels.add(k4);
            figureModels.add(k5);
            figureModels.add(k6);
            figureModels.add(k7);
            figureModels.add(k8);
            figureModels.add(k9);
            figureModels.add(k10);

        }

        public List<FigureModel> getFigureModels() {
            return figureModels;
        }
    }

}
