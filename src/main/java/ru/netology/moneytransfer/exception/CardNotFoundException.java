package ru.netology.moneytransfer.exception;

public class CardNotFoundException extends RuntimeException {

	public CardNotFoundException(String cardNumber) {
		super("Could not find Card " + cardNumber);
	}
}
