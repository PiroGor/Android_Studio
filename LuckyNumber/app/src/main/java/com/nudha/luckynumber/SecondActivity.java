package com.nudha.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_btn);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        //Generating number
        int random_num = generateRandomNumber();
        luckyNumberTxt.setText(""+random_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_num);
            }
        });

    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 1000;

        return random.nextInt(upperLimit);
    }

    public void shareData(String userName, int randomNumber){
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional info
        i.putExtra(Intent.EXTRA_SUBJECT, userName+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His/Her lucky number today is: "+ randomNumber);

        startActivity(Intent.createChooser(i, "Choose a platform"));

    }
}