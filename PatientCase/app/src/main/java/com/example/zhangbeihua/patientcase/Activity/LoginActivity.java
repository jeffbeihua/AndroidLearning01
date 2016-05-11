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

import com.example.zhangbeihua.patientcase.R;
//import com.example.zhangbeihua.patientcase.widget.AlertDialogHelper;
import com.example.zhangbeihua.patientcase.widget.HTTPEnquire;

import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

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
        loginbtn= (Button) findViewById(R.id.login_ok_btn);
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
                saveUserAndPass();
            }
        });
    }

    private void saveUserAndPass() {
        //if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(passport)){
            //AlertDialogHelper.showAlertDialog(LoginActivity.this, "提醒", "请填写完整的用户名,密码和验证码");

        //}
        //else {

            String res = "";
            try {
                //String[] params = {"username", "a", "password", "a"};

                //JSONObject posts = {"username", "a", "password", "a"};

                JSONObject obj = new JSONObject();

                obj.put("username", user);
                obj.put("password", pass);

                String params = obj.toString();

                //params = "{\"username\":\"a\", \"password\":\"a\"}";

                //String[] params = {};
                //Http Post Method
                //res = HTTPEnquire.Get("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt", params);
                res = HTTPEnquire.Post("user/login", params);
                if (res != null) {
                    Intent intent = new Intent(LoginActivity.this, TapActivity.class);
                    startActivity(intent);
                }
            }catch (JSONException e){
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        //}
    }
}
