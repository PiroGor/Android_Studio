package com.nudha.volumcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Cube extends AppCompatActivity {

    EditText cube_side;
    TextView title, result;
    Button btn;
    private BackBtn backButtonHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cube_side = findViewById(R.id.edit_text_side);
        title = findViewById(R.id.title);
        result = findViewById(R.id.text_view_result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String side = cube_side.getText().toString();

                int s = Integer.parseInt(side);

                //V = s ^ 3

                double volume = Math.pow(s,3);
                String formatVolume = String.format("%.4f",volume);
                result.setText("V = "+ formatVolume +" m^3");
            }
        });

        backButtonHandler = new BackBtn(this, R.id.backButton);
        backButtonHandler.setupBackButton();

    }

}