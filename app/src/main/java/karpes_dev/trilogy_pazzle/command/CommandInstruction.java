package karpes_dev.trilogy_pazzle.command;

import android.content.Intent;
import android.view.View;

import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.activitys.InstructionActivity;

public class CommandInstruction implements ICommand {
    @Override
    public void execute(View viewParent) {
        Intent intent = new Intent(viewParent.getContext(), InstructionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        viewParent.getContext().startActivity(intent);
    }
}
