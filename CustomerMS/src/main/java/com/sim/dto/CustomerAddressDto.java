package com.sim.dto;



public class CustomerAddressDto {
	private String address;
	private String city;
	private String pincode;
	private String state;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerAddress [  address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}
	public CustomerAddressDto(String address, String city, String pincode, String state) {
		super();
		
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	public CustomerAddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
