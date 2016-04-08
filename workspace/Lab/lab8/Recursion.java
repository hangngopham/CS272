package lab8;

import java.util.Scanner;

public class Recursion {
	/**
	 * Precondition: m <= n, m > 0, n > 0
	 * 
	 * Postcondition: The method has printed a pattern of 2*(n-m+1) lines to the
	 * standard output. The first line contains m asterisks, the next line
	 * contains m+1 asterisks, and so on up to a line with n asterisks. Then the
	 * pattern is repeated backwards, going n back down to m.
	 * 
	 * @param m
	 *            - number of asterisks in the first line
	 * @param n
	 *            - number of asterisks in the middle 2 lines
	 */
	public static void triangle(int m, int n) {
		if (n == 0) {
			System.out.println();
		} else {
			if (m <= n) {
				drawAsterisks(m);
				m++;
				triangle(m, n);
				drawAsterisks(m - 1);
			}
		}
	}

	public static void drawAsterisks(int num) {
		if (num == 0) {
			System.out.println();
		} else {
			System.out.print("*");
			drawAsterisks(num - 1);
		}

	}

	/**
	 * Prints output consisting of the String prefix followed by prefix of the
	 * form 1.1., 1.2.,1.3., and so on.
	 * 
	 * @param prefix
	 * @param levels
	 *            - the number of levels the prefix has
	 */
	public static void numbers(String prefix, int levels) {
		if (levels == 0) {
			System.out.println(prefix);
		} else {
			String answer = prefix;
			for (int i = 1; i <= 9; i++) {
				answer = prefix + i + ".";
				numbers(answer, levels - 1);
			}
		}
	}

	/**
	 * The longest line of the pattern has n stars beginning in column i of the
	 * output
	 * 
	 * @param n
	 * @param i
	 */
	public static void pattern(int n, int i) {
		if (n == 1) {
			for (int k = 0; k < 2 * i; k++) {
				System.out.print(" ");
			}
			System.out.println("* ");
		} else {
			pattern(n / 2, i);
			for (int k = 0; k < 2 * i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n; j++) {
				System.out.print("* ");
			}
			System.out.print("\n");
			pattern(n / 2, n / 2 + i);
		}
	}

	/**
	 * Precondition: n is non-negative
	 * 
	 * Postcondition: The method prints the value of n as a BINARY number. If n
	 * is 0, then a single zero is printed; otherwise no leading zeros are
	 * printed in the output. The '\n' character is NOT printed at the end of
	 * the output.
	 * 
	 * @param n
	 *            - an integer
	 */
	public static void binaryPrint(int n) {
		if (n >= 2) {
			binaryPrint(n / 2);
		}
		System.out.print(n % 2);

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Test triangle method");
		System.out.println("Enter the first number: ");
		int num1 = input.nextInt();
		System.out.println("Enter the second number: ");
		int num2 = input.nextInt();
		triangle(num1, num2);

		System.out.println("Test numbers method");
		System.out.println("Enter the prefix: ");
		String word = input.next();
		System.out.println("Enter level: ");
		int level = input.nextInt();
		numbers(word, level);

		System.out.println("Test pattern method");
		System.out.println("Enter the number of asterisks: ");
		int num3 = input.nextInt();
		System.out.println("Enter the number of columns: ");
		int num4 = input.nextInt();
		pattern(num3, num4);

		System.out.println("Test binaryPrint method");
		System.out.println("Enter number: ");
		int num5 = input.nextInt();
		System.out.print("If n=" + num5 + " then output is ");
		binaryPrint(num5);

	}
}
