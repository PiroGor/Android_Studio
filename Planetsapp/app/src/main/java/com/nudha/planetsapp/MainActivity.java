package com.nudha.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    private MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a ListView
        listView = findViewById(R.id.listview);

        // 2 - DataSource: ArrayList<Planet>
        planetArrayList = new ArrayList<>();

        Planet earth = new Planet("Earth","1 Moon",R.drawable.earth);
        Planet mercury = new Planet("Mercury","0 Moons", R.drawable.mercury);
        Planet venus = new Planet("Venus","0 Moons", R.drawable.venus);
        Planet mars = new Planet("Mars","2 Moons", R.drawable.mars);
        Planet jupiter = new Planet("Jupiter","79 Moons", R.drawable.jupiter);
        Planet saturn = new Planet("Saturn","83 Moons",R.drawable.saturn);
        Planet uranus = new Planet("Uranus","27 Moons",R.drawable.uranus);
        Planet neptune = new Planet("Neptune","14 Moons",R.drawable.neptune);


        planetArrayList.add(earth);
        planetArrayList.add(mercury);
        planetArrayList.add(venus);
        planetArrayList.add(mars);
        planetArrayList.add(jupiter);
        planetArrayList.add(saturn);
        planetArrayList.add(uranus);
        planetArrayList.add(neptune);


        //Adapter
        adapter = new MyCustomAdapter(getApplicationContext(),planetArrayList);

        listView.setAdapter(adapter);

        //Handling Click Events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Planet Name: "+ adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}