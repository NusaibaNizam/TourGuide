package org.a55889966.bleach.saran.tourguide;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import android.text.TextUtils;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.ArrayList;
import java.util.List;


public class GeofencePendingIntentService extends IntentService {

    // Entered : BDBL, Basundhara Shopping Complex
    public GeofencePendingIntentService() {
        super("GeofencePendingIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        GeofencingEvent event = GeofencingEvent.fromIntent(intent);
        int transitionType = event.getGeofenceTransition();
        List<Geofence> triggeringGeofences = event.getTriggeringGeofences();
        String transitionString = "";
        switch (transitionType){
            case Geofence.GEOFENCE_TRANSITION_ENTER:
                transitionString = "Entered";
                break;
                case Geofence.GEOFENCE_TRANSITION_EXIT:
                    transitionString = "Exited";
        }

        ArrayList<String>triggeringGeofenceIDs = new ArrayList<>();

        for(Geofence g : triggeringGeofences){
            triggeringGeofenceIDs.add(g.getRequestId());
        }

        String notificationString = transitionString+" : "+ TextUtils.join(", ",triggeringGeofenceIDs);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String id = "org.a55889966.bleach.saran.tourguide.888.000.###";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // The user-visible name of the channel.
            CharSequence name = "Product";
            // The user-visible description of the channel.
            String description = "Notifications regarding our products";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = null;
            mChannel = new NotificationChannel(id, name,importance);

            // Configure the notification channel.
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            // Sets the notification light color for notifications posted to this
            // channel, if the device supports this feature.
            mChannel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(mChannel);
        }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,id)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Happy Travelling!")
                    .setContentText(notificationString)
                    .setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setPriority(NotificationCompat.PRIORITY_MAX);

            notificationManager.notify(919,builder.build());

    }
}
