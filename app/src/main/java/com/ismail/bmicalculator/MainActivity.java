package com.ismail.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private EditText editAge;
    private EditText editFeet;
    private EditText editInches;
    private EditText editWeight;
    private RadioButton btnMale;
    private RadioButton btnFemale;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonListener();

    }

    private void findViews() {
        resultText = findViewById(R.id.output);
        editAge = findViewById(R.id.age_input);
        editFeet = findViewById(R.id.feet_input);
        editInches = findViewById(R.id.inches_input);
        editWeight = findViewById(R.id.weight_input);
        btnMale = findViewById(R.id.male_button);
        btnFemale = findViewById(R.id.female_button);
        btnSubmit = findViewById(R.id.btn_calculate);
    }


    private void setupButtonListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double bmiResult = calculateBMI();
                String ageText = editAge.getText().toString();

                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);
                }
//                } else{
//                    displayGuidance(bmiResult);
//                }


            }
        });
    }


    private double calculateBMI() {
        String feetText = editFeet.getText().toString();
        String inchesText = editInches.getText().toString();
        String weightText = editWeight.getText().toString();

        // convert number strings to int
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;
        double heightInMeters = totalInches * 0.024;

        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi){
        DecimalFormat decimalformatter = new DecimalFormat("0.00");
        String bmitextResult = decimalformatter.format(bmi);

        String fullresultlString;

        if (bmi < 18.5) {
            fullresultlString = bmitextResult + " You are underwight";
        } else if (bmi > 25) {
            fullresultlString = bmitextResult + " You are overweight";
        } else {
            fullresultlString = bmitextResult + " You are healthy weight ";
        }

        resultText.setText(fullresultlString);
    }




//    private void displayGuidance(double bmi) {
//        DecimalFormat decimalformatter = new DecimalFormat("0.00");
//        String bmitextResult = decimalformatter.format(bmi);
//
//        String fullresultlString;
//
//        if (btnMale.isChecked()){
//            fullresultlString = bmitextResult = " As you are under 18, please consult with your doctor for the healthy range for boys";
//        } else if (btnFemale.isChecked()){
//            fullresultlString = bmitextResult = " \" As you are under 18, please consult with your doctor for the healthy range for girls";
//        } else{
//            fullresultlString = bmitextResult = " \" As you are under 18, please consult with your doctor for the healthy range";
//        }
//
//        resultText.setText(fullresultlString);
//    }


}