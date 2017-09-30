package metrowebz.com.quizforyou.Extras;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Abhilash on 10-02-2017.
 */

public class InsistToPlay extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context){
//        PendingIntent intent = new PendingIntent();

        NotificationCompat.Builder notifictn = new NotificationCompat.Builder(context);
        notifictn.setAutoCancel(true);
        notifictn.setContentTitle("Quiz For You");
        notifictn.setContentText("Don't miss out to learn new topics today.");

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notifictn.build());

    }
}
