package pushnotification.sample.com.samplepushnotification;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.security.DomainCombiner;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService
{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        try
        {
            Map<String, String> data = remoteMessage.getData();

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            NotificationCompat.Builder notificationCompatBuilder = new NotificationCompat.Builder(this);

            notificationCompatBuilder.setContentIntent(pendingIntent);
            notificationCompatBuilder.setContentText(remoteMessage.getNotification().getBody());
            notificationCompatBuilder.setContentTitle(remoteMessage.getNotification().getTitle());

            notificationCompatBuilder.setAutoCancel(true);
            notificationCompatBuilder.setSmallIcon(R.mipmap.ic_launcher);
            notificationCompatBuilder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationCompatBuilder.build());
        }
        catch (Exception e){
            Log.d("onMessageReceived => ", e.getMessage());
        }
    }
}
