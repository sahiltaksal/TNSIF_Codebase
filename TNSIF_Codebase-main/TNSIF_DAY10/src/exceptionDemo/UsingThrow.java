package exceptionDemo;

import java.util.Scanner;

public class UsingThrow {

	static int acceptNumber() {
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.println("Enter your percentage..........");
		n = scanner.nextInt();
		scanner.close();
		return n;
	}

	public static void main(String[] args) {

		int per;
		per = acceptNumber();
		try {
			if (per < 0) {

				throw new negativeException();
			} else if (per > 100) {
				throw new generateValueException();
			} else {
				System.out.println("Percentage : "+per);
			}
		} catch (negativeException | generateValueException e) {
			System.err.println("Errorr....... "+e.getMessage());
		}
	}

}
