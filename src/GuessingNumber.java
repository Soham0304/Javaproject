import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int case1 = 1;
        int case2 = 100;
        int randomNumber = random.nextInt(case2 - case1 + 1) + case1;

        int chance = 0;
        boolean hasGuessed = false;

        System.out.println("Enter a number between " + case1 + " and " + case2);

        while (!hasGuessed) {
            System.out.print("Enter your guessing number: ");
            int userGuess = sc.nextInt();
            chance++;

            if (userGuess < case1 || userGuess > case2) {
                System.out.println("Guess number is not in wide range.");
            } else if (userGuess < randomNumber) {
                System.out.println(" It's Low. Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("It's high. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + randomNumber + " in " + chance + " chance.");
                hasGuessed = true;
            }
        }

        sc.close();
    }
}
