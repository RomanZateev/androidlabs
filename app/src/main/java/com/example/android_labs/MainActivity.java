package com.example.android_labs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lab1.Lab1Activity;
import com.example.lab2.Lab2Activity;
import com.example.lab3.Lab3Activity;
import com.example.lab4.Lab4Activity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.lab1).setOnClickListener((v) -> startActivity(Lab1Activity.newIntent(this)));
        findViewById(R.id.lab2).setOnClickListener((v) -> startActivity(Lab2Activity.newIntent(this)));
        findViewById(R.id.lab3).setOnClickListener((v) -> startActivity(Lab3Activity.newIntent(this)));
        findViewById(R.id.lab4).setOnClickListener((v) -> startActivity(Lab4Activity.newIntent(this)));
    }
}
