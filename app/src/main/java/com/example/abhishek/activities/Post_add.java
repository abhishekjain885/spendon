package com.example.abhishek.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abhishek.spenden.R;

import java.util.HashMap;

public class Post_add extends ActionBarActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    static int RESULT_LOAD_IMAGE=1;
    ImageView imageView;
    EditText Title,Name,Description,location,Mobile_Number;
    Button PostButton;
    final Context c=this;
    int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_add);
        imageView = (ImageView) findViewById(R.id.gallery);
        Title = (EditText) findViewById(R.id.Title);
        Description = (EditText) findViewById(R.id.Description);
        Name = (EditText) findViewById(R.id.name);
        location = (EditText) findViewById(R.id.Location);
        Mobile_Number = (EditText) findViewById(R.id.Mobile_num);
        PostButton=(Button)findViewById(R.id.Post_Button);

        PostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(view.getId()==R.id.Post_Button)
                {
                    if(Title.getText()==null)
                    {
                         Toast.makeText(c,"PLEASE ENTER NAME OF ITEM",Toast.LENGTH_LONG).show();
                        flag=0;
                    }
                    if(Description.getText()==null)
                    {
                        Toast.makeText(c,"PLEASE ENTER DESCRIPTION OF ITEM",Toast.LENGTH_LONG).show();
                        flag=0;
                    }
                    if(flag==1)
                    {
                        HashMap <String,String> hm = new HashMap<String,String>();
                        hm.put("heading",Title.getText().toString());
                        hm.put("detail",Description.getText().toString());
//                        hm.put("Location",location.getText().toString());
//                        hm.put("Name",Name.getText().toString());
//                        hm.put("MobileNumber",Mobile_Number.getText().toString());



                        EntrySenderAsyncTask task = new EntrySenderAsyncTask();

                        String urlString = "http://192.168.2.65:5000/addentry";
                        task.execute(hm);

                    }

                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.gallery){

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }

            }
        });
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categories, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_add, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //CharSequence s=(CharSequence)parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
