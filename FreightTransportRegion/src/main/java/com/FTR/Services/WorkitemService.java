package com.FTR.Services;

import java.util.List;

import com.FTR.DTO.WorkitemDTO;
import com.FTR.DTO.WorkitemVehicleDTO;

public interface WorkitemService {
	  public WorkitemDTO createWorkitem(WorkitemDTO workitemDto);
	  public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO);
	  public List<String> fetchAvailableHarborLocations(String country);
	  public List<WorkitemDTO> fetchWorkItemDetails();
	  public List<WorkitemDTO> trackWorkitemByUser(Long userId);
	  public WorkitemVehicleDTO fetchWorkitemStatus(String workitemId);
	  public WorkitemVehicleDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber);
//	  public TerminalDTO findTerminalForWorkitem(WorkitemDTO workitemDto, List<TerminalDTO> terminals);
//	  public String assignTerminalForWorkitem(String workitemId, String terminalId);
//	  public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId);
//	  public String allocateVehicle(String workitemId,List<VehicleDTO> vehicleDtoList);
//	  public VehicleDTO findVehicleForWorkitem(String workitemId,List<VehicleDTO> vehicleDtoList);
//	  public WorkitemDTO fetchWorkItemById(String workitemId);
//	  public TerminalDTO updateWorkItemStatus(String workitemId, TerminalDTO terminalDto);
//	  
	  
	  
	  

}
