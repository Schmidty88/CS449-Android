package com.example.tjsch.cs449_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TransactionActivity extends AppCompatActivity {

    TextView tv;
    TextView tv3;

    SharedPreferences money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(TransactionActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selected) {
                        SharedPreferences.Editor editor = money.edit();
                        editor.commit();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


        money = getSharedPreferences("Money", 0);
        tv = (TextView) findViewById(R.id.name_type);
        tv3 = (TextView) findViewById(R.id.amount);

    }


    public void on_submit_click(View v) {
        String nameText = tv.getText().toString();
        String nameText2 = tv3.getText().toString();

        SharedPreferences.Editor editor = money.edit();
        editor.putString("Keyname", nameText);
        editor.putString("Keyname2", nameText2);
        editor.commit();


    }


}

