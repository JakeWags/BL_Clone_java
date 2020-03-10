package exceptions;

public class InvalidCardException extends RuntimeException {
	public InvalidCardException() {
		super("Invalid Card.");
	}
}
