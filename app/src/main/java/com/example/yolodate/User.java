package com.example.yolodate;

import com.example.yolodate.HomeActivity;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends HomeActivity {
    ArrayList <Integer> traits = new ArrayList();
    ArrayList <Integer> response = new ArrayList();
    public User() {
        traits = null;
        response = null;
    };

    public void Quiz () {
        Scanner resp = new Scanner(System.in);
        System.out.println("What is your gender?");
        int response = resp.nextInt();
        traits.add (response);
    }

    public static void main(String[] args) {
        
    }
}