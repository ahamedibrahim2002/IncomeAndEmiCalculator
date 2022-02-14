package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IncomeActivity extends AppCompatActivity {
    public EditText amountEditText;
    public Button calculateBtn;
    public TextView resultTextView,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        //action bar
        getSupportActionBar().setTitle("Income Calculator");
        amountEditText=findViewById(R.id.amountEditText);
        calculateBtn=findViewById(R.id.calculate);
        resultTextView=findViewById(R.id.resultTextView);
        clear=findViewById(R.id.clear);
        calculateBtn.setOnClickListener(v -> {
            try {
                Integer.parseInt(String.valueOf(amountEditText.getText()));
                calculate();
            } catch (Exception e) {
                Toast. makeText (getApplicationContext(), "You have exceeded the Input Limit! or \nPlease Enter All Input", Toast. LENGTH_LONG  ).show();
                resultTextView.setText("");
            }
        });
        clear.setOnClickListener(v1->{
            amountEditText.setText("");
        });

    }
         @SuppressLint("SetTextI18n")
         public void calculate() {
             long total = 0,tax=0;
             long income=Integer.parseInt(amountEditText.getText().toString());
             if (income >= 200000 && income < 1000000) {
                 tax= (income * 5)/100;
                 total = income+ tax;
             }else if(income >= 1000000 && income < 2000000) {
                 tax = (income * 10)/100;
                 total = income + tax;
             }else if(income >= 2000000 && income < 3000000) {
                 tax= (income * 15)/100;
                 total = income + tax;
             }else if (income >= 3000000 && income < 4000000) {
                 tax = (income * 20)/100;
                 total = income + tax;
             }else if(income >= 4000000 && income < 5000000) {
                 tax = (income * 25)/100;
                 total = income + tax;
             } else if (income >= 5000000 && income < 7000000) {
                 tax = (income * 30)/100;
                 total = income + tax;
             }else if (income >= 7000000 && income < 10000000) {
                 tax = (income * 35)/100;
                 total = income + tax; }
             else if (income >= 10000000) {
                 tax = (income * 40)/100;
                 total = income + tax;
             }
             resultTextView.setText("Tax on your income "+amountEditText.getText()+"= \t"+tax+"\n \n"+ "Total Income (Inclusion of Tax) "+"= \t"+total);
        }
}