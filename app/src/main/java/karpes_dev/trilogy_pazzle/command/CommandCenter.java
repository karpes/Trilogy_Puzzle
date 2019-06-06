package karpes_dev.trilogy_pazzle.command;

import android.view.View;

import karpes_dev.trilogy_pazzle.abstractions.ICommand;

public class CommandCenter implements ICommand {

    private View centerView;

    public CommandCenter(View centerView) {
        this.centerView = centerView;
    }
    @Override
    public void execute(View viewParent) {
        centerView.setScaleX(1f);
        centerView.setScaleY(1f);
        centerView.setTranslationX(1f);
        centerView.setTranslationY(1f);
    }
}
