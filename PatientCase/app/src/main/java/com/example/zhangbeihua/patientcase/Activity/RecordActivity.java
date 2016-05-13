package com.example.zhangbeihua.patientcase.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangbeihua.patientcase.R;

import java.util.Calendar;


/**
 * Created by zhangbeihua on 12/05/16.
 */
public class RecordActivity extends AppCompatActivity {
    private TextView etDate;
    int year_x, month_x, day_x;

    static final int DILOG_ID = 0 ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnClick();
    }


    public void showDialogOnClick(){
        etDate = (TextView)findViewById(R.id.etDate);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DILOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
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
            Toast.makeText(RecordActivity.this, year_x + "/" + month_x, Toast.LENGTH_SHORT).show();

            etDate.setText(year_x+"/"+month_x+"/"+day_x);
        }
    };
}
