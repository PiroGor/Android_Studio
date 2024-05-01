package com.nudha.volumcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sphere extends AppCompatActivity {

    EditText sphere_radius;
    TextView title, result;
    Button btn;
    BackBtn backButtonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphere_radius = findViewById(R.id.edit_text_radius);
        title = findViewById(R.id.title);
        result = findViewById(R.id.text_view_result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = sphere_radius.getText().toString();

                int r =Integer.parseInt(radius);

                //V = (4/3) *pi*r^3

                double volume = (4/3) * Math.PI * Math.pow(r,3);
                String formatVolume = String.format("%.4f",volume);
                result.setText("V = "+ formatVolume +" m^3");
            }
        });

        backButtonHandler = new BackBtn(this, R.id.backButton);
        backButtonHandler.setupBackButton();

    }
}