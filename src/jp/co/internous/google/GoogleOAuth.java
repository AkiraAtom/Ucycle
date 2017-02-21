package jp.co.internous.google;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.internous.action.Google2Api;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import twitter4j.TwitterException;

import com.opensymphony.xwork2.ActionSupport;
/**
 * GoogleOAuth
 * ログイン画面からGoogleOAuth認証画面へ遷移する為のアクション
 * @author Akira Funakoshi
 * @since 2015/06/10
 * @version 1.0
 */
public class GoogleOAuth extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	/**
	 * @author Akira Funakoshi
	 * @since 2015/06/10
	 * NETWORK_NAME ネットワークネーム 
	 * PROTECTED_RESOURCE_URL リソースURL 
	 * SCOPE スコープ
	 * EMPTY_TOKEN エンプティトークン
	 * response レスポンス
	 * request　リクエスト
	 */
		private static final String NETWORK_NAME = "Google";
	    private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
	    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.profile";
	    private static final Token EMPTY_TOKEN = null;
		private HttpServletResponse response;
		private HttpServletRequest request;
	/**
	 * 認証用トークン取得メソッド
	 * @author Akira Funakoshi
	 * @since 2015/06/10
	 * @return SUCCESS 
	 * @throws Exception
	 * @throws IOException
	 */
	public String execute() throws Exception {
		RequestToken();
		return SUCCESS;
	}
	public void RequestToken() throws IOException{
        String apiKey = "1044520592950-gphr9bsdem5pm2m3edjk1ke7e5ths707.apps.googleusercontent.com";
        String apiSecret = "1i91k1XdKEhU-hPBAyQG_ABO";
        String callbackUrl = "http://www.internousdev.com:8080/Ucycle/GoogleOAuth2.action";
        OAuthService service = new ServiceBuilder()
        						.provider(Google2Api.class)
        						.apiKey(apiKey)
        						.apiSecret(apiSecret)
        						.callback(callbackUrl)
        						.scope(SCOPE)
        						.build();
        System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
        System.out.println();
        Token accessToken = new Token("ACCESS_TOKEN", "REFRESH_TOKEN");
            System.out.println("Fetching the Authorization URL...");
            String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
            System.out.println("Got the Authorization URL!");
            System.out.println("Now go and authorize Scribe here:");
            System.out.println(authorizationUrl);
            System.out.println("And paste the authorization code here");
            HttpSession session = request.getSession();
            session.setAttribute("SERVICE", service);
            System.out.println();
            response.sendRedirect(authorizationUrl);
	}
	/**
	 * サーブレットレスポンス格納メソッド
	 * @author Akira Fuakoshi
	 * @since 2015/06/10
	 * @param response
	 */	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	/**
	 * サーブレットリクエスト格納メソッド
	 * @author Akira Fuakoshi
	 * @since 2015/06/10
	 * @param request
	 */	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}