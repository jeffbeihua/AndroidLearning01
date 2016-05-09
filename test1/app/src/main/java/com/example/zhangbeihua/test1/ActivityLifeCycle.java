package com.example.zhangbeihua.test1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
/**
 * Created by zhangbeihua on 9/05/16.
 */
public class ActivityLifeCycle extends Activity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
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
}
