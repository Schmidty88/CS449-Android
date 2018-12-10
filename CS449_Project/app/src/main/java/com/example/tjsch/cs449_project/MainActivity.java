package com.example.tjsch.cs449_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends UpdateActivity {
    TextView tv6;

    float res[] = {9.8f};
    String resName[] = {"Restaurants"};

    float hom[] = {899};
    String homeName[] = {"Home"};

    float tran[] = {47};
    String tranName[] = {"Transportation"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateTextViews();
        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.add_tran);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TransactionActivity.class));
            }
        });

        setupPieChart();

    }

    private void setupPieChart() {

        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i<res.length; i++){
            pieEntries.add(new PieEntry(res[i],resName[i]));
            pieEntries.add(new PieEntry(hom[i], homeName[i]));
            pieEntries.add(new PieEntry(tran[i], tranName[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Transactions");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.invalidate();
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

    public void updateTextViews() {
        SharedPreferences settings = getSharedPreferences("ID", 0);
        String str = settings.getString("Keyname", "nameText");
        tv6 = (TextView)findViewById(R.id.Greetings1);
        tv6.setText("Hello, " + str);
    }


}
