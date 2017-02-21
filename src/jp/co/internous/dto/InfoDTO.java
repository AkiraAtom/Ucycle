package jp.co.internous.dto;
/**
 * InfoDTO 
 * 顧客情報を格納するクラス
 * @author Okumura Reo
 * @since 2015/6/3
 * @version 1.0
 */
public class InfoDTO {
	/**
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * customerType 会員タイプ
	 * familyName 顧客苗字
	 * givenName 顧客名前 
	 * password パスワード 
	 * phone 電話番号
	 * mailaddress メールアドレス 
	 * postcode 郵便番号 
	 * address 住所 
	 * housenumber　番地以降住所 
	 * creditName クレジットカード名義 
	 * creditNumber　クレジットカード番号
	 * exipireDate クレジットカード有効期限 
	 * security クレジットカードセキュリティコード
	 */
	private int customerType;
	private int customerId;
	private String familyName;
	private String givenName;
	private String password;
	private String phone;
	private String mailaddress;
	private int postcode;
	private String address;
	private String housenumber;
	private String CreditName;
	private String CreditNumber;
	private int ExpireDate;
	private int Security;
	/**
	 * 顧客苗字取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 顧客苗字格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	/**
	 * 顧客名前取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return cgivenName
	 */
	public String getGivenName() {
		return givenName;
	}
	/**
	 * 顧客名前格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param givenName
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	/**
	 * 顧客パスワード取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 顧客パスワード格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 顧客電話番号取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 顧客電話番号格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 顧客メールアドレス取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return mailaddress
	 */
	public String getMailaddress() {
		return mailaddress;
	}
	/**
	 * 顧客メールアドレス格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param mailaddress
	 */
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	/**
	 * 顧客郵便番号取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return postcode
	 */
	public int getPostcode() {
		return postcode;
	}
	/**
	 * 顧客郵便番号格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param postcode
	 */
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	/**
	 * 顧客住所取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 顧客住所格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 顧客番地取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return housenumber
	 */
	public String getHousenumber() {
		return housenumber;
	}
	/**
	 * 顧客番地格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param housenumber
	 */
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	/**
	 * クレジットカード名義取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return CreditName
	 */
	public String getCreditName() {
		return CreditName;
	}
	/**
	 * クレジットカード名義格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param creditName
	 */
	public void setCreditName(String creditName) {
		CreditName = creditName;
	}
	/**
	 * クレジットカード番号取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return CreditNumber
	 */
	public String getCreditNumber() {
		return CreditNumber;
	}
	/**
	 * クレジットカード番号格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param creditNumber
	 */
	public void setCreditNumber(String creditNumber) {
		CreditNumber = creditNumber;
	}
	/**
	 * 会員タイプ取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return customerType
	 */
	public int getCustomerType() {
		return customerType;
	}
	/**
	 * 会員タイプ格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param customerType
	 */
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	/**
	 * 会員ID格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * クレジットカード有効期限格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param expireDate
	 */
	public void setExpireDate(int expireDate) {
		ExpireDate = expireDate;
	}
	/**
	 * クレジットカードセキュリティコード格納メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param security
	 */
	public void setSecurity(int security) {
		Security = security;
	}
	/**
	 * 会員ID取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * クレジットカード有効期限取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return ExpireDate
	 */
	public int getExpireDate() {
		return ExpireDate;
	}
	/**
	 * クレジットカードセキュリティコード取得メソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @return Security
	 */
	public int getSecurity() {
		return Security;
	}
}