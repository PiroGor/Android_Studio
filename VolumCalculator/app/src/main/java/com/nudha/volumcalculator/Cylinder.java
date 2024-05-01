package com.nudha.volumcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Cylinder extends AppCompatActivity {
    EditText cylinder_radius, cylinder_height;
    TextView title, result;
    Button btn;
    BackBtn backButtonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        cylinder_radius = findViewById(R.id.edit_text_radius);
        cylinder_height = findViewById(R.id.height);
        title = findViewById(R.id.title);
        result = findViewById(R.id.text_view_result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = cylinder_radius.getText().toString();
                String height = cylinder_height.getText().toString();

                double r = Integer.parseInt(radius);
                double h = Integer.parseInt(height);

                //V = pi * r^2 * h

                double volume = Math.PI * h * Math.pow(r,2);
                String formatVolume = String.format("%.4f",volume);
                result.setText("V = "+ formatVolume +" m^3");
            }
        });

        backButtonHandler = new BackBtn(this, R.id.backButton);
        backButtonHandler.setupBackButton();
    }
}