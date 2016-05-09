package com.example.zhangbeihua.test1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

public class DataActivity extends AppCompatActivity {

    private Button btnReturnActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        /*Intent intent=this.getIntent();
        Bundle bundle= intent.getExtras();

        String strGetMsg = intent.getStringExtra("msg");
        int Year = bundle.getInt("year");
        double score = bundle.getDouble("score");
        Toast.makeText(this, strGetMsg+"/"+Year+"/"+score, Toast.LENGTH_LONG).show();*/
        btnReturnActivity = (Button)findViewById(R.id.btnReturnActivity);
        btnReturnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strGetMsg= getIntent().getStringExtra("joke");
                if (strGetMsg.equals("joke")){
                    Intent intentData = new Intent();
                    intentData.putExtra("ma","mayunmayili");
                    setResult(RESULT_OK, intentData);//setResult 过后必须 finish()
                    finish();
                }else{
                    Intent intentData = new Intent();
                    setResult(RESULT_CANCELED,intentData);
                    finish();
                }
            }
        });
    }





}
