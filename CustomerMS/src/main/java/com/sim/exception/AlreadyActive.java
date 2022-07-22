package com.sim.exception;

public class AlreadyActive extends Exception {
	 
		private static final long serialVersionUID = 1L;
		public AlreadyActive(String errors) {
			super(errors);
		}
}
