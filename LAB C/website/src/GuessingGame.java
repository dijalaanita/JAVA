import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int secretNumber = (int) (Math.random() * 100) + 1;
        int guess;
        int numGuesses = 0;
        Scanner input = new Scanner(System.in);
        boolean win = false;

        System.out.println("I'm thinking of a number between 1 and 100. You have 5 chances to guess it.");

        while (!win && numGuesses < 5) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            numGuesses++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses.");
                win = true;
            } else if (guess < secretNumber) {
                System.out.println("Your guess is too low. You have " + (5 - numGuesses) + " guesses left.");
            } else {
                System.out.println("Your guess is too high. You have " + (5 - numGuesses) + " guesses left.");
            }
        }

        if (!win) {
            System.out.println("Sorry, you ran out of guesses. The number was " + secretNumber + ".");
        }
    }
}