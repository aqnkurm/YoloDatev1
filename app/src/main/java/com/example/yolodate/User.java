package com.example.yolodate;

import java.util.Scanner;

public class User extends HomeActivity {
    //int[] traits = new int[50];
    int[] response = new int[50];

    public User() {
        //traits = null;
        //response = null;
    }

    public void Quiz() {
        Scanner resp = new Scanner(System.in);
        System.out.println("What is your gender?");
        for (int i = 0; i < 50; i++) {
            response[i] = resp.nextInt();
        }
    }

    public static void main(String[] args) {
        
    }
}