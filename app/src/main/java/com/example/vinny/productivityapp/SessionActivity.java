package com.example.vinny.productivityapp;

import android.os.CountDownTimer;
import android.se.omapi.Session;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SessionActivity extends AppCompatActivity {

    private EditText userSpecifiedTime;
    private TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        userSpecifiedTime = findViewById(R.id.userSpecifiedTime);
        timeTextView = findViewById(R.id.timeTextView);
        Button startTimerButton = findViewById(R.id.startTimerButton);

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Create custom time class that converts user input in form of hh:mm:ss to seconds and pass to countdowntimer
                int seconds = Integer.valueOf(String.valueOf(userSpecifiedTime.getText()));
                CountDownTimer timer = new CountDownTimer((long) seconds * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timeTextView.setText("Seconds Left: " + millisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        timeTextView.setText("Time Over!");
                        Toast.makeText(SessionActivity.this, "Timer done", Toast.LENGTH_LONG).show();
                    }
                }.start();

            }
        });


    }
}
