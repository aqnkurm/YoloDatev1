package com.example.yolodate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    Button male;
    Button female;
    Button other;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        male = findViewById(R.id.button3);
        female = findViewById(R.id.button4);
        other = findViewById(R.id.button5);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Button> dataMap = new HashMap<String, Button>();
                dataMap.put("Name", male);
                mDatabase.push().setValue(dataMap);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Button> dataMap = new HashMap<String, Button>();
                dataMap.put("Name", female);
                mDatabase.push().setValue(dataMap);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Button> dataMap = new HashMap<String, Button>();
                dataMap.put("Name", other);
                mDatabase.push().setValue(dataMap);
            }
        });
    }
}
