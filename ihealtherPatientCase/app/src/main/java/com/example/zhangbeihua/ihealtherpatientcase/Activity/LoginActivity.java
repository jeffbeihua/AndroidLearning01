package com.example.zhangbeihua.ihealtherpatientcase.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zhangbeihua.ihealtherpatientcase.R;


import com.example.zhangbeihua.ihealtherpatientcase.widget.AlertDialogHelper;
import com.example.zhangbeihua.ihealtherpatientcase.widget.ProgressDialogHelper;
import com.example.zhangbeihua.ihealtherpatientcase.widget.SharedPreferencesHelper;





public class LoginActivity extends AppCompatActivity {
    private EditText loginuser=null;
    private EditText loginpass=null;
    private EditText passported=null;
    private Button loginbtn;
    private Button safecodebtn=null;
    private ImageView codeimg=null;
    private SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setLoginBtnListener();  //设置登录按钮监听

    }

    private void initView() {
        loginuser= (EditText) findViewById(R.id.loginid_et);
        loginpass= (EditText) findViewById(R.id.loginpswd_et);
        passported=(EditText) findViewById(R.id.safecode_et);
        loginbtn= (Button) findViewById(R.id.login_ok_btn);
        safecodebtn=(Button) findViewById(R.id.safecode_btn);
        codeimg= (ImageView) findViewById(R.id.codeimg);
    }

    private String user="";
    private String pass="";
    private String passport="";
    private void setLoginBtnListener() {
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = loginuser.getText().toString();
                pass = loginpass.getText().toString();
                passport = passported.getText().toString();
                saveUserAndPass();
            }
        });
    }

    private void saveUserAndPass() {
        if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(passport)){
            AlertDialogHelper.showAlertDialog(LoginActivity.this, "提醒", "请填写完整的用户名,密码和验证码");
        }
        else{
            //HttpUtil.userName=user;
            //HttpUtil.password=pass;
            //HttpUtil.passport=passport;
            //login();
        }
    }
}
