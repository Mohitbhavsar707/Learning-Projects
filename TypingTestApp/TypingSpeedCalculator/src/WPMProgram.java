import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WPMProgram {

	static String[] sentence = { "hello", "how", "is", "it", "going",
			"today", "happy", "birthday", "random", "words",
			"and", "or", "but", "because", "Fred", "Jane", "Richard Nixon", "Miss America"
			,"a", "the", "every", "some",
			"runs", "jumps", "talks", "sleeps",
			"loves", "hates", "sees", "knows", "looks for", "finds"};

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		double timeExpected = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("What is your target time (WPM)?");
		timeExpected = input.nextInt();
		System.out.println("Time goal set to: " + timeExpected + " WPM");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Preparing test...");
		TimeUnit.SECONDS.sleep(3);

		System.out.print(" 3 ");
		TimeUnit.SECONDS.sleep(1);

		System.out.print(" \n 2 ");
		TimeUnit.SECONDS.sleep(1);

		System.out.print("\n 1 \n");
		TimeUnit.SECONDS.sleep(1);

		Random rand = new Random();
		for (int i = 0; i < sentence.length; i++) {
			System.out.print(sentence[rand.nextInt(31)] + " ");

		}
		System.out.println("\n");

		double formula = 0.0;

		do {

			Scanner scan = new Scanner(System.in);

			double timeStarted = LocalTime.now().toSecondOfDay();

			String wordsTyped = scan.nextLine();

			double end = LocalTime.now().toSecondOfDay();
			double timePassed = end - timeStarted;

			int numChars = wordsTyped.length();
			formula = (double) (((numChars / 5) / timePassed) * 60);

			System.out.println("Your WPM is: " + formula);
			
			if(formula < timeExpected) {
				System.out.println("Try Again");
			}else {
				System.out.println("Great job, you did it");
				input.close();
			}

		} while (formula < timeExpected);

		
		
	}

}
