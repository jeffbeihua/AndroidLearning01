package com.example.zhangbeihua.patientcase.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhangbeihua.patientcase.R;

import java.net.HttpURLConnection;
//import com.example.zhangbeihua.patientcase.widget.AlertDialogHelper;


public class CaseActivity extends AppCompatActivity {

    EditText etTag;
    HttpURLConnection urlConnection = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        etTag = (EditText)findViewById(R.id.etTag);

    }



}
