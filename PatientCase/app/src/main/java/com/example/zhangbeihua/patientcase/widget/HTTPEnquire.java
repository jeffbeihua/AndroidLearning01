package com.example.zhangbeihua.patientcase.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;
import java.io.BufferedReader;

import java.net.MalformedURLException;
import java.net.URL;

import java.io.OutputStream;
/**
 * Created by zhangbeihua on 12/05/16.
 */
public class HTTPEnquire {
    public String url = "http://10.0.2.2:9000/";
    public static String Get(String s ,String[] a) throws ExecutionException, InterruptedException {

        String parameters = "";
        if (a.length !=0){
            parameters = "?";
        }
        for (int i = 0; i < a.length; i++) {
            try {
                parameters += a[i] + "=" + URLEncoder.encode(a[i + 1], "UTF-8") + "&";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }
        Log.e("url=", "http://10.0.2.2:9000/"+s+parameters);


        return new DownloadWebpageTask().execute("http://10.0.2.2:9000/"+s+parameters,"GET","").get();
    }

    public static String Post(String s ,String a) throws ExecutionException, InterruptedException {

        //String parameters ="";

        /*for(int i=0; i<a.length ;i++){
            try {
                parameters += a[i]+"=" + URLEncoder.encode(a[i+1],"UTF-8")+"&";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }*/
        Log.e("url=", "http://10.0.2.2:9000/"+s);
        return new DownloadWebpageTask().execute("http://10.0.2.2:9000/"+s,"POST", a).get();

    }

    public static Bitmap Download_Image(String s) throws ExecutionException, InterruptedException, UnsupportedEncodingException {
        return new Download_Image().execute(s).get();

    }
    private static class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            try {
                return downloadUrl(urls[0] ,urls[1],urls[2] );
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return "fail";
            }
        }

        @Override
        protected void onPostExecute(String result) {
        }

        private String downloadUrl(String myurl ,String method , String data) throws IOException {
            InputStream is = null;
            BufferedReader reader = null;
            //Log.e("url=", myurl);
            Log.e("data=", data);


            /*JSONObject dataJson = new JSONObject();
            try{
                dataJson = new JSONObject(data);
            }catch (JSONException e){
                e.printStackTrace();
            }

            System.out.println(dataJson);*/


            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //conn.setReadTimeout(10000);
                //conn.setConnectTimeout(15000);
                conn.setRequestMethod(method);
                conn.setDoInput(true);
                //conn.setRequestProperty("Accept-Encoding", "gzip");
                //conn.setRequestProperty("Connection", "close");
                if (method == "POST") {
                    conn.setDoOutput(true);

                    conn.setRequestProperty("Content-Type", "application/json");

                    PrintWriter out = new PrintWriter(conn.getOutputStream());
                    out.print(data);
                    out.close();

                }

                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.e("http response1 =", String.valueOf(response));

                if (response == 200){
                    is = conn.getInputStream();
                    String contentAsString = readIt(is, conn.getContentLength());
                    Log.e("http response2 =", contentAsString);
                    return contentAsString;
                }

                return "fail";


                /*InputStream stream = conn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine())!=null){
                    buffer.append(line);
                }
                return buffer.toString();*/



            } finally {
                if (is != null) {
                    is.close();
                }
            }


            /*HttpURLConnection connection = null;
            BufferedReader reader = null;

            try{
                URL url = new URL(myurl);
                connection = (HttpURLConnection) url.openConnection();

                connection.setReadTimeout(10000 );
                connection.setConnectTimeout(15000 );
                connection.setRequestMethod(method);
                connection.setDoInput(true);
                connection.setRequestProperty("Accept-Encoding", "gzip");
                connection.setRequestProperty("Connection", "close");

                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine())!=null){
                    buffer.append(line);
                }
                return buffer.toString();

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
            }*/
            //return null;



        }

        private String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            int n = 0;
            char[] buffer = new char[1024 * 4];
            InputStreamReader reader = new InputStreamReader(stream, "UTF8");
            StringWriter writer = new StringWriter();
            while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
            return writer.toString();
        }


    }


    private static class Download_Image extends AsyncTask<String, Integer, Bitmap>{
        private static Bitmap downloadUrl(String strUrl) throws IOException{
            Bitmap bitmap=null;
            InputStream iStream = null;
            try{
                URL url = new URL(strUrl);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.connect();

                iStream = urlConnection.getInputStream();

                bitmap = BitmapFactory.decodeStream(iStream);

            }catch(Exception e){

            }finally{
                iStream.close();
            }
            return bitmap;
        }

        Bitmap bitmap = null;
        @Override
        protected Bitmap doInBackground(String... url) {
            try{
                bitmap = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
        }
    }
}
