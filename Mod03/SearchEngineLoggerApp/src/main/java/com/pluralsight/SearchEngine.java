package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngine {
    // Method to log actions to logs.txt
    public static void logAction(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true)); // Append mode
            LocalDateTime now = LocalDateTime.now(); // Get current time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timeStamp = now.format(formatter); // Format timestamp

            writer.write(timeStamp + " " + action);
            writer.newLine(); // Go to next line
            writer.close();   // Save and close the file
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Log application launch
        logAction("launch");

        while (true) {
            System.out.print("Enter a search term (Bye to exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Bye")) {
                logAction("exit");  // Log exit
                System.out.println("Thank you for searching honey!.");
                break;
            } else {
                logAction("search : " + input); // Log search term
            }
        }

        scanner.close(); // Close the scanner
    }


}
