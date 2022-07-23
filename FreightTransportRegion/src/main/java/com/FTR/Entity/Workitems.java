package com.FTR.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.FTR.DTO.WorkitemDTO;

@Entity
@Table(name="ftr_workitem")
public class Workitems {
	private Long userId;
	@Id
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
//	public WorkitemDTO convertEntityToDto() {
////	
////	WorkitemDTO workitemdto = new WorkitemDTO();
////	workitemdto.setUserId(this.userId);
////	workitemdto.setWorkitemId(this.workitemId);
////	workitemdto.setItemName(this.itemName);
////	workitemdto.setItemType(this.itemType);
////	workitemdto.setItemDescription(this.itemDescription);
////	workitemdto.setMessageToRecipient(this.messageToRecipient);
////	workitemdto.setQuantity(this.quantity);
////	workitemdto.setSourceCountry(this.sourceCountry);
////	workitemdto.setOriginHarborLocation(this.originHarborLocation);
////	workitemdto.setSelectedHarbourLocations(this.selectedHarbourLocations);
////	workitemdto.setShippingDate(this.shippingDate);
////	workitemdto.setAmount(this.amount);
////	return workitemdto;
////	}
	
}
