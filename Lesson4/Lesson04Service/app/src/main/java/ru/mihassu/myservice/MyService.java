package ru.mihassu.myservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

public class MyService extends Service {

    private final String CHANNEL_ID = "1";
    int messageId = 0;
    private final String TAG = "MyService";
    private MyLoader myLoader;

    @Override
    public void onCreate() {
        logIt("onCreate()");
        myLoader = new MyLoader(new ProgressListener() {
            @Override
            public void onStatusChanged(String status) {
                Toast.makeText(MyService.this, status, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete(Integer result) {
                makeNote(result);
                Toast.makeText(MyService.this, "Результат: " + result, Toast.LENGTH_SHORT).show();
                stopSelf();
            }
        });
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        logIt("onStartCommand()");

        String valueStr = intent.getStringExtra(MainActivity.VALUE_EXTRA);
        int value = Integer.parseInt(valueStr);
        myLoader.execute(value);
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        logIt("onDestroy()");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void makeNote(int message){
        String channelId = createChannel(this);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Результат")
                .setContentText(String.valueOf(message));
        Intent resultIntent = new Intent(this, PlayerService.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        builder.setContentIntent(resultPendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(messageId++, builder.build());    }



    private String createChannel(Service service) {
        NotificationManager nManager =
                (NotificationManager) service.getSystemService(Context.NOTIFICATION_SERVICE);

        CharSequence channelName = "MyChannel";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel notificationChannel = new NotificationChannel(
                CHANNEL_ID, channelName, importance
        );

        nManager.createNotificationChannel(notificationChannel);
        return CHANNEL_ID;
    }

    private void logIt(String msg) {
        Log.d(TAG, msg);
    }
}
