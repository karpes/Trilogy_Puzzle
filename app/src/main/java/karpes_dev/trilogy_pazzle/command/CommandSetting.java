package karpes_dev.trilogy_pazzle.command;

import android.content.Intent;
import android.view.View;

import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.activitys.SettingActivity;

public class CommandSetting implements ICommand {
    @Override
    public void execute(View viewParent) {
        Intent intent = new Intent(viewParent.getContext(), SettingActivity.class);
        viewParent.getContext().startActivity(intent);
    }
}
