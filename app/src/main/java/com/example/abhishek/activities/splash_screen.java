package com.example.abhishek.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.abhishek.Tutorial;
import com.example.abhishek.spenden.R;

public class splash_screen extends ActionBarActivity {
    public int WAIT_TIME_SPLASH_SCREEN = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final Intent changeActivity2 = new Intent(this,Tutorial.class);

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

                    sleep(WAIT_TIME_SPLASH_SCREEN);
                } catch (InterruptedException e) {
                    //Log.e("Splash Screen to Home Thread wait error",e.getMessage());
                } catch (Exception e) {
                    //Log.e("Other thread exception",e.getMessage());
                } finally{

                        startActivity(changeActivity2);


                    //starting the activity using the intent

                }

            }
        };


        //creating intent for communicating with the SyncService class



        //starting the thread
        wait.start();



        //Log.e("yes","yes");

        //startActivity(changeActivity);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
