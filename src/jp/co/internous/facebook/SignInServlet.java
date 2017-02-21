package jp.co.internous.facebook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

/**
 * SignInServlet 
 * ログイン画面からFacebook認証画面へと遷移する為のアクションクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class SignInServlet extends ActionSupport implements ServletResponseAware,ServletRequestAware  {
	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return SUCCESS
	 * serialVersionUID		シリアルバージョンUID
	 * HttpServletRequest request 	サーバーからのリクエスト情報
	 * HttpServletResponse response	サーバーからのレスポンス情報
	 */
	private static final long serialVersionUID = -7453606094644144082L;
	private HttpServletRequest request;
	private HttpServletResponse response;
    public String execute() throws Exception {
    	doGet(request, response);
		return SUCCESS;
	}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        facebook.setOAuthAppId("1601580923422755", "3fdd5c90c8bfa9842d8490ca5e3e5b10");
        String accessTokenString = "1601580923422755|5sAW8rT0T-8_yjtAid-XvOFWTWU";
        AccessToken at = new AccessToken(accessTokenString);
        facebook.setOAuthAccessToken(at);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/CallbackServlet");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
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
	 * レスポンス格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param response 
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
}
