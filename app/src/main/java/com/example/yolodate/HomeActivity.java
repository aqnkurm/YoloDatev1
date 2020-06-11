package com.example.yolodate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    Button mMale;
    Button mFemale;
    Button mOther;
    Button mNext;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String userId, male, female, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        mMale = findViewById(R.id.button3);
        mFemale = findViewById(R.id.button4);
        mOther = findViewById(R.id.button5);
        mNext = findViewById(R.id.button);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();
        getUserInfo();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User newUser = new User("Male");
                String male = mMale.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", male);
                mDatabase.push().setValue(dataMap);
                mMale.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String female = mFemale.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", female);
                mDatabase.push().setValue(dataMap);
                mFemale.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        mOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String other = mOther.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", other);
                mOther.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, Question2.class);
                startActivity(intToMain);
                saveUserInformation();
            }
        });
    }

    private void saveUserInformation() {
        male = mMale.getText().toString();
        female = mFemale.getText().toString();
        other = mOther.getText().toString();
        Map userInfo = new HashMap();
        userInfo.put("name", male);
        userInfo.put("name", female);
        userInfo.put("name", other);
        mDatabase.updateChildren(userInfo);
    }

    private void getUserInfo() {
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if (map.get("name") != null) {
                        male = map.get("name").toString();
                        mMale.setText(male);
                    }
                    if (map.get("phone") != null) {
                        female = map.get("phone").toString();
                        mFemale.setText(female);
                    }
                    if (map.get("phone") != null) {
                        other = map.get("phone").toString();
                        mOther.setText(other);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
