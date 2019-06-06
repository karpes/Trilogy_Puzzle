package karpes_dev.trilogy_pazzle.version1.command;

import android.content.Intent;
import android.view.View;

import karpes_dev.trilogy_pazzle.version1.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.version1.activitys.SettingActivity;

public class CommandSetting implements ICommand {
    @Override
    public void execute(View viewParent) {
        Intent intent = new Intent(viewParent.getContext(), SettingActivity.class);
        viewParent.getContext().startActivity(intent);
    }
}
