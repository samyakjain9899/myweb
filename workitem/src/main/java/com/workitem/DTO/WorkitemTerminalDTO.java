package com.workitem.DTO;

import com.workitem.entity.WorkitemTerminal;

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
   public static WorkitemTerminal createEntity(WorkitemTerminalDTO dto) {
	   WorkitemTerminal entity = new WorkitemTerminal();
	   entity.setTerminalId(dto.getTerminalId());
	   entity.setWorkitemId(dto.getWorkitemId());
	   return entity;
   }
   public static WorkitemTerminalDTO valueOf(WorkitemTerminal entity) {
	   WorkitemTerminalDTO dto = new WorkitemTerminalDTO();
	   dto.setTerminalId(entity.getTerminalId());
	   dto.setWorkitemId(entity.getWorkitemId());
	   return dto;
   }
}
