package com.example.cftlabs.date;

import android.app.DatePickerDialog;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.cftlabs.R;

import java.util.Calendar;

public class DateChoose {

    private final Calendar dateAndTime = Calendar.getInstance();
    private final View view;
    private String textTime;

    public DateChoose(View view){
        this.textTime = null;
        this.view = view;
    }

    public void showBirthdayDate(){
        Calendar dateAndTime = Calendar.getInstance();
        new DatePickerDialog(this.view.getContext(), date,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void setBirthday(){
        View tmpView = getView();
        Button buttonBirthday = (Button) tmpView.findViewById(R.id.birthdayButton);
        buttonBirthday.setText(textTime);
    }

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                textTime = (DateUtils.formatDateTime(view.getContext(), dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
                setBirthday();
            }
        };

    private View getView(){
        return this.view;
    }
}
