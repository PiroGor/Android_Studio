package com.nudha.volumcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;

public class BackBtn {
    private Context context;
    private int backButtonId;

    public BackBtn(Context context, int backButtonId) {
        this.context = context;
        this.backButtonId = backButtonId;
    }

    public void setupBackButton() {
        Button backButton = ((Activity) context).findViewById(backButtonId);
        if (backButton != null) {
            backButton.setOnClickListener(view -> navigateBack());
        }
    }

    private void navigateBack() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}
