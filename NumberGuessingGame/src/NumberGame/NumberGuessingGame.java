package NumberGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int choice;
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Easy       | (10 attempts)");
            System.out.println("2. Medium     | (7 attempts)");
            System.out.println("3. Hard       | (5 attempts)");
            System.out.println("4. Impossible | (1 attempt)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playGame(scanner, random, 1, 100, 10);
                    break;
                case 2:
                    playGame(scanner, random, 1, 100, 7);
                    break;
                case 3:
                    playGame(scanner, random, 1, 100, 5);
                    break;
                case 4:
                    playGame(scanner, random, 1, 100, 1);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4, or 0 to Exit.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void playGame(Scanner scanner, Random random, int minNumber, int maxNumber, int maxAttempts) {
        int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        int attempts = 0;

        System.out.println("I have picked a number between " + minNumber + " and " + maxNumber + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                return;
            }
        }

        System.out.println("Sorry, you've run out of attempts! The number was " + randomNumber + ".");
    }
}
