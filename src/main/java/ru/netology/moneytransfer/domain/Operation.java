package ru.netology.moneytransfer.domain;

public class Operation {
	private String operationId;
	private String code;

	public Operation() {
	}

	public Operation(String operationId, String code) {
		this.operationId = operationId;
		this.code = code;
	}

	public String getOperationId() {
		return operationId;
	}

	public String getCode() {
		return code;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public void setCode(String code) {
		this.code = code;
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
