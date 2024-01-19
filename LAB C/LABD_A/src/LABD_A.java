package eecs1021;
import java.util.Random;
import java.util.Scanner;

public class LABD_A
{
    static final int UPPER_BOUND = 19;
    public static void main(String[] args)
    {
        var RandomNumber = new Random(); // random object
        var randoms = RandomNumber.nextInt(UPPER_BOUND);
        System.out.println("Answer: " + randoms);

        System.out.print("Enter a guess: ");
        var sc = new Scanner(System.in);
        int counter = 0;

        while (sc.hasNextInt())
        {
            counter++;
            var guess = sc.nextInt();
            if (guess < randoms)
            {
                System.out.println("Guess is lower than your answer\n");
                System.out.print("Enter a guess: ");
            }

            else if (guess > randoms)
            {
                System.out.println("Guess is higher than your answer\n");
                System.out.print("Enter a guess: ");
            }

            else
            {
                System.out.println("Correct! Took " + counter + " guesses");
                break;
            }
        }
    }
}