package ru.netology.moneytransfer.domain;

public class Transfer {
	private String cardFromNumber;
	private String cardFromValidTill;
	private String cardFromCVV;
	private String cardToNumber;
	private Amount amount;

	public Transfer() {
	}

	public Transfer(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber,
			Amount amount) {
		this.cardFromNumber = cardFromNumber;
		this.cardFromValidTill = cardFromValidTill;
		this.cardFromCVV = cardFromCVV;
		this.cardToNumber = cardToNumber;
		this.amount = amount;
	}

	public String getCardFromNumber() {
		return cardFromNumber;
	}

	public String getCardFromValidTill() {
		return cardFromValidTill;
	}

	public String getCardFromCVV() {
		return cardFromCVV;
	}

	public String getCardToNumber() {
		return cardToNumber;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setCardFromNumber(String cardFromNumber) {
		this.cardFromNumber = cardFromNumber;
	}

	public void setCardFromValidTill(String cardFromValidTill) {
		this.cardFromValidTill = cardFromValidTill;
	}

	public void setCardFromCVV(String cardFromCVV) {
		this.cardFromCVV = cardFromCVV;
	}

	public void setCardToNumber(String cardToNumber) {
		this.cardToNumber = cardToNumber;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
