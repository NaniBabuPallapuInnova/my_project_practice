package mypractice.com.practice;

import java.util.Calendar;
import java.util.Date;

public class Check {

    public static final int EXPIRATION_TIME = 10;

    private Date calculateExpirationTime(){

        // Create a Calendar instance and set it to the current date and time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());

        // Add a specified number of minutes(10 minutes) to the current date and time
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);

        // Convert the Calendar's time to a Date object and return it
        return new Date(calendar.getTime().getTime());
    }
    public static void main(String[] args) {
        Check check = new Check();
        System.out.println(check.calculateExpirationTime());
    }
}
