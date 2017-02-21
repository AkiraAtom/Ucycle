package jp.co.internous.action;



import java.util.Map;

import jp.co.internous.dao.InfoDAO;
import jp.co.internous.dao.InsertDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

	public class InsertAction extends ActionSupport implements SessionAware {


	public int customerId;
	public int customertype;
	public String familyname;
	public String lastname;
	public String customerPass1;
	public String customerPass2;
	public String phone;
	public String mailaddress1;
	public String mailaddress2;
	public String postcode;
	public int postcode1;
	public String address;
	public String housenumber;
	public String creditname;
	public String creditnumber;
	public String expire1;
	public String expire2;
	public String expire3;
	public int expire;
	public String securitycode;
	public int securitycode1;



	public Map<String, Object> sessionMap;
	public String errormsg =null;
	public String errorpass =null;
	public String errormail =null;
	public String result = "error";

	public String DBcustomerName;
	public String DBmailaddress;
	public int DBpostcode;
	public String DBaddress;

	public String DBtellnumber;
	public String DBhousenumber;
	public String DBpassword;

	InsertDAO dao = new InsertDAO();
	InfoDAO dao2 = new InfoDAO();
	private String DBphone;
	private String DBcustomerLastName;
	private String DBcustomerFamilyName;
	private int DBcustomerId;
	private String DBcreditName;
	private String DBcreditNumber;
	private int DBcustomerType;
	private int DBexpire;
	private int DBsecurity;
	private String customerPass3;
	public String erroremailad;





	public String execute() throws Exception {
		System.out.println("メソッド開始");
		if (customerPass1.equals(customerPass2)) {
			System.out.println("test1");
			if (mailaddress1.equals(mailaddress2)) {
				System.out.println("test2");


				 String expire3 = expire1 + expire2;
				 expire = Integer.parseInt(expire3);
				 postcode1 = Integer.parseInt(postcode);

				 securitycode1 = Integer.parseInt(securitycode);

				if (dao.insert(customertype,familyname,lastname,customerPass1,phone,mailaddress1,postcode1, address, housenumber, creditname,creditnumber,expire,securitycode1)) {
					System.out.println("test3");

					dao2.select(customerId);
					DBcustomerType = dao2.DBcustomerType;
					DBcustomerId = dao2.DBcustomerId;
					DBcustomerFamilyName = dao2.DBcustomerFamilyName;
					DBcustomerLastName = dao2.DBgivenname;
					System.out.println("aaa");
					DBmailaddress = dao2.DBmailaddress;
					DBpostcode = dao2.DBpostcode;
					DBaddress = dao2.DBaddress;
					DBphone = dao2.DBphone;
					DBhousenumber = dao2.DBhousenumber;

					DBcreditName = dao2.DBcreditName;
					DBcreditNumber = dao2.DBcreditNumber;
					DBexpire = dao2.DBexpiredate;
					DBsecurity = dao2.DBsecurity;


					System.out.println("IDIDIDIDIDID");

					System.out.println(dao2.DBpostcode);

					sessionMap.put("customerType", DBcustomerType);
					sessionMap.put("customer_Id", DBcustomerId);

					if(customertype == 1){
					sessionMap.put("premiumCustomerfamilyname", DBcustomerFamilyName);
					sessionMap.put("premiumCustomerlastname",DBcustomerLastName);
					}else{
					sessionMap.put("customerfamilyname", DBcustomerFamilyName);
					sessionMap.put("customerlastname",DBcustomerLastName);
					}

					sessionMap.put("mailaddress", DBmailaddress);
					sessionMap.put("postcode", DBpostcode);
					sessionMap.put("address", DBaddress);
					sessionMap.put("phone", DBphone);
					sessionMap.put("houseNumber", DBhousenumber);
					sessionMap.put("creditName", DBcreditName);
					sessionMap.put("credit_name", DBcreditNumber);
					sessionMap.put("expire", DBexpire);
					sessionMap.put("security", DBsecurity);



					System.out.println("test5");
					System.out.println("test");
					String passpass = customerPass1;
					customerPass3 = "*";
					String pass4 = "*";
					System.out.println("test2");
					for (int i = 1; i < passpass.length(); i++) {
						System.out.println("test3");
						customerPass3 = customerPass3 + pass4;
					}
					sessionMap.put("passpass", customerPass3);
					result = "success";
				} else {
					errormsg = "*入力されたメールアドレスは他のユーザーにより使用中です";
				}
			} else {
				erroremailad = "*同じメールアドレスを入力してください";
			}
		} else {
			errorpass = "*同じパスワードを入力してください";
		}
		return result;
	}

public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getCustomertype() {
		return customertype;
	}

	public void setCustomertype(int customertype) {
		this.customertype = customertype;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCustomerPass1() {
		return customerPass1;
	}

	public void setCustomerPass1(String customerPass1) {
		this.customerPass1 = customerPass1;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMailaddress1() {
		return mailaddress1;
	}

	public void setMailaddress1(String mailaddress1) {
		this.mailaddress1 = mailaddress1;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
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

	public String getCreditname() {
		return creditname;
	}

	public void setCreditname(String creditname) {
		this.creditname = creditname;
	}

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public String getCustomerPass3() {
		return customerPass3;
	}

	public void setCustomerPass3(String customerPass3) {
		this.customerPass3 = customerPass3;
	}

/**
 * セッション情報取得メソッド
 * @author Okumura Reo
 * @since 2015/05/15
 * @return sessionMap
 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
/**
 * セッション情報格納メソッド
 * @author  Okumura Reo
 * @since  2015/05/15
 * @param  sessionMap　
 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}



