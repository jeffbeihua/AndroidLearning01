package com.example.zhangbeihua.test1;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Created by zhangbeihua on 8/05/16.
 */
public class IndexActivity extends Activity {
    private Button btnMainActivity, btnSecondActivity, btnActivityLifeCycle;
    private ButtonListener listener;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //绑定布局文件
        setContentView(R.layout.activity_index);

        listener = new ButtonListener();

        FindView();

        SetClickListener();
    }

    private void SetClickListener() {
        btnMainActivity.setOnClickListener(listener);
        btnSecondActivity.setOnClickListener(listener);
        btnActivityLifeCycle.setOnClickListener(listener);
    }

    private void FindView() {
        btnMainActivity = (Button) findViewById(R.id.btnMainActivity);
        btnSecondActivity = (Button) findViewById(R.id.btnSecondActivity);
        btnActivityLifeCycle = (Button) findViewById(R.id.btnActivityLifeCycle);
    }

    private class ButtonListener implements View.OnClickListener{
        public void onClick(View view){
            switch (view.getId()){
                case R.id.btnMainActivity:
                    Intent i1 = new Intent(IndexActivity.this,MainActivity.class);
                    startActivity(i1);
                    break;
                case R.id.btnSecondActivity:
                    Intent i2 = new Intent(IndexActivity.this,SecondActivity.class);
                    startActivity(i2);
                    break;
                case R.id.btnActivityLifeCycle:
                    Intent i3= new Intent(IndexActivity.this, ActivityLifeCycle.class);
                    startActivity(i3);
                    break;


            }
        }
    }



}
