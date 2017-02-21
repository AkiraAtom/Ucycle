package jp.co.internous.action;

import java.net.SocketException;
import java.sql.SQLException;
import java.util.Map;
import jp.co.internous.dao.WithdrawCompleteDAO;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * WithdrawCompleteAction 
 * 退会画面から顧客の退会処理をする為のアクション
 * @author Nogami Yuko
 * @since 2015/06/10
 * @version 1.0
 */
public class WithdrawCompleteAction extends ActionSupport implements
		SessionAware {
	/**
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * result 結果 
	 * mailaddress メールアドレス 
	 * password パスワード 
	 * errormsg エラーメッセージ
	 * sessionMap セッション
	 */
	public String result = "error";
	public String password;
	public String mailaddress;
	public String errormsg = null;
	private Map<String, Object> sessionMap;
	/**
	 * 入力された値を照合した後にセッションをクリアし、resultを返すメソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @version 1.0
	 */
	public String execute() throws SQLException, SocketException {
		WithdrawCompleteDAO dao = new WithdrawCompleteDAO();
		boolean ret = dao.select(mailaddress, password);
		if (ret) {
			sessionMap.clear();
			result = "success";
		} else {
			errormsg = "パスワードが違います";
		}
		return result;
	}
	/**
	 * パスワード取得メソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * パスワード格納メソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * メールアドレス取得メソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @return mailaddress
	 */
	public String getMailaddress() {
		return mailaddress;
	}
	/**
	 * メールアドレス格納メソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @param mailaddress
	 */
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	/**
	 * セッション取得メソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @return sessionMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッション格納メソッド
	 * @author Nogami Yuko
	 * @since 2015/06/10
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
