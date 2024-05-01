package com.nudha.volumcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Prism extends AppCompatActivity {
    EditText prism_length, prism_width, prism_height;
    TextView title, result;
    Button btn;
    BackBtn backButtonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        prism_length = findViewById(R.id.length);
        prism_width = findViewById(R.id.width);
        prism_height = findViewById(R.id.height);
        title = findViewById(R.id.title);
        result = findViewById(R.id.text_view_result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = prism_length.getText().toString();
                String width = prism_width.getText().toString();
                String height = prism_height.getText().toString();

                double l = Integer.parseInt(length);
                double w =Integer.parseInt(width);
                double h = Integer.parseInt(height);

                //V = l * w * h

                double volume = l * w * h;
                String formatVolume = String.format("%.4f",volume);
                result.setText("V = "+ formatVolume +" m^3");
            }
        });

        backButtonHandler = new BackBtn(this, R.id.backButton);
        backButtonHandler.setupBackButton();
    }
}