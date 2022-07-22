package com.sim.utlity;

import java.time.LocalDateTime;


public class ErrorMessage {
	    private int errorCode;
	    private String message;
	    private LocalDateTime timstamp;
		public int getErrorCode() {
			return errorCode;
		}
		public LocalDateTime getTimstamp() {
			return timstamp;
		}
		public void setTimstamp(LocalDateTime timstamp) {
			this.timstamp = timstamp;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		} 
}
