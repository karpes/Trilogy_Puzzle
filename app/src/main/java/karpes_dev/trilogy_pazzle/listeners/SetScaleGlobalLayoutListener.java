package karpes_dev.trilogy_pazzle.listeners;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import karpes_dev.trilogy_pazzle.abstractions.IFigure;
import karpes_dev.trilogy_pazzle.abstractions.IMathFigure;
import karpes_dev.trilogy_pazzle.abstractions.INeedScale;
import karpes_dev.trilogy_pazzle.abstractions.ISetScaleGlobalLayoutListener;

public class SetScaleGlobalLayoutListener implements ISetScaleGlobalLayoutListener {

    private List<INeedScale> needScales;
    private View parent;
    private IFigure figure;
    private IMathFigure mathFigure;

    public SetScaleGlobalLayoutListener(View parent, IFigure figure, IMathFigure mathFigure) {
        this.parent = parent;
        parent.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.figure = figure;
        this.mathFigure = mathFigure;
        needScales = new ArrayList<>();
    }

    @Override
    public void onGlobalLayout() {
        int width = parent.getWidth();
        int height = parent.getHeight();
        float scale = mathFigure.scaleFigure(figure, width, height);

        for(INeedScale i : needScales){
            i.setFigureScale(scale);
        }
        parent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override
    public void addNeedScales(INeedScale... iNeedScales) {
        needScales.addAll(Arrays.asList(iNeedScales));
    }
}
