package lab6;

import java.util.*;

public class Palindrome {

	public static void palindrome(int n) {

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many integers are in the sequence? ");
		int num = input.nextInt();
		if(num == 0) {
			throw new IllegalArgumentException("There is no integer in the sequence");
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

		LinkedStack ls2 = new LinkedStack();
		for (int j = 0; j < ls.size() / 2; j++) {
			ls2.push(ls.peek());
			ls.pop();
		}

		boolean same = true;
		if (ls.size() % 2 == 0) {
			for (int a = 0; a < ls.size(); a++) {
				if (ls.peek() != ls2.peek()) {
					same = false;
				}
			}
			ls.pop();
			ls2.pop();
		}

		if (ls.size() % 2 != 0) {
			ls.pop();
			for(int a = 0; a < ls.size(); a++) {
				if(ls.peek() != ls2.peek()) {
					same = false;
				}
			}
		}
		
		if(same) {
			System.out.println("This sequence is palindromic");
		}
		else {
			System.out.println("This sequence is not palindromic");
		}

	}

}
