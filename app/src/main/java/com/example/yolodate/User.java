package com.example.yolodate;


public class User extends HomeActivity {
    private String gender;
    private String preferredSex;
    //private ArrayList<int[]> guys = new ArrayList<>();
    //private ArrayList<int[]> girls = new ArrayList<>();

    // Constructor: Initialize the instance variables to null
    public User() {
        gender = null;
        preferredSex = null;
    }

    public User(String gender) {
        this.gender = gender;
    }

    public User(String gender, String preferredSex) {
        this.gender = gender;
        this.preferredSex = preferredSex;
    }

    // This function asks the user their gender
    // The user must enter 'a', 'b', or 'c' and its case insensitive
    public void setGender(char response) {

        //Scanner genderResponse = new Scanner(System.in);
        System.out.println("What is your gender?");
        //response = genderResponse.next().charAt(0);

        // User entered invalid letter so we ask them again
        while (!(response == 'A' || response == 'a' || response == 'B' || response == 'b' ||
                response == 'C' || response == 'c' || response == 'D' || response == 'd')) {
            System.out.println("You entered an invalid letter. Try again.");
            //response = genderResponse.next().charAt(0);
        }

        if (response == 'A' || response == 'a') {
            gender = "MALE";
        }
        else if (response == 'B' || response == 'b') {
            gender = "FEMALE";
        }
        else if (response == 'C' || response == 'c') {
            gender = "OTHER";
        }
    }

    // This function returns the user's gender
    public String getGender() {
        return gender;
    }

    // This function asks the user their preferred sex
    // The user must enter 'a', 'b', or 'c' and its case insensitive
    public void setPreferredSex(char response) {
        //char response;
        //Scanner preferredSexResponse = new Scanner(System.in);
        System.out.println("What is your preferred gender?");
        //response = preferredSexResponse.next().charAt(0);

        // User entered invalid letter so we ask them again
        while (!(response == 'A' || response == 'a' || response == 'B' || response == 'b' ||
                response == 'C' || response == 'c' || response == 'D' || response == 'd')) {
            System.out.println("You entered an invalid letter. Try again.");
            //response = preferredSexResponse.next().charAt(0);
        }

        if (response == 'A' || response == 'a') {
            preferredSex = "MALE";
        }
        else if (response == 'B' || response == 'b') {
            preferredSex = "FEMALE";
        }
        else if (response == 'C' || response == 'c') {
            preferredSex = "BOTH";
        }
    }

    // This function returns the user's preferred sex
    public String getPreferredSex() {
        return preferredSex;
    }
}