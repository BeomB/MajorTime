package com.example.majortime;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class hwAlarmService extends Service {

    private MediaPlayer mediaPlayer;
    private boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = createNotificationChannel();
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,intent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
            Notification notification = builder.setOngoing(true)
                    .setSmallIcon(R.drawable.sung)
                    .setTicker("과제")
                    .setWhen(System.currentTimeMillis())
                    .setNumber(1)
                    .setContentTitle("과제는 완료했나요?")
                    .setContentText("내일이 제출입니다.")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true).build();
            startForeground(1, notification);
        }

        String state = intent.getStringExtra("state");

        if (!this.isRunning && state.equals("on")) {
            this.mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
            this.mediaPlayer.start();

            this.isRunning = true;
            Log.d("AlarmService", "Alarm Start");
        } else if (this.isRunning & state.equals("off")) {
            this.mediaPlayer.stop();
            this.mediaPlayer.reset();
            this.mediaPlayer.release();

            this.isRunning = false;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                stopForeground(true);
            }
        }
        return START_NOT_STICKY;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private String createNotificationChannel() {
        String channelId = "Alarm";
        String channelName = getString(R.string.app_name);
        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE);
        channel.setSound(null, null);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        manager.createNotificationChannel(channel);

        return channelId;
    }
}