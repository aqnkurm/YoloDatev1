package com.example.yolodate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Question2 extends HomeActivity {
    Button btnLogout;
    Button Male;
    Button Female;
    Button Other;
    Button mNext;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        btnLogout = findViewById(R.id.logout);
        Male = findViewById(R.id.button3);
        Female = findViewById(R.id.button4);
        Other = findViewById(R.id.button5);
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
        Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String male = Male.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", male);
                newFemaleUser.setPreferredSex('A');
                newUser.setPreferredSex('A');
                mDatabase.push().setValue(dataMap);
                Male.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String female = Female.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", female);
                newFemaleUser.setPreferredSex('B');
                newUser.setPreferredSex('B');
                mDatabase.push().setValue(dataMap);
                Female.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String other = Other.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", other);
                newFemaleUser.setPreferredSex('C');
                newUser.setPreferredSex('C');
                mDatabase.push().setValue(dataMap);
                Other.setBackgroundColor(Color.parseColor("#22e4ac"));

            }
        });
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Question2.this, MainActivity2.class);
                startActivity(intToMain);
            }
        });
    }
}
