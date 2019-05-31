package com.example.tugasalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class edit extends AppCompatActivity {

    TimePicker myTimePicker;
    Button SetAlarm;
    TextView textalarm;
    TimePickerDialog timePickerDialog;

    final static int RQS_1 = 1;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textalarm = (TextView) findViewById(R.id.txt_alarm);
        SetAlarm = (Button) findViewById(R.id.btn_SetAlarm);
        SetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textalarm.setText("");
                openTimePickerDialog(false);

            }
        });
    }

    private void openTimePickerDialog(boolean is24r) {
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(edit.this, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.setTitle("Set Waktu Alarm");
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();
            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);
            if (calSet.compareTo(calNow) <= 0) {
                calSet.add(Calendar.DATE, 1);
            }
            SetAlarm(calSet);

        }


    };
    private  void SetAlarm( Calendar targetCal){
        textalarm.setText("SET ALARM :"+targetCal.getTime());
        Intent Intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),RQS_1, Intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }

}
