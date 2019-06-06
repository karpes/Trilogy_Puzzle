package karpes_dev.trilogy_pazzle.version1.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.abstractions.ACustomPagerAdapter;
import karpes_dev.trilogy_pazzle.version1.abstractions.IFigure;
import karpes_dev.trilogy_pazzle.version1.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.version1.abstractions.IPolygonListenerManager;
import karpes_dev.trilogy_pazzle.version1.views.PolygonView;

public class PolygonViewPagerAdapter extends ACustomPagerAdapter {

    private IMathPolygon mathPolygon;
    private List<IPolygon> adapterPolygons;
    private IPolygonListenerManager manager;

    public PolygonViewPagerAdapter(IFigure figure, IPolygonListenerManager movePolygonListener, IMathPolygon mathPolygon) {
        initPolygonList(figure);
        this.mathPolygon = mathPolygon;
        this.manager = movePolygonListener;
    }

    private void initPolygonList(IFigure figure) {
        adapterPolygons = new ArrayList<>();
        List<IPolygon> figurePolygons = figure.getPolygons();
        for (IPolygon p : figurePolygons) {
            if (!p.isColored()) {
                adapterPolygons.add(p);
            }
        }
    }

    @Override
    public int getCount() {
        return adapterPolygons.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = load(container, inflater, position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    private View load(ViewGroup container, LayoutInflater inflater, int position) {
        View view = inflater.inflate(R.layout.polygon_model, container, false);

        PolygonView polygonView = view.findViewById(R.id.polygon);
        polygonView.setMathPolygon(mathPolygon);
        polygonView.setPolygon(adapterPolygons.get(position));
        manager.setListener(polygonView, adapterPolygons.get(position));
        container.addView(view);
        return view;
    }


    @Override
    public void removeView(Object object) {
        adapterPolygons.remove(object);
        notifyDataSetChanged();
    }

    @Override
    public float getPageWidth(int position) {
       return 0.25f;
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
