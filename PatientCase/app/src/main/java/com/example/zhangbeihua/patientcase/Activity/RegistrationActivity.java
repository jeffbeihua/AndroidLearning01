package com.example.zhangbeihua.patientcase.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhangbeihua.patientcase.R;
import com.example.zhangbeihua.patientcase.widget.HTTPEnquire;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import com.example.zhangbeihua.patientcase.widget.AlertDialogHelper;


public class RegistrationActivity extends AppCompatActivity {

    private EditText etMobileNum;
    private EditText etPassword;
    private EditText etCode;
    private EditText etEmail;
    private Button btnCode;
    private Button btnRegister;

    private String mobileNum="";
    private String password="";
    private String code="";
    private String email="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etMobileNum = (EditText)findViewById(R.id.etMobileNum);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etCode = (EditText)findViewById(R.id.etCode);
        etEmail = (EditText)findViewById(R.id.etEmail);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnCode = (Button)findViewById(R.id.btnCode);
        registerUserAndPass();
        getCode();

    }


    private void registerUserAndPass() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileNum = etMobileNum.getText().toString();
                password = etPassword.getText().toString();
                email = etEmail.getText().toString();
                code = etCode.getText().toString();

                try {
                    JSONObject obj = new JSONObject();

                    obj.put("username", mobileNum);
                    obj.put("mobilenum", mobileNum);
                    obj.put("code", code);
                    obj.put("email", email);
                    obj.put("password", password);

                    String params = obj.toString();
                    String res = "";
                    //JSONObject params = new JSONObject();
                    //Http Post Method
                    //res = HTTPEnquire.Get("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt", params);
                    res = HTTPEnquire.Post("user/signup", params);
                    if (res != "fail") {
                        Intent intent = new Intent(RegistrationActivity.this, TapActivity.class);
                        startActivity(intent);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getCode() {

        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileNum = etMobileNum.getText().toString();
                password = etPassword.getText().toString();
                code = etCode.getText().toString();
                try {
                    JSONObject obj = new JSONObject();

                    obj.put("mobilenum", mobileNum );

                    String[] params = {"mobilenum", mobileNum};

                    String res = "";
                    //JSONObject params = new JSONObject();
                    //Http Post Method
                    //res = HTTPEnquire.Get("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt", params);
                    res = HTTPEnquire.Get("smscode/send", params);
                    Log.e("register returned = ", res);
                    if (res != "fail" ) {
                        //Intent intent = new Intent(RegistrationActivity.this, TapActivity.class);
                        //startActivity(intent);
                        AlertDialogHelper.showAlertDialog(RegistrationActivity.this, "提醒", "验证码已发送,请输入验证码");
                    }else{
                        AlertDialogHelper.showAlertDialog(RegistrationActivity.this, "提醒", "请再次输入手机号");
                    }



                }catch (JSONException e){
                    e.printStackTrace();
                }  catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }




}
