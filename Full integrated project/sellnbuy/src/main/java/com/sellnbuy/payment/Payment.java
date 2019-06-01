package com.sellnbuy.payment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	
	private int id;
	private String name;
	private String country;
	private String contactNo;
	private String date;
	private String creditCardType;
	private int creditCardNo;
	private String securityCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public int getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(int creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", name=" + name + ", country=" + country + ", contactNo=" + contactNo + ", date="
				+ date + ", creditCardType=" + creditCardType + ", creditCardNo=" + creditCardNo + ", securityCode="
				+ securityCode + "]";
	}


}
