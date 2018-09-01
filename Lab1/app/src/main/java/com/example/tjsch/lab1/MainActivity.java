package com.example.tjsch.lab1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    int count = 0;
    TextView tv;
    TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.Strike_output);
        tv2 = (TextView) findViewById(R.id.Ball_output);
    }
    public void On_ball_click(View v){
        if(counter != 3) {
            counter++;
            tv2.setText((Integer.toString(counter)));
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
        }else{

            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
            alert.setMessage("Strike 3 Out!");
            alert.show();
            count = 0;
            counter = 0;
            tv.setText(Integer.toString(count));
            tv2.setText(Integer.toString(counter));

        }
    }


}
