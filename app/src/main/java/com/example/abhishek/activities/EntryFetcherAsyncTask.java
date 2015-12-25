package com.example.abhishek.activities;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import static com.example.abhishek.spenden.R.drawable.monkey_junky_funy;

/**
 * Created by Abhishek on 26-07-2015.
 */
public class EntryFetcherAsyncTask extends AsyncTask<String, Void, HashMap<String,String>> {
    public interface EntryTaskDoneListener {
        public void processEntry(HashMap<String,String> hashmap);
    }
    ItemsModel[] output = new ItemsModel[1];
    EntryTaskDoneListener listener;
    HashMap<String,String> hashMap=new HashMap<String,String>();

    @Override
    protected HashMap<String, String> doInBackground(String... strings) {
        Log.d("Puneet" , "Reached here");

            hashMap.put("L","k");


            URL url = null;
            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                //
            }

            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection)url.openConnection();
            } catch (IOException e) {

            }

            try {
                urlConnection.setRequestMethod("GET");
            } catch (ProtocolException e) {

            }

            try {
                urlConnection.connect();
            } catch (IOException e) {
            }

            InputStream inputStream = null;
            try {
                inputStream = urlConnection.getInputStream();
            } catch (IOException e) {

            }

//            for(int i=0;i<1;i++)
//                output[i] = new ItemsModel("d", monkey_junky_funy,"k","l");

            StringBuffer buffer = new StringBuffer();
            //String temp =   "";
            Scanner s = new Scanner(inputStream);
            while (s.hasNext()) {
                buffer.append(s.nextLine());
                // temp = temp + s.nextLine();
            }
            Log.i("jsondata", buffer.toString());

            try {
                Log.i("jsondata", buffer.toString());

                return parseJson1(buffer.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;


        }
    @Override
    protected void onPostExecute(HashMap<String,String> batches) {
        listener.processEntry(batches);
    }

    public HashMap<String,String> parseJson1(String jsonString) throws JSONException {
        JSONObject obj = null;
        try {
            obj = new JSONObject(jsonString);
            //  Log.i("obj", (String) obj);
        } catch (JSONException e) {

        }
        HashMap<String,String> hashMap1=new HashMap<>();
//        int Length=obj.getInt("num");
//        Log.i("lenthg", Length+"");
//
//        ItemsModel[] output = new ItemsModel[obj.getInt("num")];
//
//        for (int i = 1; i<=Length; i++) {
            //int k=0;
           // Log.i("i",i+"");
            try {
                JSONObject batch = obj.getJSONObject("question");
                String heading = batch.getString("heading");
               hashMap1.put("heading",heading);
                //Log.i("lenthg", Length+"");
                String detail = batch.getString("detail");
                Log.i("detail",detail);
                Integer eid=batch.getInt("eid");
                String EID=eid+"";
                hashMap1.put("detail",detail);
                //int batchId = batch.getInt("id");
               // output[i-1] = new ItemsModel(heading, monkey_junky_funy,detail,EID);
            } catch (JSONException e) {
                Log.i("Except","catch");
                e.printStackTrace();
            }
        Log.d("Hashmap",hashMap1+"");
                return hashMap1;

        }

    }


