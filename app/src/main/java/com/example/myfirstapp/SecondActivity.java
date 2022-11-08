package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String USERNAME= "com.example.MyFirstApp.message_key";
    public final static String EMAIL = "com.example.MyFirstApp.EMAIL";
    public final static String BIRTHDATE = "com.example.MyFirstApp.BIRTHDATE";
    public final static String ADDRESS="com.example.MyFirstApp.ADDRESS";
    public final static String NUMBERPHONE = "com.example.MyFirstApp.NUMBERPHONE";



    TextView tvUserName,tvEmail,tvBirthday,tvAddress,tvNoPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second);

        tvUserName=findViewById(R.id.tvUserName);
        tvEmail=findViewById(R.id.tvEmail);
        tvBirthday=findViewById(R.id.tvBirthday);
        tvAddress=findViewById(R.id.tvAddress);
        tvNoPhone=findViewById(R.id.tvNoPhone);

        Intent intent = getIntent();

        String Username =intent.getStringExtra(USERNAME);
        String Email = intent.getStringExtra(EMAIL);
        String Birthdate=intent.getStringExtra(BIRTHDATE);
        String Address=intent.getStringExtra(ADDRESS);
        String NoPhone=intent.getStringExtra(NUMBERPHONE);


        tvUserName.setTextSize(20);
        tvUserName.setText("Name : "+Username);

        tvEmail.setTextSize(20);
        tvEmail.setText("\nEmail : "+Email);

        tvBirthday.setTextSize(20);
        tvBirthday.setText("\nBirth Date : "+Birthdate);

        tvAddress.setTextSize(20);
        tvAddress.setText("\nAddress : "+Address);

        tvNoPhone.setTextSize(20);
        tvNoPhone.setText("\nNo Phone: "+NoPhone);
        
    }
}
