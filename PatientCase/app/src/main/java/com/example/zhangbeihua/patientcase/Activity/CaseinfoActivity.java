package com.example.zhangbeihua.patientcase.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zhangbeihua.patientcase.R;

import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * Created by zhangbeihua on 12/05/16.
 */
public class CaseinfoActivity extends AppCompatActivity {

    private EditText etDate;
    int year_x, month_x, day_x;

    static final int DILOG_ID = 0 ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caseinfo);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnClick();

    }


    public void showDialogOnClick(){
        etDate = (EditText) this.findViewById(R.id.etDate);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DILOG_ID);
            }
        });
    }

    @Override
    protected  Dialog onCreateDialog(int id){
       if (id == DILOG_ID)
           return new DatePickerDialog(this,dpickerListner, year_x,month_x,day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;
            Toast.makeText(CaseinfoActivity.this, year_x+"/"+month_x,Toast.LENGTH_SHORT).show();

            etDate.setText(year_x+"/"+month_x+"/"+day_x);
        }
    };

}
