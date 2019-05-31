package com.example.tugasalarm;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class coba extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText txt_tgl, txt_jam, txt_nama, txt_keterangan;
    Button btn_get_datetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        txt_nama = (EditText) findViewById(R.id.txt_nama);
        txt_keterangan = (EditText) findViewById(R.id.txt_keterangan);
        txt_tgl = (EditText) findViewById(R.id.txt_tgl);
        txt_jam = (EditText) findViewById(R.id.txt_jam);
        btn_get_datetime = (Button) findViewById(R.id.btn_get_datetime);


        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        txt_tgl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(coba.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txt_jam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(coba.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        txt_jam.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        btn_get_datetime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(coba.this,
                        "Nama Tugas : "+ txt_nama.getText() .toString() +"\n"+
                                "Keterangan Tugas : " + txt_keterangan.getText().toString() + "\n" +
                                "Tanggal : " + txt_tgl.getText().toString() + "\n" +
                                "Jam : " + txt_jam.getText().toString()

                        , Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl.setText(sdf.format(myCalendar.getTime()));
    }

}