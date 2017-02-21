package jp.co.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoReservationAction 購入確認画面へ遷移する為のアクション
 * 
 * @author Miyazono Akira
 * @since 2015/6/3
 * @version 1.0
 */
public class GoReservationAction extends ActionSupport implements SessionAware {
	/**
	 * 実行メソッド
	 * 
	 * @author Miyazono Akira
	 * @since 2015/6/3
	 * @return success
	 */

	String number;
	String number2;

	String name;
	String expiry;
	String cvc;
	String result = "error";

	public Map<String, Object> sessionMap;

	public String execute() {
		
		System.out.println(number);
		
		String number2 = number.substring(0, 2);
		System.out.println(number2);
		
		if(number2.equals("34") || number2.equals("37")){
			if(number.length() == 17) {
			if(expiry.length() == 5){
			if(cvc.length() == 3 || cvc.length() == 4){
				sessionMap.put("creditnumber", number);
				sessionMap.put("creditname", name);
				sessionMap.put("expire", expiry);
				sessionMap.put("securitycode", cvc);
				result = "success";	
			}
			}
			}
		} else if(number2.equals("51") || number2.equals("52") || number2.equals("53") || number2.equals("54") || number2.equals("55") || number2.equals("40") || number2.equals("41") || number2.equals("42") || number2.equals("43") || number2.equals("44") || number2.equals("45") || number2.equals("46") || number2.equals("47") || number2.equals("48") || number2.equals("49")){
			if(number.length() == 19) {
			if(expiry.length() == 5){
			if(cvc.length() == 3){
			sessionMap.put("creditnumber", number);
			sessionMap.put("creditname", name);
			sessionMap.put("expire", expiry);
			sessionMap.put("securitycode", cvc);
				result = "success";
			}
			}
			}
	} 

		
		
		
		
		return result ;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber2() {
		return number2;
	}

	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * セッション情報格納メソッド
	 * 
	 * @author Okumura Reo
	 * @since 2015/05/15
	 * @param sessionMap
	 *            　
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}