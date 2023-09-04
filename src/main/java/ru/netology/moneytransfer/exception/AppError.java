package ru.netology.moneytransfer.exception;

public class AppError {
	private String message;
	private int id;

	public AppError() {
	}

	public AppError(String message, int id) {
		this.message = message;
		this.id = id;
	}

	public String getOperationId() {
		return message;
	}

	public int getId() {
		return id;
	}

	public void setOperationId(String message) {
		this.message = message;
	}

	public void setId(int id) {
		this.id = id;
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
