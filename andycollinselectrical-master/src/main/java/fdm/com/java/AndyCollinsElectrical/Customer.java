package fdm.com.java.AndyCollinsElectrical;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity (name = "customerList")
public class Customer {
		
	@Id
	@Column(name = "customer_id", length = 8)
	private int customerId;
	@Column(name = "customerFirstName", length = 50)
	private String customerFirstName;
	@Column(name = "customerLastName", length = 50)
	private String customerLastName;
	@Column(name = "addressLineOne", length = 50)
	private String addressLineOne;
	@Column(name = "addressLineTwo", length = 50)
	private String addressLineTwo;
	@Column(name = "addressLineThree", length = 50)
	private String addressLineThree;
	@Column(name = "city", length = 50)
	private String city;
	@Column(name = "postcode", length = 50)
	private String postcode;
	@Column(name = "phoneNumberOne", length = 50)
	private String phoneNumberOne;
	@Column(name = "phoneNumberTwo", length = 50)
	private String phoneNumberTwo;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "howHeardAboutAce", length = 50)
	private String howHearAboutACE;
	@Column(name = "altCustomerToInvoice", length = 8, nullable = true)
	private int altCustomerIdToInvoice;
	
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String customerFirstName, String customerLastName, String addressLineOne,
			String addressLineTwo, String addressLineThree, String city, String postcode, String phoneNumberOne,
			String phoneNumberTwo, String email, String howHearAboutACE, int altCustomerIdToInvoice) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.city = city;
		this.postcode = postcode;
		this.phoneNumberOne = phoneNumberOne;
		this.phoneNumberTwo = phoneNumberTwo;
		this.email = email;
		this.howHearAboutACE = howHearAboutACE;
		this.altCustomerIdToInvoice = altCustomerIdToInvoice;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getAddressLineThree() {
		return addressLineThree;
	}
	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhoneNumberOne() {
		return phoneNumberOne;
	}
	public void setPhoneNumberOne(String phoneNumberOne) {
		this.phoneNumberOne = phoneNumberOne;
	}
	public String getPhoneNumberTwo() {
		return phoneNumberTwo;
	}
	public void setPhoneNumberTwo(String phoneNumberTwo) {
		this.phoneNumberTwo = phoneNumberTwo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHowHearAboutACE() {
		return howHearAboutACE;
	}
	public void setHowHearAboutACE(String howHearAboutACE) {
		this.howHearAboutACE = howHearAboutACE;
	}
	public int getAltCustomerIdToInvoice() {
		return altCustomerIdToInvoice;
	}
	public void setAltCustomerIdToInvoice(int altCustomerIdToInvoice) {
		this.altCustomerIdToInvoice = altCustomerIdToInvoice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLineOne == null) ? 0 : addressLineOne.hashCode());
		result = prime * result + ((addressLineThree == null) ? 0 : addressLineThree.hashCode());
		result = prime * result + ((addressLineTwo == null) ? 0 : addressLineTwo.hashCode());
		result = prime * result + altCustomerIdToInvoice;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((howHearAboutACE == null) ? 0 : howHearAboutACE.hashCode());
		result = prime * result + ((phoneNumberOne == null) ? 0 : phoneNumberOne.hashCode());
		result = prime * result + ((phoneNumberTwo == null) ? 0 : phoneNumberTwo.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (addressLineOne == null) {
			if (other.addressLineOne != null)
				return false;
		} else if (!addressLineOne.equals(other.addressLineOne))
			return false;
		if (addressLineThree == null) {
			if (other.addressLineThree != null)
				return false;
		} else if (!addressLineThree.equals(other.addressLineThree))
			return false;
		if (addressLineTwo == null) {
			if (other.addressLineTwo != null)
				return false;
		} else if (!addressLineTwo.equals(other.addressLineTwo))
			return false;
		if (altCustomerIdToInvoice != other.altCustomerIdToInvoice)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (customerFirstName == null) {
			if (other.customerFirstName != null)
				return false;
		} else if (!customerFirstName.equals(other.customerFirstName))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerLastName == null) {
			if (other.customerLastName != null)
				return false;
		} else if (!customerLastName.equals(other.customerLastName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (howHearAboutACE == null) {
			if (other.howHearAboutACE != null)
				return false;
		} else if (!howHearAboutACE.equals(other.howHearAboutACE))
			return false;
		if (phoneNumberOne == null) {
			if (other.phoneNumberOne != null)
				return false;
		} else if (!phoneNumberOne.equals(other.phoneNumberOne))
			return false;
		if (phoneNumberTwo == null) {
			if (other.phoneNumberTwo != null)
				return false;
		} else if (!phoneNumberTwo.equals(other.phoneNumberTwo))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		return true;
	}

	
	
	
	
	
	

}
