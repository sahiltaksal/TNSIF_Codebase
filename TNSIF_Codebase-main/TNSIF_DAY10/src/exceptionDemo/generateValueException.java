package exceptionDemo;

public class generateValueException extends Exception {

	public generateValueException (String s) {
		super(s);
	}
	public generateValueException () {
		super("Percentage should not be more than 100");
	}
}

