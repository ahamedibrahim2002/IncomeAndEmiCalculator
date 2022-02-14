package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmiActivity extends AppCompatActivity {
    EditText amountEditText,interestEditText,yearEditText,emiResultEditText,totalAmountWithInterestEditText;
    Button calculate;
    TextView clear;
    float amount,rateOfInterestPerMonth,noOfMonth,emiResult,totalAmountWithInterest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);

        //action bar
        getSupportActionBar().setTitle("Emi Calculator");

        amountEditText=findViewById(R.id.amount);
        interestEditText=findViewById(R.id.interest);
        yearEditText=findViewById(R.id.years);
        emiResultEditText=findViewById(R.id.emiResult);
        totalAmountWithInterestEditText=findViewById(R.id.totalAmountWithInterest);
        calculate=findViewById(R.id.calculate);
        clear=findViewById(R.id.clear);
        //make result as non editable
        emiResultEditText.setEnabled(false);
        totalAmountWithInterestEditText.setEnabled(false);
        calculate.setOnClickListener(v->{
           try {
               amount=(Float.parseFloat(amountEditText.getText().toString()));
               rateOfInterestPerMonth=(Float.parseFloat(interestEditText.getText().toString()))/12/100;
               noOfMonth=(Float.parseFloat(yearEditText.getText().toString()))*12;

               emiResult=calculateEmi(amount,rateOfInterestPerMonth,noOfMonth);
               totalAmountWithInterest=amount+emiResult;

               emiResultEditText.setText(emiResult+"");
               totalAmountWithInterestEditText.setText(totalAmountWithInterest+"");
           }catch (Exception e){
               Toast.makeText(getApplicationContext(), "Please Enter All Input", Toast.LENGTH_SHORT).show();
           }

        });
        clear.setOnClickListener(v1->{
             amountEditText.setText("");
             interestEditText.setText("");
             yearEditText.setText("");
             emiResultEditText.setText("");
             totalAmountWithInterestEditText.setText("");
        });
    }
    public float calculateEmi(float amount,float rateOfInterestPerMonth,float noOfMonth){
        float onePlusR=1+rateOfInterestPerMonth;
        return (float) ((amount*rateOfInterestPerMonth)*(Math.pow(onePlusR,noOfMonth))/((Math.pow(onePlusR,noOfMonth))-1));
    }
}