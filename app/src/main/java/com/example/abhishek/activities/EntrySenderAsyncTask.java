package com.example.abhishek.activities;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhishek on 25-07-2015.
 */
public class EntrySenderAsyncTask extends AsyncTask<HashMap<String,String>, Void, String > {
    @Override
    protected String doInBackground(HashMap<String,String>... params) {
        String line2=null;
        //BufferedReader rd =null;
//        try {
//            String data = URLEncoder.encode("heading", "UTF-8") + "=" + URLEncoder.encode("Puneet", "UTF-8");
//            data += "&" + URLEncoder.encode("uid", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
//            data += "&" + URLEncoder.encode("detail", "UTF-8") + "=" + URLEncoder.encode("jfnf", "UTF-8");
//            data += "&" + URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8");
//
//            // Construct data
//            Log.i("text","abc");
//            // Send data
//            URL url = new URL(params[0]+data);
//            URLConnection conn = url.openConnection();
//            conn.setDoOutput(true);
//            Log.i("text","abc");
//            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//           wr.write(data);
//            wr.flush();
//            Log.i("wr",wr+"");
//
//            // Get the response
//            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            Log.i("rd",rd+"");
//            StringBuilder sb=new StringBuilder();
//            Log.i("sb",sb+"");
//            String line=null;
//
//            while ((line = rd.readLine()) != null) {
//                Log.i("text","abc");
//                sb.append(line+"\n");
//                // Process line...
//            }
//            //wr.close();
//            line2=sb.toString();
//            Log.i("text","abc");
//            Log.i("detail", line2);
//
//        } catch (Exception e) {
//            Log.i("exception",e+"");
//            Log.i("detail","in catch");
//        }
//        finally {
//            try {
//               // rd.close();
//            }catch (Exception ex){
//                Log.i("finally",ex+"");
//            }
//        }
//        return line2;




        // Create a new HttpClient and Post Header
        String downloadedString= null;

        HttpClient httpclient = new DefaultHttpClient();

        HashMap<String,String> hm=params[0];
        //for registerhttps://te
        HttpPost httppost = new HttpPost("http://192.168.2.65:5000/addentry");
        //add data
        try{
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(7);


            Iterator myVeryOwnIterator = hm.keySet().iterator();
            while(myVeryOwnIterator.hasNext()) {
                String key=(String)myVeryOwnIterator.next();
                String value=(String)hm.get(key);
                nameValuePairs.add(new BasicNameValuePair(key, value));

               // Toast.makeText(ctx, "Key: "+key+" Value: "+value, Toast.LENGTH_LONG).show();
            }
            nameValuePairs.add(new BasicNameValuePair("uid", "4"));
            nameValuePairs.add(new BasicNameValuePair("cid", "7"));


//            nameValuePairs.add(new BasicNameValuePair("heading", "Puneet"));
//            nameValuePairs.add(new BasicNameValuePair("detail", "Gupta"));
//            nameValuePairs.add(new BasicNameValuePair("uid", "4"));
//            nameValuePairs.add(new BasicNameValuePair("cid", "7"));
//            nameValuePairs.add(new BasicNameValuePair("username", "mikebulurt"));
//            nameValuePairs.add(new BasicNameValuePair("password", "qwert"));
//            nameValuePairs.add(new BasicNameValuePair("device_duid", "986409987"));

            //add data
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

            InputStream in = response.getEntity().getContent();
            StringBuilder stringbuilder = new StringBuilder();
            BufferedReader bfrd = new BufferedReader(new InputStreamReader(in),1024);
            String line;
            while((line = bfrd.readLine()) != null)
                stringbuilder.append(line);

            downloadedString = stringbuilder.toString();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("downloadedString:in login:::"+downloadedString);


        return downloadedString;
    }
}
