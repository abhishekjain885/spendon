package com.example.abhishek;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhishek.spenden.R;

import java.util.HashMap;

public class Add extends ActionBarActivity {
    String head;
    String detail;
    ImageView imageView;
    TextView edit_head;
    TextView edit_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent intent=getIntent();
        HashMap<String,String> hashMap=(HashMap<String,String>)intent.getSerializableExtra("Map");
       head= hashMap.get("heading");
        detail= hashMap.get("detail");

        imageView=(ImageView)findViewById(R.id.gallery);
        edit_detail=(TextView)findViewById(R.id.Description);
        edit_head=(TextView)findViewById(R.id.Title);

        imageView.setImageResource(R.drawable.monkey_junky_funy);
        edit_detail.setText(detail);
        edit_head.setText(head);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
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
