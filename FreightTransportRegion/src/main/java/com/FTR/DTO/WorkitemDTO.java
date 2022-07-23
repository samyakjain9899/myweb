package com.FTR.DTO;

import com.FTR.Entity.Workitems;


public class WorkitemDTO {
	private Long userId;
	private String workitemId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String messageToRecipient;
	private String quantity;
	private String sourceCountry;
	private String destinationCountry;
	private String originHarborLocation;
	private String selectedHarbourLocations;
	private String shippingDate;
	private Integer amount;
	
	
	public WorkitemDTO(Long userId, String workitemId, String itemName, String itemType, String itemDescription,
			String messageToRecipient, String quantity, String sourceCountry, String destinationCountry,
			String originHarborLocation, String selectedHarbourLocations, String shippingDate, Integer amount) {
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
		this.selectedHarbourLocations = selectedHarbourLocations;
		this.shippingDate = shippingDate;
		this.amount = amount;
	}
	
	
	public WorkitemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public String toString() {
		return "WorkitemDTO [userId=" + userId + ", workitemId=" + workitemId + ", itemName=" + itemName + ", itemType="
				+ itemType + ", itemDescription=" + itemDescription + ", messageToRecipient=" + messageToRecipient
				+ ", quantity=" + quantity + ", sourceCountry=" + sourceCountry + ", destinationCountry="
				+ destinationCountry + ", originHarborLocation=" + originHarborLocation + ", selectedHarbourLocations="
				+ selectedHarbourLocations + ", shippingDate=" + shippingDate + ", amount=" + amount + "]";
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
	public String getSelectedHarbourLocations() {
		return selectedHarbourLocations;
	}
	public void setSelectedHarbourLocations(String selectedHarbourLocations) {
		this.selectedHarbourLocations = selectedHarbourLocations;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
//	public Workitems convertDtoToEntity() {
//		Workitems ftrworkitems = new Workitems();
//		ftrworkitems.setUserId(this.userId);
//		ftrworkitems.setWorkitemId(this.workitemId);
//		ftrworkitems.setItemName(this.itemName);
//		ftrworkitems.setItemType(this.itemType);
//		ftrworkitems.setItemDescription(this.itemDescription);
//		ftrworkitems.setMessageToRecipient(this.messageToRecipient);
//		ftrworkitems.setQuantity(this.quantity);
//		ftrworkitems.setSourceCountry(this.sourceCountry);
//		ftrworkitems.setOriginHarborLocation(this.originHarborLocation);
//		ftrworkitems.setSelectedHarbourLocations(this.selectedHarbourLocations);
//		ftrworkitems.setShippingDate(this.shippingDate);
//		ftrworkitems.setAmount(this.amount);
//		return ftrworkitems;
//		}
	public static Workitems createDtoToEntity(WorkitemDTO dto) {
		Workitems workitem=new Workitems();
		workitem.setAmount(dto.getAmount());
		workitem.setDestinationCountry(dto.getDestinationCountry());
		workitem.setItemDescription(dto.getItemDescription());
		workitem.setItemName(dto.getItemName());
		workitem.setItemType(dto.getItemType());
		workitem.setMessageToRecipient(dto.getMessageToRecipient());
		workitem.setOriginHarborLocation(dto.getOriginHarborLocation());
		workitem.setQuantity(dto.getQuantity());
		workitem.setOriginHarborLocation(dto.getOriginHarborLocation());
		workitem.setShippingDate(dto.getShippingDate());
		workitem.setSourceCountry(dto.getSourceCountry());
		workitem.setUserId(dto.getUserId());
		workitem.setWorkitemId(dto.getWorkitemId());
		return workitem;
	}
	
	public static WorkitemDTO createEntityToDto(Workitems workitem) {
		WorkitemDTO workitemDTO=new WorkitemDTO();
		workitemDTO.setAmount(workitem.getAmount());
		workitemDTO.setDestinationCountry(workitem.getDestinationCountry());
		workitemDTO.setItemDescription(workitem.getItemDescription());
		workitemDTO.setItemName(workitem.getItemName());
		workitemDTO.setItemType(workitem.getItemType());
		workitemDTO.setMessageToRecipient(workitem.getMessageToRecipient());
		workitemDTO.setOriginHarborLocation(workitem.getOriginHarborLocation());
		workitemDTO.setQuantity(workitem.getQuantity());
		workitemDTO.setOriginHarborLocation(workitem.getOriginHarborLocation());
		workitemDTO.setShippingDate(workitem.getShippingDate());
		workitemDTO.setSourceCountry(workitem.getSourceCountry());
		workitemDTO.setUserId(workitem.getUserId());
		workitemDTO.setWorkitemId(workitem.getWorkitemId());
		return workitemDTO;
	}
}
