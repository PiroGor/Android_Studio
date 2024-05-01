package com.nudha.volumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1- AdapterView: GridView
    GridView gridView;

    //2- DataSource: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;

    //3- Adapter: MyCustomAdapter
    MyCustomAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();

        Shape cube = new Shape(R.drawable.cube,"Cube");
        Shape sphere = new Shape(R.drawable.sphere,"Sphere");
        Shape cylinder = new Shape(R.drawable.cylinder,"Cylinder");
        Shape prism = new Shape(R.drawable.prism,"Prism");

        shapeArrayList.add(cube);
        shapeArrayList.add(sphere);
        shapeArrayList.add(cylinder);
        shapeArrayList.add(prism);

        adaptor = new MyCustomAdaptor(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adaptor);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent cubeAct = new Intent(getApplicationContext(), Cube.class);
                        startActivity(cubeAct);
                        break;
                    case 1:
                        Intent sphereAct = new Intent(getApplicationContext(), Sphere.class);
                        startActivity(sphereAct);
                        break;
                    case 2:
                        Intent cylinderAct = new Intent(getApplicationContext(), Cylinder.class);
                        startActivity(cylinderAct);
                        break;
                    case 3:
                        Intent prismAct = new Intent(getApplicationContext(), Prism.class);
                        startActivity(prismAct);
                        break;
                    default:
                        System.out.println("error");
                }

            }
        });
    }
}