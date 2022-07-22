package com.sim.exception;

public class InvalidValuesException extends Exception {
	 
		private static final long serialVersionUID = 1L;
		public InvalidValuesException(String errors) {
			super(errors);
		}
}
