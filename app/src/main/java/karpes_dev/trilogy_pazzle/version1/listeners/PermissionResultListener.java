package karpes_dev.trilogy_pazzle.version1.listeners;

import android.view.View;
import android.widget.Toast;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.abstractions.ICommand;
import permission.auron.com.marshmallowpermissionhelper.PermissionResult;

public class PermissionResultListener implements PermissionResult {

    private View parentView;
    private ICommand commandDownload;

    public PermissionResultListener(View parentView) {
        this.parentView = parentView;
    }
    public PermissionResultListener(View parentView, ICommand commandDownload) {
        this.parentView = parentView;
        this.commandDownload = commandDownload;
    }

    @Override
    public void permissionGranted() {
        Toast.makeText(parentView.getContext(), parentView.getContext().getString(R.string.isgranted), Toast.LENGTH_SHORT).show();
        if(commandDownload != null)
            commandDownload.execute(parentView);
    }

    @Override
    public void permissionDenied() {
        Toast.makeText(parentView.getContext(), parentView.getContext().getString(R.string.isnotgranted), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void permissionForeverDenied() {
        Toast.makeText(parentView.getContext(), parentView.getContext().getString(R.string.isnotgranted), Toast.LENGTH_SHORT).show();
    }
}
