package com.example.asus.calendarviewtest;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.calendarviewtest.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private CalendarView cv;
    private TextView mtvDate;
    private ArrayList<String> mListDate = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv = findViewById(R.id.cv);

        mtvDate = findViewById(R.id.tvDate);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String strDate = "" + year + "-" + month + "-" + dayOfMonth;
                if (mListDate.contains(strDate)) {
                    for (int index = 0; index < mListDate.size(); index++) {
                        String strItem2 = mListDate.get(index);
                        if (strItem2.equals(strDate)) {
                            mListDate.remove(index);
                            break;
                        }
                    }
                } else {
                    mListDate.add(strDate);
                }
                String strValue = "";
                for (String strItem : mListDate) {
                    strValue = " " + strItem;
                }
                mtvDate.append(strValue);

            }
        });
    }
}