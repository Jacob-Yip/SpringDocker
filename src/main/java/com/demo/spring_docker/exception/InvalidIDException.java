package com.demo.spring_docker.exception;

public class InvalidIDException extends InvalidDataException {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = -3145399948055450734L;

	public InvalidIDException(Long id) {
		super("id", id);
	}
	
	public InvalidIDException(String msg, Long id) {
		super(msg, "id", id);
	}
	
}
