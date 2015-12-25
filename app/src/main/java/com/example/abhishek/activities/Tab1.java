package com.example.abhishek.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishek.Add;
import com.example.abhishek.spenden.R;
import com.melnykov.fab.FloatingActionButton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;


public class Tab1 extends Fragment implements FeedFetcherAsyncTask.BatchTaskDoneListener,EntryFetcherAsyncTask.EntryTaskDoneListener {
    //  Context context = this;
    String name;
    String flag;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView userpicture;
    private EditText editText;
    private ImageButton imagebut;
    private ImageView doubtnut_ico;
    private ItemsModelList data = new ItemsModelList();
    // private   ActionBar mActionBar;
    EntryFetcherAsyncTask task1;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);




//        data.addItem(new ItemsModel("Puneet",R.drawable.monkey_junky_funy,"BLAh"));
//        data.addItem(new ItemsModel("Puneet",R.drawable.monkey_junky_funy,"BLAh"));
//        data.addItem(new ItemsModel("Puneet",R.drawable.monkey_junky_funy,"BLAh"));
//        data.addItem(new ItemsModel("Puneet",R.drawable.monkey_junky_funy,"BLAh"));
//        data.addItem(new ItemsModel("Puneet",R.drawable.monkey_junky_funy,"BLAh"));
//        String data = URLEncoder.encode("heading", "UTF-8") + "=" + URLEncoder.encode("Puneet", "UTF-8");
//        data += "&" + URLEncoder.encode("uid", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
//        data += "&" + URLEncoder.encode("detail", "UTF-8") + "=" + URLEncoder.encode("jfnf", "UTF-8");
//        data += "&" + URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8");


        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        FeedFetcherAsyncTask task = new FeedFetcherAsyncTask();
        task.listener=this;
        task1=new EntryFetcherAsyncTask();
        task1.listener=this;


        String urlString = "http://192.168.2.65:5000/feed";
        task.execute(urlString);


//        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.fab);
//        fab.attachToRecyclerView(recyclerView);
//        fab.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_UP){
//                    // Do what you want
//                    Toast.makeText(getActivity(), "Refresh Clicked!",Toast.LENGTH_LONG).show();
//                    Intent changeActivity = new Intent(getActivity(),Button_activity.class);
//                 //   changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                    startActivity(changeActivity);
//
//                }
//
//
//                return true; // consume the event
//            }
//
//        });
       final Context a=getActivity();
        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);
        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    // Do what you want
                   // Toast.makeText(a, "Refresh Clicked!", Toast.LENGTH_LONG).show();
//
//                        EntrySenderAsyncTask task = new EntrySenderAsyncTask();
//
//                        String urlString = "http://192.168.2.65:5000/addentry";
//                        task.execute(urlString);
                        // Construct data
//                        String data = URLEncoder.encode("heading", "UTF-8") + "=" + URLEncoder.encode("Puneet", "UTF-8");
//                        data += "&" + URLEncoder.encode("uid", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
//                        data += "&" + URLEncoder.encode("detail", "UTF-8") + "=" + URLEncoder.encode("jfnf", "UTF-8");
//                        data += "&" + URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8");
//                        // Send data
//                        URL url = new URL("http://192.168.2.65:5000/addentry?");
//                        URLConnection conn = url.openConnection();
//                        conn.setDoOutput(true);
//                        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//                        wr.write(data);
//                        wr.flush();
//
//                        // Get the response
//                        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                        String line;
//
//                        String line2=null;
//                        while ((line = rd.readLine()) != null) {
//                            line2+=line;
//                            // Process line...
//                        }
//                        wr.close();
//                        rd.close();
//                        Log.i("detail", line2);
//
//                    } catch (Exception e) {
//                        Log.i("exception",e+"");
//                        Log.i("detail","in catch");
//                    }

//
                    Intent changeActivity = new Intent(a,Post_add.class);
                    changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(changeActivity);

                }
                return false;
            }
        });

        //recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new recycleViewAdapter(data);
        recyclerView.setAdapter(adapter);
        final GestureDetector mGestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());



                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                   // Drawer.closeDrawers();
                    Toast.makeText(getActivity(),"The Item Clicked is: "+recyclerView.getChildPosition(child),Toast.LENGTH_SHORT).show();
                    TextView tv=(TextView)child.findViewById(R.id.eid);
                    String Eid= (String) tv.getText();
                    EntryFetcherAsyncTask task = new EntryFetcherAsyncTask();
                    task.listener = task1.listener;
                    String urlString = "http://192.168.2.65:5000/entry?eid="+Eid;
                    task.execute(urlString);
                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }
        });


//        recyclerView.setOnScrollListener(new HidingScrollListener() {
//            @Override
//            public void onHide() {
//                ((MainActivity)getActivity()).hideViews();
//            }
//            @Override
//            public void onShow() {
//                ((MainActivity)getActivity()).showViews();
//            }
//        });






        return v;
    }



    @Override
    public void processBatches(ItemsModel[] itemsModels) {

        for (ItemsModel b: itemsModels) {
            data.addItem(b);
        }
        adapter.notifyDataSetChanged();

    }


    @Override
    public void processEntry(HashMap<String, String> hashmap) {
        Intent mIntent = new Intent(getActivity(), Add.class);
        mIntent.putExtra("Map",hashmap);
        startActivity(mIntent);

    }
}
