package com.catherine.balancedBracket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Scanner in = new Scanner(System.in);
		String s = in.next();
		boolean isBalanced = true;
		Stack<Character> stack = new Stack<>();
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (stack.isEmpty() && map.get(c) != null) {
				isBalanced = false;
				break;
			} else if (!stack.isEmpty() && stack.pop() != map.get(c)) {
				isBalanced = false;
				break;
			}
		}
		if (!stack.isEmpty())

		{
			isBalanced = false;
		}
		System.out.println(isBalanced ? "The entered String has Balanced Brackets"
				: "The entered Strings do not contain Balanced Brackets");
		in.close();
	}
}
