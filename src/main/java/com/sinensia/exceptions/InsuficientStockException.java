package com.sinensia.exceptions;

import java.io.Serializable;

public class InsuficientStockException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public InsuficientStockException(String message) {
		super(message);
	}

}
