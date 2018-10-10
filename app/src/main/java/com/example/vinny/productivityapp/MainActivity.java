package com.example.vinny.productivityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button historyButton = findViewById(R.id.historyButton);
        Button startSessionButton = findViewById(R.id.startSessionButton);

        historyButton.setOnClickListener(this);
        startSessionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startSessionButton:
                Intent intent = new Intent(MainActivity.this, SessionActivity.class);
                startActivity(intent);
                break;

            case R.id.historyButton:
                intent = new Intent(MainActivity.this, SessionHistoryActivity.class);
                startActivity(intent);
                break;

            default:
                return;
        }

    }
}
