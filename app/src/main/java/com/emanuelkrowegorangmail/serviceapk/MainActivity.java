package com.emanuelkrowegorangmail.serviceapk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        EditText editWaktu;
        Button tombolPlay;
        Button tombolStop;
//Mendeklarasikan varible yang digunakan

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//Menghubungkan kelas java dengan kelas XML

            editWaktu = (EditText) findViewById(R.id.et_waktu);
            tombolPlay = (Button) findViewById(R.id.bt_play);
            tombolStop = (Button) findViewById(R.id.bt_stop);
            tombolPlay.setOnClickListener(this);
            tombolStop.setOnClickListener(this);
        }

        public void onClick(View view) {
            switch (view.getId()){
                //Mendeklarasikan onclick
                case R.id.bt_play:
                    callPlay();
                    break;
                    //jika bt play di klik maka lagu diputar dan dibreak
                case R.id.bt_stop:
                    stopPlay();
                    //jika butoon stop diklik maka lagu akan di hentikan
            }
        }

        private void callPlay() {
            int detik = Integer.parseInt(editWaktu.getText().toString());
            Intent intent = new Intent(MainActivity.this, MyService.class);

            PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            if (alarmManager !=null){
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()
                        + (detik*1000),pendingIntent);
                Toast.makeText(getApplicationContext(),"Song Play After "+detik+" seconds !",Toast.LENGTH_LONG).show();
            }
        }

        private void stopPlay() {
            stopService(new Intent(MainActivity.this, MyService.class));
        }
    }