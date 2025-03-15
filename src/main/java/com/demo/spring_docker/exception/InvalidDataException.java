package com.demo.spring_docker.exception;

public class InvalidDataException extends IllegalArgumentException {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 3034566705303176639L;
	
	private Object data;
	private String dataName;
	
	public InvalidDataException(String msg, String dataName, Object data) {
		super(msg + ": " + data.toString());
		
		this.dataName = dataName;
		this.data = data;
	}
	
	public InvalidDataException(String dataName, Object data) {
		super("Invalid data: " + data.toString());
		
		this.dataName = dataName;
		this.data = data;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public String getDataName() {
		return this.dataName;
	}
}
