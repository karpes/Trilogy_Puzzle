package karpes_dev.trilogy_pazzle.listeners;

import android.content.Intent;
import android.view.View;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.BounceAnimation;

import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.activitys.FigureColoringActivity;
import karpes_dev.trilogy_pazzle.common.Common;

public class OnImageModelClickListener implements View.OnClickListener {

    private int id;

    public OnImageModelClickListener( int id) {
        this.id = id;
    }

    @Override
    public void onClick(final View view) {
        Animation animation = new BounceAnimation(view);
        ((BounceAnimation) animation).setListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                Common.id_model = id;
                Intent intent = new Intent(view.getContext(), FigureColoringActivity.class);
                intent.putExtra("id", id);
                view.getContext().startActivity(intent);
            }
        });
        animation.animate();
    }
}
