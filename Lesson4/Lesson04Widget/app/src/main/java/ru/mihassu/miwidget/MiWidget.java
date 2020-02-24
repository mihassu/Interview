package ru.mihassu.miwidget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MiWidget extends AppWidgetProvider {

    public static String ACTION_WIDGET_RECEIVER = "ActionWidgetReceiver";

    private final String TAG = "MiWidget";
    private final String MESSAGE = "msg";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds);
        logIt("onUpdate");
        for (int appWidgetId: appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        CharSequence text = context.getString(R.string.app_name);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mi_widget);
        remoteViews.setTextViewText(R.id.tv_widget_text, String.format("%s - %d", text, appWidgetId));

        Intent intent = new Intent(context, MiWidget.class);
        intent.setAction(ACTION_WIDGET_RECEIVER);
        intent.putExtra(MESSAGE, "Updated");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                0 ,
                intent,
                0);

        remoteViews.setOnClickPendingIntent(R.id.button_update, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        logIt("onReceive");

        if (intent.getAction().equals(ACTION_WIDGET_RECEIVER)) {
            String msg = intent.getStringExtra(MESSAGE);
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        logIt("onDeleted");
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        logIt("onEnabled");
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        logIt("onDisabled");
        super.onDisabled(context);
    }

    private void logIt(String message) {
        Log.d(TAG, message);
    }
}
