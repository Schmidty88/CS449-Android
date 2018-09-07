package com.example.tjsch.lab1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    int count = 0;
    int total;
    TextView tv;
    TextView tv2;
    TextView tv3;

    public static final String PREFS_NAME = "myPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        total = settings.getInt("total", total);
        count = settings.getInt("count", count);
        counter = settings.getInt("counter", counter);
        tv = (TextView) findViewById(R.id.Strike_output);
        tv2 = (TextView) findViewById(R.id.Ball_output);
        tv3 = (TextView) findViewById(R.id.Total_output);
        ((TextView) findViewById(R.id.Total_output)).setText("" + total);
        ((TextView) findViewById(R.id.Strike_output)).setText("" + count);
        ((TextView) findViewById(R.id.Ball_output)).setText("" + counter);

    }
    public void On_ball_click(View v){
        if(counter != 3) {
            counter++;
            tv2.setText((Integer.toString(counter)));
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("counter", counter);
            editor.commit();
        }
        else{
            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
            alert.setMessage("Ball 4 Walk!");
            alert.show();
            count = 0;
            counter = 0;
            tv.setText(Integer.toString(count));
            tv2.setText(Integer.toString(counter));
        }
    }
    public void On_strike_click(View view){
        if (count != 2) {
            count++;
            tv.setText(Integer.toString(count));
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("count", count);
            editor.commit();

        }else{

            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
            alert.setMessage("Strike 3 Out!");
            alert.show();
            count = 0;
            counter = 0;
            total++;
            tv.setText(Integer.toString(count));
            tv2.setText(Integer.toString(counter));
            tv3.setText(Integer.toString(total));
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("total", total);
            editor.commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.about:
                Intent intent1 = new Intent(this, About.class);
                this.startActivity(intent1);
                return true;
            case R.id.reset:
                Intent intent2 = new Intent(this,Reset.class);
                count = 0;
                counter = 0;
                tv.setText(Integer.toString(count));
                tv2.setText(Integer.toString(counter));
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("count", count);
                editor.putInt("counter", counter);
                editor.commit();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
