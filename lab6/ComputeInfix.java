package lab6;

import java.util.*;

public class ComputeInfix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an expression: ");
		String exp = input.nextLine();

		LinkedStack<Integer> numStack = new LinkedStack();
		LinkedStack<Character> opStack = new LinkedStack();

		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '(') {
				opStack.push(exp.charAt(i));
			} else if (Character.isDigit(exp.charAt(i))) {
				int num;
				num = Integer.parseInt(exp.substring(i, i + 1));
				numStack.push(num);

			} else if (isOperator(exp.charAt(i))) {
				while (!opStack.isEmpty() && opStack.peek() != '(') {
//					HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//
//					map.put('*', 2);
//					map.put('/', 2);
//					map.put('+', 1);
//					map.put('-', 1);

//					if (map.get(opStack.peek()) > map.get(exp.charAt(i))) {
//						operation(numStack, opStack);
//					}
					System.out.println(precedence(opStack.peek()));
					if(precedence(opStack.peek()) > precedence(exp.charAt(i))) {
						operation(numStack, opStack);
					}

					opStack.push(exp.charAt(i));
				}
			} else {
				while (opStack.peek() != '(' && !opStack.isEmpty()) {
					operation(numStack, opStack);
				}

				if (opStack.peek() != '(') {
					System.out.println("Unbalanced parentheses");
					System.exit(1);
				}

				opStack.pop();
			}
		}

		while (!opStack.isEmpty()) {
			operation(numStack, opStack);
		}

		System.out.println(numStack.toString());
		System.out.println(opStack.toString());

		System.out.println(numStack.peek());
	}

	public static boolean isOperator(char arr) {
		char[] operators = { '+', '-', '*', '/' };
		for (int j = 0; j < operators.length; j++) {
			if (arr == operators[j]) {
				return true;
			}
		}
		return false;
	}

	public static boolean operation(LinkedStack<Integer> nums,
			LinkedStack<Character> op) {

		if (nums.size() < 2) {
			return false;
		}
		int a = nums.pop();
		int b = nums.pop();

		switch (op.pop()) {
		case '+':
			nums.push(a + b);
			break;
		case '-':
			nums.push(a - b);
			break;
		case '*':
			nums.push(a * b);
			break;
		case '/':
			nums.push(a / b);
			break;
		}
		return true;
	}

	public static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		}
		throw new IllegalArgumentException("Operator unknown");
		
	}

}
