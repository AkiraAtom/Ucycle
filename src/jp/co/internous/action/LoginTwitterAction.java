package jp.co.internous.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.internous.twitter.TwitterAccessToken;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginTwitterAction
 * Twitter認証画面からマイページ画面へ遷移する為のアクションクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{
	/**
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * serialVersionUID		シリアルバージョンUID
	 * session   セッション
	 * response  レスポンス
	 * request   リクエスト
	 * userData  ユーザー情報
	 * result    実行結果を返す
	 */
	private static final long serialVersionUID = -3972060531141707907L;
	public Map<String, Object> sessionMap;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String[] userData=new String[2];
    public int customerType = 3;
	/**
	 * 実行メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return SUCCESS 
	 * @throws Exception
	 * @see TwitterAccessToken
	 */
	public String execute() throws IOException{
		TwitterAccessToken twitter = new TwitterAccessToken();
		try {
		userData = twitter.loginOAuth(response, request);
		} catch (Exception e) {
			return ERROR;
		}
		sessionMap.put("customerType", customerType);
		sessionMap.put("familyname", userData[0]);
		sessionMap.put("custsomerId", userData[1]);
		return SUCCESS;
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
	/**
	 * セッション格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param sessionMap 
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
}
