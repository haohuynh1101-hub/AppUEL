package com.example.appuel.activity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.appuel.R;

public class MainActivity extends AppCompatActivity {
    private static int  SPALSH_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, LoginPageActivity.class);
                startActivity(intent);
                finish();
            }
        },SPALSH_TIME_OUT);
    }
}
