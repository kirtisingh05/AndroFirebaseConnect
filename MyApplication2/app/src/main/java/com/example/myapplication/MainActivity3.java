package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {

    DatabaseReference reference;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.editTextTextPersonName);
        reference = FirebaseDatabase.getInstance().getReference("data");
    }
    public void send(View view) {

        reference.push().setValue(editText.getText().toString().trim());
    }

    public void back(View view) {

        Intent intent = new Intent( this , MainActivity2.class);
        startActivity(intent);
    }

    public void get(View view) {

        reference.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists())
                {
                    snapshot.getChildren().forEach(dataSnapshot -> {

                        Toast.makeText(getApplicationContext() , dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getApplicationContext() ,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}