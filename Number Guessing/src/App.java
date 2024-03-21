import java.util.Random;
import java.util.Scanner;

public class App {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    private static int playRound(int guessingNumber, Scanner scanner) {
        int score = 0;

        for (int attempts = 1; attempts <= MAX_ATTEMPTS; attempts++) {
            int remainingAttempts = MAX_ATTEMPTS - attempts;
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int playerGuess = scanner.nextInt();

            if (playerGuess == guessingNumber) {
                System.out.println("\n -------------------------------------------------------\n");
                System.out.println("Congratulations! You guessed the correct number.");
                System.out.println("The number was: " + guessingNumber);
                System.out.println("Total attempts: " + attempts);
                score = MAX_ATTEMPTS - attempts;
                break;
            } else if (playerGuess < guessingNumber) {
                System.out.println("The number is greater than " + playerGuess + ".");
                System.out.println("Remaining attempts: " + remainingAttempts);
            } else {
                System.out.println("The number is less than " + playerGuess + ".");
                System.out.println("Remaining attempts: " + remainingAttempts);
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Out of attempts! The correct number was: " + guessingNumber);
            }
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println("------------------ Number Guessing Game --------------------");
        System.out.printf("The computer has chosen a number between %d and %d.\nTotal Rounds: %d\n", MIN_RANGE, MAX_RANGE, MAX_ROUNDS);
        
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Can you guess the number? You have " + MAX_ATTEMPTS + " attempts.");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            System.out.printf("--------------------- Round %d ------------------------\n", round);
            int guessingNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;

            int score = playRound(guessingNumber, scanner);

            System.out.printf("Round %d Score: %d\n", round, score);
        }

        scanner.close();
    }

}
