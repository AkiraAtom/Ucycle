package jp.co.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * CycleAction クレジット情報入力画面または予約確認画面に遷移する為のアクション
 * @author Osumi Haruka
 * @since 2015/06/08
 * @version 1.0
 */
public class CycleAction extends ActionSupport implements SessionAware {
	/**
	 * @author Osumi Haruka
	 * @since 2015/06/08 sessionMap セッション plan 利用時間プラン customer_type 会員タイプ
	 */
	private Map<String, Object> sessionMap;
	private String plan;
	private int customer_type;
	 /**
	  *  実行メソッド
	 * @author Osumi Haruka
	 * @since 2015/06/08
	 */
	public String execute() {
		customer_type = (int) sessionMap.get("customerType");
		if (customer_type == 1) {
			sessionMap.put("plan", plan);
			return "reservation";
		} else {
			sessionMap.put("plan", plan);
			return "success";
		}
	}
	/**
	 * セッション取得メソッド
	 * @author Osumi Haruka
	 * @since 2015/06/08
	 * @return session
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッション登録メソッド
	 * @author Osumi Haruka
	 * @since 2015/06/08
	 * @param session
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}