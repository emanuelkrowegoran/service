package com.emanuelkrowegorangmail.serviceapk;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.MediaController;

public class MyService extends Service {
   MediaPlayer mediaPlayer;

   public IBinder onBind(Intent intent){
       return null;
   }


    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this,R.raw.perfect);
        mediaPlayer.setLooping(true);
    }

    public int onStartCommand(Intent intent, int flags,int startId) {
        mediaPlayer.start();
        return  START_STICKY;
    }
    public void onDestroy(){
        mediaPlayer.stop();
    }

}
