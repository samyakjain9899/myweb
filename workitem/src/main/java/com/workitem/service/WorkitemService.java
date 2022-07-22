package com.workitem.service;

import java.util.List;

import com.workitem.DTO.VehicleWorkitemDTO;
import com.workitem.DTO.WorkitemDTO;

public interface WorkitemService {

	public WorkitemDTO createWorkitem(WorkitemDTO workitemDTO);
	public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO);
	public List<String> fetchAvailableHarborLocations(String country) throws Exception;
	public List<WorkitemDTO> fetchWorkitemDetails();
	public List<WorkitemDTO> trackWorkitemByUser(Long userId);
    public VehicleWorkitemDTO fetchWorkitemStatus(String workitemId) throws Exception;
//	//public TerminalDTO updateWorkitemStatus(String workitemId, TerminalDTO terminalDTO);
//	public WorkitemDTO fetchWorkitemById(String workitemId);
//	//public TerminalDTO findTerminalForWorkitem(WorkitemDTO workitemDTO,List<TerminalDTO> terminals);
//	public String assignTerminalForWorkitem(String workitemId,String terminalId);
	//public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId);
	public VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber);
	//public String allocateVehicle(String workitemId, List<VehicleDTO> vehicleDTOList);
	//public VehicleDTO findVehicleForWorkitem(String workitemId, List<VehicleDTO> vehicleDTOList);
	
}
