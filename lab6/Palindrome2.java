package lab6;

import java.util.Scanner;

public class Palindrome2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many integers are in the sequence? ");
		int num = input.nextInt();
		if (num == 0) {
			throw new IllegalArgumentException(
					"There is no integer in the sequence");
		}
		System.out.println();
		System.out.println("Please enter a sequence of " + num + " integers:");
		int i = 0;
		LinkedStack ls = new LinkedStack();
		while (i < num) {
			int n = input.nextInt();
			ls.push(n);
			i++;
		}
		System.out.println(ls);
		
		LinkedStack copy = ls.clone();
		System.out.println(copy);
		
		LinkedStack reverse = new LinkedStack();
		int listSize = ls.size();
		for (int j = 0; j < listSize; j++) {
			reverse.push(ls.peek());
			ls.pop();
		}
		System.out.println(reverse);

		boolean same = true;
		for (int a = 0; a < listSize; a++) {
			if (reverse.peek() != copy.peek()) {
				same = false;
			}
			reverse.pop();
			copy.pop();
		}
		System.out.println(ls);
		System.out.println(copy);
		System.out.println(reverse);
		System.out.println();
		if (same) {
			System.out.println("This sequence is palindromic");
		} else {
			System.out.println("This sequence is not palindromic");
		}
		

	}
}
