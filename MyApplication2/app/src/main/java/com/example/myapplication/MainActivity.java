package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText e1 , e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextTextEmailAddress);
        e2 = findViewById(R.id.editTextTextPassword);
    }

    public void login(View view) {

        if(e1.getText().length() > 0)
        {
            if(e2.getText().length() >= 8)
            {
                Toast.makeText(this, " Loging ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( this , MainActivity3.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, " Password must be 8 lenght or more then", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Enter Email ID", Toast.LENGTH_SHORT).show();
        }

    }

    public void back(View view) {

        Intent intent = new Intent( this , MainActivity2.class);
        startActivity(intent);

    }
}