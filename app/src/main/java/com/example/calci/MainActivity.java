package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
   Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);

        btn.setOnClickListener(v ->startActivity(new Intent(getApplicationContext(),EmiActivity.class)));
        btn1.setOnClickListener(v-> startActivity(new Intent(getApplicationContext(),IncomeActivity.class)));
    }
        }