package com.nudha.frenchteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, greenBtn, redBtn, yellowBtn, purpleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blackBtn = findViewById(R.id.btnBlack);
        redBtn = findViewById(R.id.btnRed);
        yellowBtn = findViewById(R.id.btnYellow);
        greenBtn = findViewById(R.id.btnGreen);
        purpleBtn = findViewById(R.id.btnPurple);

        redBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Find the button by ID and play the correct sound

        int clickedBtnId = v.getId();

        if(clickedBtnId == R.id.btnRed){
            PlaySounds(R.raw.red);
        } else if (clickedBtnId == R.id.btnBlack) {
            PlaySounds(R.raw.black);
        }else if(clickedBtnId == R.id.btnGreen){
            PlaySounds(R.raw.green);
        } else if (clickedBtnId == R.id.btnYellow) {
            PlaySounds(R.raw.yellow);
        } else if (clickedBtnId == R.id.btnPurple) {
            PlaySounds(R.raw.purple);
        }


    }

    public void PlaySounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}