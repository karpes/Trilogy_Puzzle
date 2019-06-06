package karpes_dev.trilogy_pazzle.managers;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.ExplodeAnimation;


import karpes_dev.trilogy_pazzle.abstractions.ACustomPagerAdapter;
import karpes_dev.trilogy_pazzle.abstractions.IMathPolygon;
import karpes_dev.trilogy_pazzle.abstractions.IPolygon;
import karpes_dev.trilogy_pazzle.abstractions.IPolygonViewManager;
import karpes_dev.trilogy_pazzle.common.Common;
import karpes_dev.trilogy_pazzle.models.Polygon;
import karpes_dev.trilogy_pazzle.views.PolygonView;

public class PolygonViewManager implements IPolygonViewManager<View> {

    //контейнер в который добавляем времменный Polygon
    //RelativeLayout
    private ViewGroup container;
    //PolygonView на которои отрисован контур полигонов
    private View figureView;
    private ACustomPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private IMathPolygon mathPolygon;
    //Временный PolygonView
    private PolygonView newPolygonView;
    private IPolygon polygon;

    private float scale;

    public PolygonViewManager(ViewGroup container, View figureView, ACustomPagerAdapter pagerAdapter, ViewPager viewPager, IMathPolygon mathPolygon) {
        this.container = container;
        this.figureView = figureView;
        this.pagerAdapter = pagerAdapter;
        this.viewPager = viewPager;
        this.mathPolygon = mathPolygon;
        polygon = new Polygon(new float[6]);
    }

    @Override
    public View create(IPolygon polygon, float x, float y, float scale){
        this.scale = scale;
        if(!this.polygon.equals(polygon)) {
            this.polygon = polygon;
            newPolygonView = new PolygonView(container.getContext(), polygon, scale, mathPolygon);
            container.addView(newPolygonView);
        }
        newPolygonView.setX(getX(x));
        newPolygonView.setY(getY(y));
        return newPolygonView;
    }

    /**
     * @param pagerPolygonView - удаление из PagerAdapter
     */
    @Override
    public void remove(View pagerPolygonView) {
        if (pagerPolygonView == null) {
            //Если отрыв пальца
            //Удалить из ViewGroup
            container.removeView(newPolygonView);
            newPolygonView = null;
            polygon = new Polygon(new float[6]);
        }else {
            //Если совпадение
            if(mathPolygon.checkPosition(polygon, newPolygonView.getX(), newPolygonView.getY(), scale)) {
                removeFromViewPager(pagerPolygonView);
            }
        }
    }

    private void removeFromViewPager(final View pagerPolygonView){
        new ExplodeAnimation(pagerPolygonView).setListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
               // int currentItem = viewPager.getCurrentItem();
                //viewPager.setAdapter(null);
                pagerAdapter.removeView(polygon);
                //viewPager.setAdapter(pagerAdapter);
                //viewPager.setCurrentItem(currentItem);

            }
        }).animate();

        //Обнулить
        //Закрасить треугольник
        polygon.setColored(true);
        figureView.invalidate();
        //Удалить из ViewGroup
        container.removeView(newPolygonView);
    }

    public static int s = 0;
    private float getX(float rawX){
        //Смещение экрана
        float translationX = container.getTranslationX();
        //Точка концентрации масштаба
        float pivotX = container.getPivotX();

        //Центр фигуры
        float widthPolygon  = newPolygonView.getWidthPolygon() / 2;

        //Масштаб контейнера
        float scaleParent = container.getScaleX();
        //Масштаб в процентах
        float procScale = (scaleParent - 1) / 3;
        //Формула
        float x = (((rawX) - (widthPolygon )) );
        float centerx = container.getWidth() / 5f * procScale;
        float posx =  (pivotX - centerx) * procScale;

        float testR = getR(container.getWidth(), pivotX, procScale);

        float x1 = ((x / scaleParent) - (translationX / scaleParent) + posx) + testR ;

        return x1;
    }

    private float getR(float size, float puct, float proc){
        float testPivot = getPercent(size, puct);
        float testR = 0;
        if(testPivot < 50f) {
            float s = getPercent(50f, testPivot);
            s = (100 - s) / 100;
            testR = (size / 7f) * s * proc;

        }
        return testR;
    }

    private float getY(float rawY){
        float translationY = container.getTranslationY();
        float pivotY = container.getPivotY();
        /************************************************/
        float heightMargin = Common.SIZE * 6f;
        /***********************************************/

        float heightPolygon = newPolygonView.getHeightPolygon() + heightMargin;
        float scaleParent = container.getScaleX();
        //Масштаб в процентах
        float procScale = (scaleParent - 1f) / 3f;
        float y = (((rawY) - (heightPolygon)) );
        float centerY = container.getHeight()/ 5f * procScale;
        float posy =  (pivotY - centerY) * procScale;


        float testR = getR(container.getHeight(), pivotY, procScale);


        float y1 = ((y / scaleParent) - (translationY / scaleParent) + posy ) + testR ;
        return y1;
    }

    private float getPercent(float all, float puct){
        return puct / all * 100;
    }

}
