package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Подготовка к тесту");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Дома");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "Необходимо выучить 10 вопросов.");

                GregorianCalendar calDate = new GregorianCalendar(2022, 11, 29);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        calDate.getTimeInMillis());

                startActivity(calIntent);
            }
        });
    }
}