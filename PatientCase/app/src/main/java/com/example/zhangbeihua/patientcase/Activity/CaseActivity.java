package com.example.zhangbeihua.patientcase.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import com.example.zhangbeihua.patientcase.R;

import com.example.zhangbeihua.patientcase.widget.HTTPEnquire;
import java.util.concurrent.ExecutionException;
import org.json.*;




public class CaseActivity extends AppCompatActivity {

    private EditText etTag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);
        etTag = (EditText)findViewById(R.id.etTag);

        //HTTPMethods HTTP = new HTTPMethods();

        //new JSONTask().execute("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt");

        //Log.d("json", task.getResult());

        String res ="";
        try {
            //JSONObject params = new JSONObject();
            String[] params = {};
            //Http Post Method
            //res = HTTPEnquire.Get("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt", params);
            res = HTTPEnquire.Get("clinic/bodyparts", params);
            etTag.setText(res);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*public class JSONTask extends AsyncTask<String, String, String>{
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
    }*/
}
