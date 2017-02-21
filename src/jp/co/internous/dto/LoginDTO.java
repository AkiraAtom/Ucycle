package jp.co.internous.dto;

public class LoginDTO {
    private int customerType;
	private int customerId;
	private String familyname;
	private String password;
	private String mailaddress;

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailaddress() {
		return  mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

}
