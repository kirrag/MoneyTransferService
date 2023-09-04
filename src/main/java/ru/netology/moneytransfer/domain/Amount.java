package ru.netology.moneytransfer.domain;

public class Amount {
	Integer value;
	String type;

	public Amount() {
	}

	public Amount(int value, String type) {
		this.value = value;
		this.type = type;
	}

	public Integer getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return Integer.toString(value) + " " + type;
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
