package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText etName;
    Button btnName;
    public final static String MESSAGE_KEY ="com.example.MyFirstApp.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void send_data(View view){
        etName=findViewById(R.id.etName);
        btnName=findViewById(R.id.btnName);
        String message = etName.getText().toString();
        Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
        intent.putExtra(MESSAGE_KEY,message);
        startActivity(intent);



    }
}