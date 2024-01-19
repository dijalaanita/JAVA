package eecs1021;

import java.util.Random;

public class LABD_B
{
    static final int UPPER_BOUND = 38;
    public static void main(String[] args)
    {
        var RandomNumber = new Random();
        var randomAns = RandomNumber.nextInt(UPPER_BOUND); //Answer generated range 0-18
        System.out.print("Answer: " + randomAns + "\n");

        // Guess range btw 0-19
        var SmallValue = 0;
        var BigValue = 38;

        int counter = 0; // guesses count

        while (true) {
            counter++;
            int guess = RandomNumber.nextInt(BigValue - SmallValue) + SmallValue;
            System.out.println("\nGuess: " + guess);

            if (guess < randomAns) {
                System.out.println("guess < answer");
                SmallValue = guess;
            }
            else if(guess > randomAns){
                System.out.println("guess > answer");
                BigValue = guess;
            }
            else{
                break;
            }
        }
        System.out.println("Correct! Took " + counter + " guesses");
    }
}