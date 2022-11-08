package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

public class FirstActivity extends AppCompatActivity {

    EditText etName;
    EditText etAddress;
    EditText etEmail;
    EditText etNoPhone;
    EditText etBirthdayDate;
    Button btnName;

    public final static String USERNAME = "com.example.MyFirstApp.message_key";
    public final static String ADDRESS = "com.example.MyFirstApp.ADDRESS";
    public final static String EMAIL = "com.example.MyFirstApp.EMAIL";
    public final static String NUMBERPHONE = "com.example.MyFirstApp.NUMBERPHONE";
    public final static String BIRTHDATE = "com.example.MyFirstApp.BIRTHDATE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etBirthdayDate = (EditText) findViewById(R.id.etBirthdayDate);
        etBirthdayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(FirstActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etBirthdayDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

    }

    public void send_data(View view) {
        etName = findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etNoPhone = findViewById(R.id.etNoPhone);
        etBirthdayDate = findViewById(R.id.etBirthdayDate);
        btnName = findViewById(R.id.btnName);

        String Username = etName.getText().toString();
        String Email= etEmail.getText().toString();
        String Birthdate = etBirthdayDate.getText().toString();
        String Address = etAddress.getText().toString();
        String NoPhone = etNoPhone.getText().toString();

        if(!Email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(Email).matches()){

            Toast.makeText(this,"You are register now!!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(FirstActivity.this,SecondActivity.class);//refer this
            intent.putExtra(USERNAME,Username);
            intent.putExtra(EMAIL,Email);
            intent.putExtra(BIRTHDATE,Birthdate);
            intent.putExtra(ADDRESS,Address);
            intent.putExtra(NUMBERPHONE,NoPhone);
            startActivity(intent);

        }
        //If the email format is wrong, it will be display Invalid Email Address!
        else{

            Toast.makeText(this,"Invalid Email!",Toast.LENGTH_SHORT).show();
        }
    }
}