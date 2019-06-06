package karpes_dev.trilogy_pazzle.command;

import android.view.View;
import android.view.ViewGroup;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.FadeInAnimation;
import com.easyandroidanimations.library.FadeOutAnimation;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.abstractions.ACustomPagerAdapter;
import karpes_dev.trilogy_pazzle.abstractions.AFigureView;
import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.abstractions.IFigure;
import karpes_dev.trilogy_pazzle.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.abstractions.IPolygonListenerManager;
import karpes_dev.trilogy_pazzle.abstractions.IPolygonViewManager;
import karpes_dev.trilogy_pazzle.abstractions.IReader;
import karpes_dev.trilogy_pazzle.adapters.PolygonViewPagerAdapter;
import karpes_dev.trilogy_pazzle.managers.PolygonViewManager;
import karpes_dev.trilogy_pazzle.models.Figure;
import karpes_dev.trilogy_pazzle.models.ReaderSVG;
import karpes_dev.trilogy_pazzle.views.CustomViewPager;

public class CommandRestart implements ICommand {

    private int id;
    private AFigureView figureView;
    private IFigure figure;
    private IMathPolygon mathPolygon;
    private IPolygonListenerManager polygonListenerManager;
    private ViewGroup relativeLayoutContainer;

    public CommandRestart(int id, IFigure figure, AFigureView figureView, IMathPolygon mathPolygon, IPolygonListenerManager polygonListenerManager, ViewGroup relativeLayoutContainer) {
        this.id = id;
        this.figure = figure;
        this.figureView = figureView;
        this.mathPolygon = mathPolygon;
        this.polygonListenerManager = polygonListenerManager;
        this.relativeLayoutContainer = relativeLayoutContainer;
    }

    @Override
    public void execute(final View viewParent) {
        IReader readerSVG = new ReaderSVG(figureView.getContext(), id);
        final IFigure figure = new Figure(readerSVG.read(), mathPolygon);
        this.figure.setPolygons(figure.getPolygons());
        new FadeOutAnimation(figureView).setListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                figureView.setDrawFigure(figure);
                CustomViewPager viewPager = viewParent.findViewById(R.id.rv);
                ACustomPagerAdapter polygonAdapter = new PolygonViewPagerAdapter(figure, polygonListenerManager, mathPolygon);
                viewPager.setAdapter(polygonAdapter);
                IPolygonViewManager polygonViewManager = new PolygonViewManager(relativeLayoutContainer, figureView, polygonAdapter, viewPager, mathPolygon);
                polygonListenerManager.setManager(polygonViewManager);
                viewPager.setAdapter(polygonAdapter);
                new FadeInAnimation(figureView).animate();
            }
        }).animate();
    }
}
