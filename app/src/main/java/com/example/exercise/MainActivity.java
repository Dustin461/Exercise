package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nameText;
    String studentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonForm = (Button) findViewById(R.id.buttonForm);
        buttonForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText = (EditText) findViewById(R.id.studentName);
                studentName = nameText.getText().toString();
                Intent i = new Intent(MainActivity.this, StudentForm.class);
                i.putExtra("name", studentName);
                startActivityForResult(i,100);
            }
        });

        Button buttonService = (Button) findViewById(R.id.buttonService);
        buttonService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StudentService.class);
                i.putExtra("requestCode","200");
                startActivityForResult(i, 200);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                if(data.getExtras().get("service") == null) {
                    String responseAge = (String) data.getExtras().get("age");
                    String responsePhone = (String) data.getExtras().get("phone");
                    TextView display = (TextView) findViewById(R.id.display);
                    display.setText("Thank you " + studentName + " for submitting the form." + "\nYour age is: " + responseAge + "."
                                    + "\nYour phone number is: " + responsePhone + ".");
                }
            }
        }

        if (requestCode == 200) {
            if (resultCode == RESULT_OK){
                String response = (String)data.getExtras().get("service");
                TextView display = (TextView) findViewById(R.id.display);
                display.setText("Thank you for selecting " +  response + " service.");
            }
        }
    }
}