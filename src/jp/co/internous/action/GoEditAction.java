package jp.co.internous.action;
import java.sql.SQLException;
import java.util.Map;

import jp.co.internous.dao.InfoDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * GoEditAction 顧客情報編集画面へ遷移する為のアクション
 * @author Saitoh Jumpei
 * @since 2015/6/3
 * @version 1.0
 */
public class GoEditAction extends ActionSupport implements SessionAware {
	/**
	 * @author Saitoh Jumpei
     * @since 2015/6/3 sessionMap セッション
	 */
	private Map<String, Object> sessionMap;
	public String result = "error";
	/**
	 * 実行メソッド
	 * @author Saitoh Jumpei
     * @since 2015/6/3
	 * @return success
	 */
	public int DBcustomerType;
	public int DBcustomerId;
	public String DBcustomerFamilyName=null;
	public String DBcustomerGivenName=null;
	public String DBpassword=null;
	public String DBphone=null;
	public String DBmailaddress=null;
	public int DBpostcode;
	public String DBaddress=null;
	public String DBhousenumber=null;
	public String DBcreditName;
	public String DBcreditNumber;
	public int DBexpireDate;
	public int DBsecurity;

	public String execute() {
		InfoDAO dao = new InfoDAO();
		/* セッションを入れる変数(箱)を用意 */
		int customerId = 0;
		/*ログインアクションで格納されたセッション情報(customaeridに入っている)を
		 * javaの変数customerIdにint型に変換し代入*/
		customerId=(int) sessionMap.get("customerId");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"+customerId);
		try {
			/*customerIdに代入されたint型の値を元にそれに該当するアカウント情報を検索し
			  各項目を引き出す */
			dao.select(customerId);
		/* 実際に各項目を引き出し 変数に代入を行う*/
			DBcustomerType = dao.DBcustomerType;
			DBcustomerId = dao.DBcustomerId;
			DBcustomerFamilyName = dao.DBfamilyName;
			DBcustomerGivenName = dao.DBgivenName;
			DBpassword = dao.DBpassword;
			DBphone = dao.DBphone;
			DBmailaddress = dao.DBmailaddress;
			DBpostcode = dao.DBpostcode;
			DBaddress = dao.DBaddress;
			DBhousenumber = dao.DBhousenumber;
			DBcreditName = dao.DBcreditName;
			DBcreditNumber = dao.DBcreditNumber;
			DBexpireDate = dao.DBexpireDate;

			System.out.println("IDIDIDIDIDID");
			System.out.println(dao.DBcustomerId);
			System.out.println(dao.DBfamilyName);
			System.out.println(dao.DBgivenName);
			System.out.println(dao.DBpostcode);

			sessionMap.put("customerType", dao.DBcustomerType);
			sessionMap.put("customerId", dao.DBcustomerId);
			sessionMap.put("familyName", DBcustomerFamilyName);
			sessionMap.put("givenName", DBcustomerGivenName);
			sessionMap.put("customerPass1", DBpassword);
			sessionMap.put("mailaddress", DBmailaddress);
			sessionMap.put("phone", DBphone);
			sessionMap.put("postcode", DBpostcode);
			sessionMap.put("address", DBaddress);
			sessionMap.put("housenumber", DBhousenumber);
			sessionMap.put("creditName", DBcreditName);
			sessionMap.put("creditNumber", DBcreditNumber);
			sessionMap.put("expiredate", DBexpireDate);


			result = "success";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result ;
	}
	/**
	 * セッションを取得するメソッド
	 * @author Saitoh Jumpei
     * @since 2015/6/3
	 * @return sessionMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッションを格納するメソッド
	 *@author Saitoh Jumpei
     * @since 2015/6/3
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}