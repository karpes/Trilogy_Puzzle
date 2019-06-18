package karpes_dev.trilogy_pazzle.version1.animation;

import android.view.View;

import com.easyandroidanimations.library.BounceAnimation;

import karpes_dev.trilogy_pazzle.version1.abstractions.IAnimationView;

public class BounceAnimationView implements IAnimationView {
    @Override
    public void animate(View view, long duration) {
        new BounceAnimation(view)
                .setDuration(1000)
                .animate();
    }
}