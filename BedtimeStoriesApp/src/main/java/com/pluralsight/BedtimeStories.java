package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // For user input

        System.out.print("Enter the name of the story file (e.g., goldilocks.txt): ");
        String fileName = inputScanner.nextLine();

        File file = new File("src/main/resources/" + fileName); // Adjust this path if needed

        try {
            Scanner fileScanner = new Scanner(file); // Scanner to read the file

            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("You trying to crash my program? Try again darling!: " + fileName);
        }

        inputScanner.close();
    }
}

