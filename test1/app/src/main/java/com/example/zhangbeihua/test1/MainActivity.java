package com.example.zhangbeihua.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnGetMoney;
    private TextView tvGetMoney;
    private Button btnLoseMoney;
    private EditText etGoalMoney;

    private RadioGroup rgSuvery;

    private Button btnSwitch;

    private ImageButton ibTimeGoing;
    private ProgressBar pbTimeWaiting;




    //private CheckBox cbLOL, cbRuning;
    private int money = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        btnGetMoney = (Button)findViewById(R.id.btnGetMoney);
        btnLoseMoney = (Button)findViewById(R.id.btnLoseMoney);
        tvGetMoney = (TextView)findViewById(R.id.tvGetMoney);
        etGoalMoney = (EditText)findViewById(R.id.etGoalMoney);

        rgSuvery = (RadioGroup) findViewById(R.id.rgSurvery);

        btnSwitch = (Button)findViewById(R.id.btnSwitch);

        ibTimeGoing = (ImageButton) findViewById(R.id.ibTimeGoing);
        pbTimeWaiting = (ProgressBar) findViewById(R.id.pbTimeWaiting);


        btnGetMoney.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String strInputMoney = etGoalMoney.getText().toString().trim();
                int iMoney = Integer.parseInt(strInputMoney);
                if (iMoney == money){
                    Toast.makeText(MainActivity.this,"达到目标",Toast.LENGTH_SHORT).show();
                }else {
                    money = money + 1;
                    tvGetMoney.setText("点击赚了" + money);
                }
            }

        });
        btnLoseMoney.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (money == 0) {
                    Toast.makeText(MainActivity.this, "没钱了", Toast.LENGTH_LONG).show();
                } else {
                    money--;
                    tvGetMoney.setText("点击亏了" + money);
                }
            }

        });

        //rgSuvery.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            /*public void onCheckChanged(RadioGroup radioGroup, int checkId){
                switch (checkedId){
                    case R.id.rbSoHappy:
                        Toast.makeText(MainActivity.this,"恭喜", Toast.LENGTH_LONG).show();
                        Break;
                    case R.id.rbNoHappy:
                        Toast.makeText(MainActivity.this,"放松", Toast.LENGTH_LONG).show();
                        Break;
                }
            }*/
        //})
        rgSuvery.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbSoHappy:
                        Toast.makeText(MainActivity.this,"恭喜", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.rbNoHappy:
                        Toast.makeText(MainActivity.this,"放松", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


        ibTimeGoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbTimeWaiting.setVisibility(View.VISIBLE);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });


    }


}
