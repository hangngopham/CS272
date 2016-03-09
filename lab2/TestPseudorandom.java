package lab2;

import java.util.*;

/**
 * This class test the Pseudorandom class. It promt the user to enter initial
 * values for seed, multiplier, increment, and modulus, and include test calls
 * of the constructors and methods
 * 
 * @author Hang Ngo
 *
 */
public class TestPseudorandom {

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
		 * Create Pseudorandom object
		 */
		Pseudorandom pr = new Pseudorandom(multiplier, seed, increment, modulus);

		/*
		 * Test nextInt() method
		 */
		System.out.println("The output when nextInt() is called is: "
				+ pr.nextInt());

		/*
		 * Test nextDouble() method
		 */
		System.out.println("The output of when nextDouble() is called is: "
				+ pr.nextDouble());

		/*
		 * Test changeSeed() method
		 */
		System.out.println("The value of seed at the beginning is: "
				+ pr.getSeed());
		int new_seed = (multiplier * seed + increment) % modulus;
		pr.changeSeed(new_seed);
		System.out
				.println("The value of seed after changeSeed() method is called is: "
						+ pr.getSeed());
	}

}
