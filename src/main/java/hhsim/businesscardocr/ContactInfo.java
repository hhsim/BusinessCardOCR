package hhsim.businesscardocr;

public class ContactInfo {
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	public ContactInfo(String name, String phoneNumber, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		String contactInfo = "Name: "+name+"\nPhone: "+phoneNumber+"\nEmail: "+emailAddress;
		return contactInfo;
	}
	
	/**
	 * Returns the full name of the individual (eg. John Smith, Susan Malick)
	 * @param
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the phone number formatted as a sequence of digits
	 * @param
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Returns the email address
	 * @param
	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
}