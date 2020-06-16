package com.example.yolodate;

public class Driver extends User{
    double matchScore;  // Global variable which we are gonna use later

    // This function determines if 2 users can be matched based on
    // their gender and what sex they prefer
    // We can try an array of users if this doesn't work on the app
    static boolean MatchSex(User user1, User user2) {
        boolean matchSuccess = false;					// Variable to determine if the users matched

        // Get user1's info
        String user1Gender = user1.getGender();
        String user1PreferredSex = user1.getPreferredSex();

        // Get user2's info
        String user2Gender = user2.getGender();
        String user2PreferredSex = user2.getPreferredSex();

        // These if-else statements determine whether or not the match can be made
        // based on the info the users provided
        if ((user1Gender == user2PreferredSex) && (user2Gender == user1PreferredSex)) {
            matchSuccess = true;
        }
        else if (user1PreferredSex == "BOTH" && (user1Gender == user2PreferredSex)) {
            matchSuccess = true;
        } else matchSuccess = user2PreferredSex == "BOTH" && (user2Gender == user1PreferredSex);
        return matchSuccess;
    }

    // Try the algorithm with 2 users
    public static void main(String[] args) {
        User me = new User();
        me.setGender('a');
        System.out.println(me.getGender());
        me.setPreferredSex('b');
        System.out.println(me.getPreferredSex());

        User you = new User();
        you.setGender('f');
        System.out.println(you.getGender());
        you.setPreferredSex('e');
        System.out.println(you.getPreferredSex());

        if (MatchSex(me, you) == true) {
            System.out.println("Code to do rest of program");
        } else {
            System.out.println("We will stop the program");
        }
    }

}
