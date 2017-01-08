package nghiavo.baomoiclone.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by nghiavo on 12/30/16.
 */
public class Functions {
    public static void showSimpleAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }
}
