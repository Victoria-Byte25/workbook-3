package com.pluralsight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

    public class FormatDateApp {
        public static void main(String[] args) {
            // 1. Get current local date and time
            LocalDateTime now = LocalDateTime.now();

            // 2. Define different date/time formats
            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm");

            // 3. Print each format
            System.out.println(now.format(format1));  // Example: 09/05/2021
            System.out.println(now.format(format2));  // Example: 2021-09-05
            System.out.println(now.format(format3));  // Example: September 5, 2021
            System.out.println(now.format(format4));  // Example: Sunday, Sep 5, 2021 10:02

            // CHALLENGE: Show time as "5:02 on 05-Sep-2021" in local time
            DateTimeFormatter challengeFormat = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy");
            System.out.println(now.format(challengeFormat));

            // BONUS
            ZonedDateTime gmtNow = ZonedDateTime.now(ZoneId.of("GMT"));
            System.out.println("GMT Time: " + gmtNow.format(format4));

            // BONUS
            ZonedDateTime localNow = ZonedDateTime.now();
            System.out.println("Local Time: " + localNow.format(format4));
        }


}
