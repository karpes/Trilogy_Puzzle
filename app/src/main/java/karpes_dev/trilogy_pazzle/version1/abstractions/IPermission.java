package karpes_dev.trilogy_pazzle.version1.abstractions;

import android.content.Context;

import permission.auron.com.marshmallowpermissionhelper.PermissionResult;

public interface IPermission {
    public boolean isPermissionGranted(Context context, String permission);
    public void askCompactPermission(String permission, PermissionResult permissionResult);
}
