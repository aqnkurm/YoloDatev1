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

public class Question2 extends AppCompatActivity {
    Button btnLogout;
    Button mMale;
    Button mFemale;
    Button mOther;
    Button mNext;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        btnLogout = findViewById(R.id.logout);
        mMale = findViewById(R.id.button3);
        mFemale = findViewById(R.id.button4);
        mOther = findViewById(R.id.button5);
        mNext = findViewById(R.id.button);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Question2.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String male = mMale.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", male);
                mDatabase.push().setValue(dataMap);
            }
        });
        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String female = mFemale.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", female);
                mDatabase.push().setValue(dataMap);
            }
        });
        mOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String other = mOther.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", other);
                mDatabase.push().setValue(dataMap);
            }
        });
        /*mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, Question3.class);
                startActivity(intToMain);
            }
        });*/
    }
}