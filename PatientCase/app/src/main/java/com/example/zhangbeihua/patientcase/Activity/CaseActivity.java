package com.example.zhangbeihua.patientcase.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import com.example.zhangbeihua.patientcase.R;

import android.os.AsyncTask;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.example.zhangbeihua.patientcase.widget.HTTPMethods;
import com.example.zhangbeihua.patientcase.widget.HTTPMethods.JSONTask;
import com.example.zhangbeihua.patientcase.widget.prmja_com;
import java.util.concurrent.ExecutionException;

public class CaseActivity extends AppCompatActivity {

    private EditText etTag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);
        etTag = (EditText)findViewById(R.id.etTag);

        //HTTPMethods HTTP = new HTTPMethods();

        new JSONTask().execute("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt");

        //Log.d("json", task.getResult());







    }

    public class JSONTask extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try{
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine())!=null){
                    buffer.append(line);
                }
                return buffer.toString();



            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                if (connection != null){
                    connection.disconnect();
                }
                try {
                    if (reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //return result;
            etTag.setText(result);
        }
    }
}
