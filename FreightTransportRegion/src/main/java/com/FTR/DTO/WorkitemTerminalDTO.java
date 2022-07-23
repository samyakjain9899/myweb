package com.FTR.DTO;

public class WorkitemTerminalDTO {
	
		private String workitemId;
		private String terminalId;
		public WorkitemTerminalDTO() {
			super();
		}
		public WorkitemTerminalDTO(String workitemId, String terminalId) {
			super();
			this.workitemId = workitemId;
			this.terminalId = terminalId;
		}
		public String getWorkitemId() {
			return workitemId;
		}
		public void setWorkitemId(String workitemId) {
			this.workitemId = workitemId;
		}
		public String getTerminalId() {
			return terminalId;
		}
		public void setTerminalId(String terminalId) {
			this.terminalId = terminalId;
		}
}
