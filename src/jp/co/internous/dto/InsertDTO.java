package jp.co.internous.dto;

public class InsertDTO{

	private int customerId;
	private String familyname;
	private String givenname;
	private String mailaddress;
	private int postcode;
	private String address;
	private String housenumber;
	private String phone;
	private String password;
	private int expiredate;
	private int securityCode;
	private int customer_type;


	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getGivenname() {
		return givenname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getExpireDate() {
		return expiredate;
	}
	public void setExpireDate(int expiredate) {
		this.expiredate = expiredate;
	}
	public int getsecurityCode() {
		return securityCode;
	}
	public void setsecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public int getCustomer_type() {
		return customer_type;
	}
	public void setCustomertype(int customertype) {
		this.customer_type = customertype;
	}



}








