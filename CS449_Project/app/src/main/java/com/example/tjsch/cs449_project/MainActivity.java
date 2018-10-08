package com.example.tjsch.cs449_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    public static final String PREFS_NAME = "myPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

    }
    public void on_submit_click(View v){
        tv = (TextView) findViewById(R.id.User);
        tv2 = (TextView) findViewById(R.id.User2);
        tv3 = (TextView) findViewById(R.id.Earnings);
        tv4 = (TextView) findViewById(R.id.Goal);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
     switch (item.getItemId()){
         case R.id.update:
             Intent intent1 = new Intent(this, UpdateActivity.class);
             this.startActivity(intent1);
             return true;
         case R.id.help:
             Intent intent2 = new Intent(this, HelpActivity.class);
             this.startActivity(intent2);
             return true;
     }
        return super.onOptionsItemSelected(item);
    }
}
