package lab2;

import java.util.Random;
import java.util.Scanner;

/**
 * This class determines distribution of numbers. It prompt the user to enter
 * initial values for seed, multiplier, increment, and modulus, and output a
 * table with numbers of occurrences for each range
 * 
 * @author Hang Ngo
 *
 */
public class TestDistribution {
	public static void main(String[] args) {

		/*
		 * Prompt the user to enter initial value for multiplier
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Enter mulitplier:");
		int multiplier = input.nextInt();

		/*
		 * Prompt the user to enter initial value for seed
		 */
		System.out.println("Enter seed:");
		int seed = input.nextInt();

		/*
		 * Prompt the user to enter initial value for increment
		 */
		System.out.println("Enter increment:");
		int increment = input.nextInt();

		/*
		 * Prompt the user to enter initial value for modulus
		 */
		System.out.println("Enter modulus:");
		int modulus = input.nextInt();

		/*
		 * Initialize variable to count number of occurrences for each range
		 */
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		int count10 = 0;

		/*
		 * Output a table with number of occurrences for each range
		 */
		System.out.println("Range\t\t" + "Number of Occurrences");

		Pseudorandom pr = new Pseudorandom(multiplier, seed, increment, modulus);
		for (int i = 0; i < 1000000; i++) {

			int newSeed = pr.nextInt();
			pr.changeSeed(newSeed);
			double num = pr.nextDouble();

			if (num >= 0.0 && num < 0.1) {
				count1++;
			} else if (num >= 0.1 && num < 0.2) {
				count2++;
			} else if (num >= 0.2 && num < 0.3) {
				count3++;
			} else if (num >= 0.3 && num < 0.4) {
				count4++;
			} else if (num >= 0.4 && num < 0.5) {
				count5++;
			} else if (num >= 0.5 && num < 0.6) {
				count6++;
			} else if (num >= 0.6 && num < 0.7) {
				count7++;
			} else if (num >= 0.7 && num < 0.8) {
				count8++;
			} else if (num >= 0.8 && num < 0.9) {
				count9++;
			} else if (num >= 0.9 && num < 1.0) {
				count10++;
			}
		}
		System.out.println("[0.0..0.1)     " + count1);
		System.out.println("[0.1..0.2)     " + count2);
		System.out.println("[0.2..0.3)     " + count3);
		System.out.println("[0.3..0.4)     " + count4);
		System.out.println("[0.4..0.5)     " + count5);
		System.out.println("[0.5..0.6)     " + count6);
		System.out.println("[0.6..0.7)     " + count7);
		System.out.println("[0.7..0.8)     " + count8);
		System.out.println("[0.8..0.9)     " + count9);
		System.out.println("[0.9..1.0)     " + count10);

	}
}
