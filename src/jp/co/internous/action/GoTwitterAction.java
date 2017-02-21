package jp.co.internous.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.internous.twitter.TwitterRequestToken;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import twitter4j.TwitterException;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoTwitterAction
 * ログイン画面からTwitter認証画面へ遷移する為のアクションクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class GoTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	/**
	 * 実行メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return result 
	 * serialVersionUID		シリアルバージョンUID
	 * sessionMAP					 セッションマップ
	 * HttpServletResponse response  サーバーからのレスポンス情報
	 * HttpServletRequest request    サーバーからのリクエスト情報
	 */
	private String result="success";
	private static final long serialVersionUID = 3491867450777971874L;
	public Map<String, Object> sessionMap;
	private HttpServletResponse response;
	private HttpServletRequest request;
	/**
	 * 実行メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return result 
	 */
	public String execute(){
		TwitterRequestToken a = new TwitterRequestToken();
		try {
			result=a.loginOAuth(response,request);
		} catch (TwitterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}
	/**
	 * レスポンス格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param response
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * リクエスト格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param request
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}
