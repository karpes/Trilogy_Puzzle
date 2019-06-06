package karpes_dev.trilogy_pazzle.command;

import android.Manifest;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.UUID;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.abstractions.ICommand;
import karpes_dev.trilogy_pazzle.abstractions.IPermission;
import karpes_dev.trilogy_pazzle.common.Common;
import karpes_dev.trilogy_pazzle.listeners.PermissionResultListener;
import permission.auron.com.marshmallowpermissionhelper.PermissionUtils;

public class CommandDownload implements ICommand {

    private View imageFrom;
    private IPermission storagePermission;

    public CommandDownload(View imageFrom, IPermission storagePermission) {
        this.imageFrom = imageFrom;
        this.storagePermission = storagePermission;
    }

    @Override
    public void execute(View viewParent) {
        ICommand commandInner = new CommandDownloadInner();
        if(storagePermission.isPermissionGranted(viewParent.getContext(), PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE)){
            commandInner.execute(viewParent);
        }else {
            storagePermission.askCompactPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, new PermissionResultListener(viewParent, commandInner));
        }

    }

    private class CommandDownloadInner implements ICommand{

        @Override
        public void execute(View viewParent) {
            Bitmap bitmap = Common.getBitmapFromView(imageFrom);
            String file = UUID.randomUUID().toString() + ".png";
            ContentResolver contentResolver = viewParent.getContext().getContentResolver();
            if (contentResolver != null) {
                MediaStore.Images.Media.insertImage(contentResolver, bitmap, file, "image");
                Toast.makeText(viewParent.getContext(), viewParent.getContext().getString(R.string.downloadImage), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
