package jp.co.internous.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
	
	/**
	 * GoCycleAction メイン画面へ遷移する為のアクション
	 * @author Miyazono Akira
	 * @since 2015/6/2
	 * @version 1.0
	 */

public class GoCycleAction extends ActionSupport implements SessionAware {
	
	/**
	 * @author Miyazon Akira
	 * @since 2015/6/3
	 * sessionMap セッション
	 */
	
	private Map<String, Object> sessionMap;

	/**
	 * 実行メソッド
	 * @author Miyazono Akira
	 * @since 2015/6/2
	 * @return success
	 */
	public String execute() {
		return "success";
	}
	
	/**
	 * セッションを取得するメソッド
	 * @author Miyazono Akira
	 * @since 2015/6/3
	 * @return sessionMap
	 */
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	/**
	 * セッションを格納するメソッド
	 * @author Miyazono Akira
	 * @since 2015/6/3
	 * @param sessionMap
	 */
	
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
}