package com.nudha.adapters;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1- Adapter: ListView
        listView = findViewById(R.id.listview);

        //2- Data source: String Array
        String[] countries = {"USA", "Poland", "Ukraine", "France"};

        //3 -Adapter: ACTS A BRIDGE BETWEEN THE 'DATA SOURCE' AND THE 'adapterView'
        CustomAdapter adapter = new CustomAdapter(this, countries);

        //link Listview with the Adapter
        listView.setAdapter(adapter);



    }
}