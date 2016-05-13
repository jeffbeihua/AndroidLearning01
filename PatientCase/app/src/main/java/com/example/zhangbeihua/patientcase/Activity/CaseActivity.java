package com.example.zhangbeihua.patientcase.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.zhangbeihua.patientcase.R;

import com.example.zhangbeihua.patientcase.widget.HTTPEnquire;
import java.util.concurrent.ExecutionException;
import org.json.*;
import android.widget.LinearLayout;
import android.content.DialogInterface.OnClickListener;



public class CaseActivity extends AppCompatActivity {

    private EditText etTag;

    private LinearLayout caseInfoL;
    private Button btnAddRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);
        etTag = (EditText)findViewById(R.id.etTag);
        caseInfoL = (LinearLayout )findViewById(R.id.caseInfoB);
        btnAddRecord = (Button)findViewById(R.id.btnAddRecord);
        caseInfoLListerner();
        btnAddRecordListerner();

        /*String res ="";
        try {
            String[] params = {};
            res = HTTPEnquire.Get("clinic/bodyparts", params);
            etTag.setText(res);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }


    private void caseInfoLListerner() {
        caseInfoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CaseActivity.this, CaseinfoActivity.class);
                startActivity(intent1);
            }
        });

    }
    private void btnAddRecordListerner(){
        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(CaseActivity.this, RecordActivity.class);
                startActivity(intent2);
            }
        });
    }

}
