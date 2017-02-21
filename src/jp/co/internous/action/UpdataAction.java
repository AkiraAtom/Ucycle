package jp.co.internous.action;

import java.util.Map;

import jp.co.internous.dao.InfoDAO;
import jp.co.internous.dao.UpdataDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * UpdataAction
 * 顧客情報編集画面から顧客情報を編集する為のアクション
 * @author Kametani Yuki
 * @since 2015/6/3
 * @version 1.0
 */
public class UpdataAction extends ActionSupport implements SessionAware {
	/**
	 * @author Kametani Yuki
	 * @since 2015/6/3
	 * customerType  	会員タイプ
	 * customerId    	会員ID
	 * familyName    	会員苗字
	 * givenName     	会員名前
	 * customerPass1 	パスワード
	 * customerPass2 	確認用パスワード
	 * mailaddress   	メールアドレス
	 * phone		 	電話番号
	 * postcode		 	郵便番号
	 * address		 	住所
	 * housenumber	 	番地
	 * CreditName	 	クレジット名義
	 * CreditNumber	 	クレジット番号
	 * Expiredate	 	有効期限
	 * expiredate1	 	有効期限(月)
	 * expiredate2	 	有効期限(年)
	 * expiredate3	 	有効期限(月と年を合わせたもの)
	 * Security		 	セキュリティコード
	 * DBcutomerType 	DB格納用会員タイプ
	 * DBFamilyName  	DB格納用会員苗字
	 * DBgivenName   	DB格納用会員名前
	 * sessionMap    	セッション
	 * errormsg 	 	月額会員用エラーメッセージ
	 * errormsg2 	 	一般会員用エラーメッセージ
	 * errorpass 	 	月額会員用パスワード入力ミス用エラーメッセージ
	 * errorpass2 	 	一般会員用パスワード入力ミス用エラーメッセージ
	 * result 	 	 	実行結果を返す
	 */
	public int customerType;
	public int customerId;
	public String familyName;
	public String givenName;
	public String customerPass1;
	public String customerPass2;
	public String phone;
	public String mailaddress;
	public int postcode;
	public String address;
	public String housenumber;
	public String CreditName;
	public String CreditNumber;
	private int Expiredate;
	public String expiredate1;
	public String expiredate2;
	private String expiredate3 = "0";
	public int Security;
	private int DBcustomerType;
	private String DBfamilyName;
	private String DBgivenName;
	public Map<String, Object> sessionMap;
	public String errormsg = null;
	public String errormsg2 = null;
	public String errorpass = null;
	public String errorpass2 = null;
	private String result = "error";

	InfoDAO dao = new InfoDAO();

	/**
	 * DBに登録済みの会員情報を編集し、resultを返すメソッド
	 * @author Kametani Yuki
	 * @since 2015/6/3
	 * @return result
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (customerPass1.equals(customerPass2)) {

			String expiredate3 = expiredate1 + expiredate2;

			if (!expiredate3.equals("nullnull")) {
				Expiredate = Integer.parseInt(expiredate3);
			}

			customerId = (int) sessionMap.get("customerId");

			UpdataDAO dao2 = new UpdataDAO();

			if (dao2.update(customerType, familyName, givenName, customerPass1,
					phone, mailaddress, postcode, address, housenumber,
					CreditName, CreditNumber, Expiredate, Security, customerId)) {

				dao.select(customerId);

				sessionMap.remove("customerType");
				sessionMap.remove("familyname");
				sessionMap.remove("givenname");
				sessionMap.remove("passpass");
				sessionMap.remove("mailaddress");
				sessionMap.remove("tellnumber");
				sessionMap.remove("postcode");
				sessionMap.remove("address");
				sessionMap.remove("houseNumber");

				DBcustomerType = dao.DBcustomerType;
				DBfamilyName = dao.DBfamilyName;
				DBgivenName = dao.DBgivenName;

				sessionMap.put("customerType", DBcustomerType);
				sessionMap.put("familyname", DBfamilyName);
				sessionMap.put("givenName", DBgivenName);

				result = "success";

			} else {
				if (customerType == 2) {
					errormsg2 = "*入力されたパスワードは他のユーザーにより使用中です";
				} else {
					errormsg = "*入力されたパスワードは他のユーザーにより使用中です";
				}
			}
		} else {
			if (customerType == 2) {
				errorpass2 = "*同じパスワードを入力してください";
			} else {
				errorpass = "*同じパスワードを入力してください";
			}
		}
		return result;
	}
	/**
	 * 有効期限(合計)取得メソッド
	 * @author Kametani Yuki
	 * @since 2015/6/3
	 * @return expiredate3
	 */
	public String getExpiredate3() {
		return expiredate3;
	}

	/**
	 * 有効期限(合計)格納メソッド
	 * @author Kametani Yuki
	 * @since 2015/6/3
	 * @param expiredate3
	 */
	public void setExpiredate3(String expiredate3) {
		this.expiredate3 = expiredate3;
	}
	/**
	 * セッション情報取得メソッド
	 * @author Kametani Yuki
	 * @since 2015/6/3
	 * @return sessionMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * セッション情報格納メソッド
	 * @author Kametani Yuki
	 * @since 2015/6/3
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
