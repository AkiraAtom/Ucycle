package jp.co.internous.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * GoPortAction ご利用履歴画面へ遷移する為のアクション
 * @author Kametani Yuki
 * @since 2015/6/2
 * @version 1.0
 */
public class GoPortAction extends ActionSupport implements SessionAware {
	/**
	 * @author Kametani Yuki
	 * @since 2015/6/2 sessionMap セッション
	 */
	private Map<String, Object> sessionMap;
	/**
	 * 実行メソッド
	 * @author Kametani Yuki
	 * @since 2015/6/2
	 * @return success
	 */
	public String execute() {
		return "success";
	}
	/**
	 * セッションを取得するメソッド
	 * @author Kametani Yuki
	 * @since 2015/6/2
	 * @return sessionMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッションを格納するメソッド
	 * @author Kametani Yuki
	 * @since 2015/6/2
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}