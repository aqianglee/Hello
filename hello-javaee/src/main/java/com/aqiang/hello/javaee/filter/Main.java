package com.aqiang.hello.javaee.filter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		int int0 = Integer.parseInt(temp);
		int result = getFin(int0);
		System.out.println(result);
		scanner.close();
	}

	private static int getFin(int index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return getFin(index - 2) + getFin(index - 1);
		}
	}
}
