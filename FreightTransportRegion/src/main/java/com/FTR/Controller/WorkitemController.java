package com.FTR.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.FTR.DTO.WorkitemDTO;
import com.FTR.DTO.WorkitemVehicleDTO;
import com.FTR.Services.WorkitemServiceImpl;
import com.FTR.exceptions.HarborNotFoundException;
import com.FTR.exceptions.WorkItemNotFoundException;



@RestController
@RequestMapping("/ftr")
public class WorkitemController {
	@Autowired
	WorkitemServiceImpl service;
	
	@Autowired
	Environment environment;

	  //User can create a new workitem.
		@PostMapping("/workitems")
		public ResponseEntity<WorkitemDTO> createWorkitem(@RequestBody WorkitemDTO newWorkitem) {
		WorkitemDTO workitemDTO =service.createWorkitem(newWorkitem);
			ResponseEntity<WorkitemDTO> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
			return responseEntity;
		}

		//User can update their workitem details.
		@PutMapping("/workitems/{workItemId}")
		public ResponseEntity<String> updateWorkitem(@PathVariable String workitemId,@RequestBody WorkitemDTO workitemDTO){
			String message=service.updateWorkitemId(workitemId, workitemDTO);
			ResponseEntity<String> responseEntity = new ResponseEntity<>(message,HttpStatus.ACCEPTED);
			return responseEntity;
		}
		

		
		//	User can view the available harbor locations.
		@GetMapping("/workitems/{fromCountry}")
		 ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable String fromCountry) throws HarborNotFoundException{
			List<String> str=service.fetchAvailableHarborLocations(fromCountry);
			ResponseEntity<List<String>> responseEntity= new ResponseEntity<>(str,HttpStatus.ACCEPTED);
			return responseEntity;
		}
		
		//Admin can view all the workitem details
		//pagenation and sorting
		@GetMapping(value="/workitems")
	     ResponseEntity<List<WorkitemDTO>> fetchWorkitemDetails() throws WorkItemNotFoundException{
		    List<WorkitemDTO> workitems=service.fetchWorkItemDetails();
		    ResponseEntity<List<WorkitemDTO>> responseEntity = new ResponseEntity<>(workitems,HttpStatus.ACCEPTED);
		    return responseEntity;
		}
		
		//	User can track their workitem status details.
		@GetMapping("/workitems/managed-user/{userId}")
		ResponseEntity<List<WorkitemDTO>> trackWorkitemByUser(@PathVariable Long userId){
		List<WorkitemDTO> workitems=service.trackWorkitemByUser(userId);
		ResponseEntity<List<WorkitemDTO>> entity = new ResponseEntity<>(workitems,HttpStatus.ACCEPTED);
		return entity;
	}
		
		//Admin can track the status of each workitem based on workitemId.
		//localhost:8004/ftr/workItems/managed-status/{workItemId}
//		@GetMapping("/workitems/managed-status/{workItemId}")
//		ResponseEntity<WorkitemVehicleDTO> fetchWorkitemStatus(@PathVariable String workitemId)  {
//			WorkitemVehicleDTO dto = service.fetchWorkitemStatus(workitemId);
//			ResponseEntity<WorkitemVehicleDTO> entity = new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
//			return entity;
//		}
		//put//	Admin can update the status of the workitem as "Completed" or "NotInitiated" or "InProgress".
		//localhost:8004/ftr/workItems/managed-update/{workItemId}
		
//		@PutMapping("/managed-update/{workItemId}")
//		public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workitemId){
//			service.updateWorkItemStatus(workitemId);
//			ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
//			return responseEntity;
//			
//		}
		
//		//post-	Admin can assign the terminal for workitem based on the item type.
//		//localhost:8004/ftr/workItems/managed-terminal/{workItemId}
//		@PostMapping("/managed-terminal/{workItemId}")
//		public ResponseEntity<String> assignTerminalForWorkitem(String workitemId){
//			
//		}
		
		//get-Admin can view the workitem details based on the vehicleNumber.
		//localhost:8004/ftr/workItems/managed-vehicle/{vehicleNumber}
//		@GetMapping("/workitems/managed-vehicle/{vehicleNumber}")
//		ResponseEntity<WorkitemVehicleDTO> fetchWorkitemDetailsByVehicleNumber(@PathVariable String vehicleNumber){
//			WorkitemVehicleDTO dto = service.fetchWorkItemDetailsByVehicleNumber(vehicleNumber);
//			ResponseEntity<WorkitemVehicleDTO> responseEntity = new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
//			return responseEntity;
//		}

		
//		//post	Admin can allocate vehicle for a workitem.
//		//localhost:8004/ftr/workItems/managed-vehicle/{workItemId}
//		@PostMapping("/managed-vehicle/{workItemId}")
//		public ResponseEntity<String> allocateVehicle( String workitemId){
//			
//			
//			
//		}
		
		
		

}
