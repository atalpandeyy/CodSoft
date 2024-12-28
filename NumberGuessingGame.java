import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = maxAttempts;

            System.out.println("\nI'm thinking of a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it correctly.");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess (Attempts left: " + attemptsLeft + "): ");

                try {
                    int guess = Integer.parseInt(scanner.nextLine());

                    if (guess < minRange || guess > maxRange) {
                        System.out.println("Please guess a number between " + minRange + " and " + maxRange + ".");
                        continue;
                    }

                    if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly!");
                        score++;
                        break;
                    }

                    attemptsLeft--;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            if (attemptsLeft == 0) {
                System.out.println("\nSorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("\nYour current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("\nThanks for playing! Your final score: " + score);
            }
        }

        scanner.close();
    }
}
