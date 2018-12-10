package com.example.tjsch.cs449_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;

    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        settings = getSharedPreferences("ID",0);
        tv = (TextView) findViewById(R.id.User);
        tv2 = (TextView) findViewById(R.id.User2);
        tv3 = (TextView) findViewById(R.id.Earnings);
        tv4 = (TextView) findViewById(R.id.Goal);
        updateTextView();
    }

    public void on_submit_click(View v){
        String nameText = tv.getText().toString();
        String nameText2 = tv2.getText().toString();
        String nameText3 = tv3.getText().toString();
        String nameText4 = tv4.getText().toString();

        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Keyname", nameText);
        editor.putString("Keyname2", nameText2);
        editor.putString("Keyname3", nameText3);
        editor.putString("Keyname4", nameText4);
        editor.commit();
        updateTextView();
    }

    public void updateTextView(){
        String Keyname = settings.getString("Keyname", "nameText");

        tv5 = (TextView) findViewById(R.id.Greetings1);

        tv5.setText("Hello," + Keyname);
    }

}
