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
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    User newFemaleUser = new User("Female");
    User newUser = new User("Male");
    Button btnLogout;
    Button Male;
    Button Female;
    Button Other;
    Button mNext;
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("users");
    private FirebaseAuth mAuth;
    private String userId, male, female, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        Male = findViewById(R.id.button3);
        Female = findViewById(R.id.button4);
        Other = findViewById(R.id.button5);
        mNext = findViewById(R.id.button);
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
        Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String male = Male.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", male);
                newUser.setGender('A', male);
                mDocRef.set(dataMap);
                Male.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String female = Female.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", female);
                newFemaleUser.setGender('B', female);
                mDocRef.set(dataMap);
                Female.setBackgroundColor(Color.parseColor("#22e4ac"));
            }
        });
        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String other = Other.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", other);
                mDocRef.set(dataMap);
                Other.setBackgroundColor(Color.parseColor("#22e4ac"));
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
        male = Male.getText().toString();
        female = Female.getText().toString();
        other = Other.getText().toString();
        Map userInfo = new HashMap();
        userInfo.put("name", male);
        userInfo.put("name", female);
        userInfo.put("name", other);
        mDocRef.set(userInfo);
    }

    private void getUserInfo() {
        mDocRef.set(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if (map.get("name") != null) {
                        male = map.get("name").toString();
                        Male.setText(male);
                    }
                    if (map.get("name") != null) {
                        female = map.get("name").toString();
                        Female.setText(female);
                    }
                    if (map.get("name") != null) {
                        other = map.get("name").toString();
                        Other.setText(other);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
