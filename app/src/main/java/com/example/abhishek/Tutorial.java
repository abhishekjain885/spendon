package com.example.abhishek;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abhishek.activities.ImageAdapter;
import com.example.abhishek.spenden.R;

public class Tutorial extends ActionBarActivity {
    static TextView mDotsText[];
    private int mDotsCount;
    private LinearLayout mDotsLayout;
    Intent changeActivity;
    final Context mcontext=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        //here we create the gallery and set our adapter created before
        Gallery gallery = (Gallery)findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));


        mDotsLayout = (LinearLayout)findViewById(R.id.image_count);
        //here we count the number of images we have to know how many dots we need
        mDotsCount = gallery.getAdapter().getCount();

        //here we create the dots
        //as you can see the dots are nothing but "."  of large size
        mDotsText = new TextView[mDotsCount];

        //here we set the dots
        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(45);
            mDotsText[i].setTypeface(null, Typeface.BOLD);
            mDotsText[i].setTextColor(android.graphics.Color.GRAY);
            mDotsLayout.addView(mDotsText[i]);
        }


        //when we scroll the images we have to set the dot that corresponds to the image to White and the others
        //will be Gray
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int pos, long l) {

                for (int i = 0; i < mDotsCount; i++) {
                    Tutorial.mDotsText[i]
                            .setTextColor(Color.BLACK);
                }

                Tutorial.mDotsText[pos]
                        .setTextColor(Color.GRAY);
                if(pos==mDotsCount-1){
                    changeActivity = new Intent(mcontext,Login_screen.class);

/*       NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
       SyncAdapter sync = new  SyncAdapter(this, false, manager);
       sync.sync();
*/
                    //creating thread for waiting WAIT_TIME seconds
                    Thread wait = new Thread(){
                        @Override
                        public void run() {
                            //use try catch block to avoid unhandled thread interrrupted exception and preventing app from crashing
                            try {

                                sleep(2000);
                            } catch (InterruptedException e) {
                                //Log.e("Splash Screen to Home Thread wait error",e.getMessage());
                            } catch (Exception e) {
                                //Log.e("Other thread exception",e.getMessage());
                            } finally{
                                //starting the activity using the intent


                                startActivity(changeActivity);
                            }

                        }
                    };


                    //creating intent for communicating with the SyncService class



                    //starting the thread
                    wait.start();
                }
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        });
    }
}