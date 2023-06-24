package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText e1 , e2 , e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        e1 = findViewById(R.id.editTextTextEmailAddress2);
        e3 = findViewById(R.id.editTextTextPasswordA);
        e2 = findViewById(R.id.editTextTextPasswordB);
    }

    public void reg(View view) {

        if(e1.getText().length() > 0)
        {
            if(e2.getText().length() >= 8)
            {
               if(e2.getText().length() == e3.getText().length())
               {
                   String p = e2.getText().toString();
                   String cp = e3.getText().toString();
                   if( p.equals(cp))
                   {
                       Toast.makeText(this, " Register done!! ", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent( this , MainActivity3.class);
                       startActivity(intent);
                   }
                   else
                   {
                       Toast.makeText(this, "Conform password and password must be same ", Toast.LENGTH_SHORT).show();
                   }
               }
               else
               {
                   Toast.makeText(this, " Conform password and password must be of same length !! ", Toast.LENGTH_SHORT).show();
               }
            }
            else
            {
                Toast.makeText(this, " Password must be 8 length or more then", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Enter Email ID", Toast.LENGTH_SHORT).show();
        }

    }

    public void bck_H(View view) {

        Intent intent = new Intent( this , MainActivity2.class);
        startActivity(intent);

    }
}