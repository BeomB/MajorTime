package com.example.majortime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;


public class hwAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//
        Intent sintent = new Intent(context,hwAlarmService.class);
        sintent.putExtra("state",intent.getStringExtra("state"));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(sintent);
        } else {
            context.startService(sintent);
        }
    }
}
