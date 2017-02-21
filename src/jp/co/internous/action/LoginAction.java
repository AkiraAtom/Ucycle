package jp.co.internous.action;

import java.util.Map;

import jp.co.internous.dao.LoginDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {


	private static final long serialVersionUID = 1L;
	private String password;
	private String mailaddress;
	private Map<String, Object> sessionMap;
	String result = "error";

	public int DBcustomerType;
	public String DBfamilyname;
	public String DBmailaddress;
	public String error;
	public String DBpassword;


	public String execute() throws Exception {

		LoginDAO dao = new LoginDAO();
		if (dao.select(password, mailaddress)) {
			result = "success";

			DBcustomerType = dao.getDBcustomerType();
			DBfamilyname = dao.getDBfamilyname();
			DBmailaddress = dao.getDBMailaddress();
			DBpassword = dao.getDBpassword();

			sessionMap.put("customerType", dao.getDBcustomerType());
			sessionMap.put("customerId", dao.getDBcustomerId());
			sessionMap.put("familyname", dao.getDBfamilyname());
			sessionMap.put("mailaddress", dao.getDBMailaddress());

		} else {
			error = "該当する情報がありません";
		}
		System.out.println("result"+result);
		return result;
	}

		public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSession1(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setMailaddress(String mailaddress) {
			this.mailaddress = mailaddress;
		}

		@Override
		public void setSession(Map<String, Object> sessionMap) {
			this.sessionMap=sessionMap;
		}

}
