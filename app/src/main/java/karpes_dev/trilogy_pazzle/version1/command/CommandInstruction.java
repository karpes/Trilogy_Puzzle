package karpes_dev.trilogy_pazzle.version1.command;

import android.content.Intent;
import android.view.View;

import karpes_dev.trilogy_pazzle.version2.interfaces.ICommand;
import karpes_dev.trilogy_pazzle.version1.activitys.InstructionActivity;

public class CommandInstruction implements ICommand {
    @Override
    public void execute(View viewParent) {
        Intent intent = new Intent(viewParent.getContext(), InstructionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        viewParent.getContext().startActivity(intent);
    }
}
