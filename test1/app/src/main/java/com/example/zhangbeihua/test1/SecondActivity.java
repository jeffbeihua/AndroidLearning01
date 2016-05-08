package com.example.zhangbeihua.test1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zhangbeihua on 7/03/16.
 */
public class SecondActivity extends Activity{

    private RatingBar rtbMyScore;
    private SeekBar skbChinaScore;
    private TextView tvChinaScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rtbMyScore = (RatingBar) findViewById(R.id.rtbMyScore);
        skbChinaScore = (SeekBar) findViewById(R.id.skbChinaScore);
        tvChinaScore = (TextView) findViewById(R.id.tvChinaScore);
        rtbMyScore.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(SecondActivity.this, "你给你自己的评分是"+rating, Toast.LENGTH_SHORT).show();
            }
        });

        skbChinaScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvChinaScore.setText("ZHONGHUAMINGMING"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}