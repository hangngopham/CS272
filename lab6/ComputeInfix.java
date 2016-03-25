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
			System.out.println(numStack.toString());
			System.out.println(opStack.toString());
			if (exp.charAt(i) == '(') {
				opStack.push(exp.charAt(i));
			} else if (Character.isDigit(exp.charAt(i))) {
				int num;
				int j = i;
				while(i < exp.length() && Character.isDigit(exp.charAt(i))) {
					i++;
				}
				num = Integer.parseInt(exp.substring(j,i));
				numStack.push(num);
				i--;

			} else if (isOperator(exp.charAt(i))) {
				while (!opStack.isEmpty() && opStack.peek() != '('
						&& !precedence(opStack.peek(), exp.charAt(i))) {

	System.out.println("Peek is " + opStack.peek());
					operation(numStack, opStack);

				}

				opStack.push(exp.charAt(i));

				//System.out.println(opStack.toString());

			} else {
				while (opStack.peek() != '(' && !opStack.isEmpty()) {
					//System.out.println("Peek");
					operation(numStack, opStack);
				}

				if (opStack.peek() != '(') {
					System.out.println("Unbalanced parentheses");
					System.exit(1);
				}

				opStack.pop();
			}

		}// end for loop
		while (!opStack.isEmpty()) {
			operation(numStack, opStack);
			System.out.println("Peek");
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

	public static void operation(LinkedStack<Integer> nums,
			LinkedStack<Character> op) {
		if (nums.size() < 2) {
			return;
		}
		int a = nums.pop();
		int b = nums.pop();

		switch (op.pop()) {
		case '+':
			nums.push(b + a);
			break;
		case '-':
			nums.push(b - a);
			break;
		case '*':
			nums.push(b * a);
			break;
		case '/':
			nums.push(b / a);
			break;
		}
	}

	public static boolean precedence(char op1, char op2) {
		return (op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/');
	}

}
