package karpes_dev.trilogy_pazzle.version1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.models.InstructionModel;

public class InstructionAdapter extends PagerAdapter {



    public static List<InstructionModel> images;
    private AppCompatActivity activity;
    private LayoutInflater inflater;

    public InstructionAdapter(AppCompatActivity activity) {
        this.activity = activity;
        images = new ArrayList<>();
        images.add(new InstructionModel(R.drawable.i1, R.drawable.i2,activity.getString(R.string.i1)));
        images.add(new InstructionModel(R.drawable.i3, R.drawable.i4,activity.getString(R.string.i2)));
        images.add(new InstructionModel(R.drawable.i5,R.drawable.i6, activity.getString(R.string.i3)));
        images.add(new InstructionModel(R.drawable.i7,R.drawable.i8, activity.getString(R.string.i4)));

    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = new View(container.getContext());
        if(inflater != null) {
            view = load(container, position);
        }
        else {
            try {
                inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = load(container, position);
            }catch (InflateException e){
                Log.d("Exception", e.getMessage());
            }
        }
        return view;
    }

    private View load(ViewGroup container, int position){
        View view = inflater.inflate(R.layout.instruction_item, container, false);
        ImageView iv = view.findViewById(R.id.image);
        ImageView iv1 = view.findViewById(R.id.image1);
        DisplayMetrics dis = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dis);
        iv.setMinimumHeight(dis.heightPixels);
        iv.setMinimumWidth(dis.widthPixels);

        Glide.with(activity.getApplicationContext())
                .load(images.get(position).getCount())
                .into(iv);

        Glide.with(activity.getApplicationContext())
                .load(images.get(position).getCount2())
                .into(iv1);

        TextView tv = view.findViewById(R.id.tv);
        tv.setText(images.get(position).getText());

        container.addView(view);
        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}