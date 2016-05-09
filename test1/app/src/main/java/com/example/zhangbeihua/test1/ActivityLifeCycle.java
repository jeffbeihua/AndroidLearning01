package com.example.zhangbeihua.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by zhangbeihua on 9/05/16.
 */
public class ActivityLifeCycle extends Activity{

    private EditText etMessageBox;
    private Button btnSendMessage;
    private int count;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        if (savedInstanceState!=null){
            count = savedInstanceState.getInt("count");
            Toast.makeText(this,"count="+count,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"count=0",Toast.LENGTH_SHORT).show();
        }

        btnSendMessage = (Button)findViewById(R.id.btnSendMessage);
        etMessageBox = (EditText)findViewById(R.id.etMessageBox);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMsg = etMessageBox.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("msg", strMsg);
                intent.setClass(ActivityLifeCycle.this,DataActivity.class);
                startActivity(intent);
            }
        });


        Log.i("ActivityLifeCycle","onCreate done");
    }
    //自动载入   code to override method
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifeCycle", "onStart done");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityLifeCycle", "onRestart done");
    }

    @Override
    protected void onResume() {
        super.onResume();
        count ++;
        Log.e("ActivityLifeCycle", "onResume done");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("ActivityLifeCycle", "onPause done");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.wtf("ActivityLifeCycle", "onStop done");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ActivityLifeCycle", "onDestory done");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count",count);
    }
}
