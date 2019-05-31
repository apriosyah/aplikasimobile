package com.example.tugasalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer Player;
    @Override
    public void onReceive(Context c, Intent Arg1) {
        Toast.makeText(c, "Alarm Berbunyi", Toast.LENGTH_LONG).show();
        Player = MediaPlayer.create(c, R.raw.kalimba);
        Player.start();

    }
}


