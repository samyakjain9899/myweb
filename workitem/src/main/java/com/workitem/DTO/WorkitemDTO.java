package com.workitem.DTO;

import java.time.LocalDate;

import com.workitem.entity.Workitem;

public class WorkitemDTO {
	private Long userId;      // Unique id of the user
	private String workitemId;  // Unique id of the load request
	private String itemName;    // Name of the shipping item
	private String itemType;    // Type/Category of shipping item
	private String itemDescription; //Detailed description about the item
	private String messageToRecipient;  // Message for the recipient
	private String quantity;           // Quantity of the item in kg/lit/no. of items
	private String sourceCountry;      // Country name
	private String destinationCountry;   // Destination Country name
	private String originHarborLocation;  // Harbor Location in the selected Country
	private String selectedHarborLocation;   // Harbor Location in the destination Country
	private LocalDate shippingDate;          // Shipping Date
	private Integer amount;               // Cost for the shipping of the item. it will be calculated based on the quantity and best price.
	
	public WorkitemDTO() {
		super();
	}
	public WorkitemDTO(Long userId, String workitemId, String itemName, String itemType, String itemDescription,
			String messageToRecipient, String quantity, String sourceCountry, String destinationCountry,
			String originHarborLocation, String selectedHarborLocation, LocalDate shippingDate, Integer amount) {
		super();
		this.userId = userId;
		this.workitemId = workitemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.messageToRecipient = messageToRecipient;
		this.quantity = quantity;
		this.sourceCountry = sourceCountry;
		this.destinationCountry = destinationCountry;
		this.originHarborLocation = originHarborLocation;
		this.selectedHarborLocation = selectedHarborLocation;
		this.shippingDate = shippingDate;
		this.amount = amount;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getWorkitemId() {
		return workitemId;
	}
	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getMessageToRecipient() {
		return messageToRecipient;
	}
	public void setMessageToRecipient(String messageToRecipient) {
		this.messageToRecipient = messageToRecipient;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSourceCountry() {
		return sourceCountry;
	}
	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}
	public String getDestinationCountry() {
		return destinationCountry;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public String getOriginHarborLocation() {
		return originHarborLocation;
	}
	public void setOriginHarborLocation(String originHarborLocation) {
		this.originHarborLocation = originHarborLocation;
	}
	public String getSelectedHarborLocation() {
		return selectedHarborLocation;
	}
	public void setSelectedHarborLocation(String selectedHarborLocation) {
		this.selectedHarborLocation = selectedHarborLocation;
	}
	public LocalDate getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(LocalDate shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public static Workitem createEntity(WorkitemDTO dto) {
		Workitem workitem=new Workitem();
		workitem.setAmount(dto.getAmount());
		workitem.setDestinationCountry(dto.getDestinationCountry());
		workitem.setItemDescription(dto.getItemDescription());
		workitem.setItemName(dto.getItemName());
		workitem.setItemType(dto.getItemType());
		workitem.setMessageToRecipient(dto.getMessageToRecipient());
		workitem.setOriginHarborLocation(dto.getOriginHarborLocation());
		workitem.setQuantity(dto.getQuantity());
		workitem.setSelectedHarborLocation(dto.getSelectedHarborLocation());
		workitem.setShippingDate(dto.getShippingDate());
		workitem.setSourceCountry(dto.getSourceCountry());
		workitem.setUserId(dto.getUserId());
		workitem.setWorkitemId(dto.getWorkitemId());
		return workitem;
	}
	
	public static WorkitemDTO valueOf(Workitem workitem) {
		WorkitemDTO workitemDTO=new WorkitemDTO();
		workitemDTO.setAmount(workitem.getAmount());
		workitemDTO.setDestinationCountry(workitem.getDestinationCountry());
		workitemDTO.setItemDescription(workitem.getItemDescription());
		workitemDTO.setItemName(workitem.getItemName());
		workitemDTO.setItemType(workitem.getItemType());
		workitemDTO.setMessageToRecipient(workitem.getMessageToRecipient());
		workitemDTO.setOriginHarborLocation(workitem.getOriginHarborLocation());
		workitemDTO.setQuantity(workitem.getQuantity());
		workitemDTO.setSelectedHarborLocation(workitem.getSelectedHarborLocation());
		workitemDTO.setShippingDate(workitem.getShippingDate());
		workitemDTO.setSourceCountry(workitem.getSourceCountry());
		workitemDTO.setUserId(workitem.getUserId());
		workitemDTO.setWorkitemId(workitem.getWorkitemId());
		return workitemDTO;
	}

}
