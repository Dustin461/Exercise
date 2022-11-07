package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_service);

        Button buttonHealthCare = (Button) findViewById(R.id.buttonHealthCare);
        buttonHealthCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentService.this, MainActivity.class);
                intent.putExtra("service","Health Care");
                Intent i = getIntent();
                if (i.getExtras() != null){
                    String signal = i.getExtras().get("requestCode").toString();
                    if (signal.equals("200")){
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
                else {
                    Intent intent2 = new Intent(StudentService.this, StudentForm.class);
                    intent2.putExtra("service", "Health Care");
                    setResult(RESULT_OK, intent2);
                    finish();
                }
            }
        });

        Button buttonAssignmentSupport = (Button) findViewById(R.id.buttonAssignmentSupport);
        buttonAssignmentSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentService.this, MainActivity.class);
                intent.putExtra("service","Assignment Support");
                Intent i = getIntent();
                if (i.getExtras() != null){
                    String signal = i.getExtras().get("requestCode").toString();
                    if (signal.equals("200")){
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
                else {
                    Intent intent2 = new Intent(StudentService.this, StudentForm.class);
                    intent2.putExtra("service", "Assignment Support");
                    setResult(RESULT_OK, intent2);
                    finish();
                }
            }
        });

        Button buttonAccommodationSupport = (Button) findViewById(R.id.buttonAccommodationSupport);
        buttonAccommodationSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentService.this, MainActivity.class);
                intent.putExtra("service","Accommodation Support");
                Intent i = getIntent();
                if (i.getExtras() != null){
                    String signal = i.getExtras().get("requestCode").toString();
                    if (signal.equals("200")){
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
                else {
                    Intent intent2 = new Intent(StudentService.this, StudentForm.class);
                    intent2.putExtra("service", "Accommodation Support");
                    setResult(RESULT_OK, intent2);
                    finish();
                }
            }
        });
    }
}