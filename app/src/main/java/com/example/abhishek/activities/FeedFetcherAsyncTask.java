package com.example.abhishek.activities;

import android.os.AsyncTask;
import android.util.Log;

import com.example.abhishek.spenden.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import static com.example.abhishek.spenden.R.drawable.*;

/**
 * Created by Abhishek on 25-07-2015.
 */
public class FeedFetcherAsyncTask extends AsyncTask<String, Void, ItemsModel[] > {
    public interface BatchTaskDoneListener {
        public void processBatches(ItemsModel[] itemsModels);
    }
    ItemsModel[] output = new ItemsModel[1];
    BatchTaskDoneListener listener;



    @Override
    protected ItemsModel[] doInBackground(String... params) {
        Log.d("Puneet" , "Reached here");
        URL url = null;
        try {
            url = new URL(params[0]);
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

        for(int i=0;i<1;i++)
            output[i] = new ItemsModel("d", monkey_junky_funy,"k","l");

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

            return parseJson(buffer.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return output;


    }
    @Override
    protected void onPostExecute(ItemsModel[] batches) {
        listener.processBatches(batches);
    }

    public ItemsModel[] parseJson(String jsonString) throws JSONException {
        JSONObject obj = null;
        try {
            obj = new JSONObject(jsonString);
          //  Log.i("obj", (String) obj);
        } catch (JSONException e) {

        }
        int Length=obj.getInt("num");
        Log.i("lenthg", Length+"");

        ItemsModel[] output = new ItemsModel[obj.getInt("num")];

        for (int i = 1; i<=Length; i++) {
            //int k=0;
            Log.i("i",i+"");
            try {
                JSONObject batch = obj.getJSONObject(String.valueOf(i));
                String heading = batch.getString("heading");
                Log.i("lenthg", Length+"");
                String detail = batch.getString("detail");
                Log.i("detail",detail);
                Integer eid=batch.getInt("eid");
                String EID=eid+"";
                //int batchId = batch.getInt("id");
                output[i-1] = new ItemsModel(heading, monkey_junky_funy,detail,EID);
            } catch (JSONException e) {
                Log.i("Except","catch");
                e.printStackTrace();
            }

        }
        return output;
    }


}

