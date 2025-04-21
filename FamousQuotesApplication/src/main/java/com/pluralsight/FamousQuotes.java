package com.pluralsight;

    import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
        public static void main(String[] args) {
            // Array to store 10 famous Nigerian & African quotes
            String[] quotes = {
                    "Until the lion learns to write, every story will glorify the hunter. – African Proverb",
                    "He who learns, teaches. – Ethiopian Proverb",
                    "A man who uses force is afraid of reasoning. – Kenyan Proverb",
                    "Wisdom is like a baobab tree; no one individual can embrace it. – Akan Proverb (Ghana)",
                    "Not to know is bad. Not to wish to know is worse. – Nigerian Proverb",
                    "The child who is not embraced by the village will burn it down to feel its warmth. – African Proverb",
                    "A single bracelet does not jingle. – Congolese Proverb",
                    "Rain does not fall on one roof alone. – Cameroonian Proverb",
                    "No matter how long the night, the day is sure to come. – African Proverb",
                    "If you think you're too small to make a difference, you haven't spent a night with a mosquito. – African Proverb"
            };

            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Select a quote by number (1–10)");
                System.out.println("2. See a random quote");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                String input = scanner.nextLine();

                if (input.equals("1")) {
                    System.out.print("Enter a number between 1 and 10: ");
                    try {
                        int number = Integer.parseInt(scanner.nextLine());
                        if (number >= 1 && number <= 10) {
                            System.out.println("Quote: " + quotes[number - 1]);
                        } else {
                            System.out.println("❌ Invalid number. Please choose between 1 and 10.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ That wasn’t a number. Please try again.");
                    }

                } else if (input.equals("2")) {
                    int randomIndex = rand.nextInt(10);
                    System.out.println("🎲 Random Quote: " + quotes[randomIndex]);

                } else if (input.equals("3")) {
                    System.out.println("👋 Thank you for exploring African wisdom. Goodbye!");
                    break;

                } else {
                    System.out.println("❌ Invalid option. Please enter 1, 2, or 3.");
                }
            }

            scanner.close();
        }


}
