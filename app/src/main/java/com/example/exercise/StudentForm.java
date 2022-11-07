package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentForm extends AppCompatActivity {
    String nameValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        Intent i = getIntent();
        nameValue = (String) i.getExtras().get("name");
        EditText nameText = (EditText) findViewById(R.id.studentNameForm);
        nameText.setText(nameValue);

        Button buttonMain = (Button) findViewById(R.id.buttonMain);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentForm.this, MainActivity.class);

                EditText ageText = (EditText) findViewById(R.id.studentAge);
                String ageValue = (String) ageText.getText().toString();

                EditText phoneText = (EditText) findViewById(R.id.studentPhone);
                String phoneValue = (String) phoneText.getText().toString();

                intent.putExtra("age", ageValue);
                intent.putExtra("phone", phoneValue);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button buttonService = (Button) findViewById(R.id.buttonService2);
        buttonService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentForm.this, StudentService.class);
                startActivityForResult(intent, 300);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300) {
            if (resultCode == RESULT_OK){
                String response = (String)data.getExtras().get("service");
                Intent intent = new Intent(StudentForm.this, MainActivity.class);
                intent.putExtra("service", response);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}