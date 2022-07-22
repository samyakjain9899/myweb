package com.sim.exception;

public class MethodArgumentNotValidException extends RuntimeException {
	 
		private static final long serialVersionUID = 1L;
		public MethodArgumentNotValidException(String errors) {
			super(errors);
		}
}

