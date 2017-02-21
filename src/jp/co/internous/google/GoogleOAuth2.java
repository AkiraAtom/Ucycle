package jp.co.internous.google;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import sun.net.InetAddressCachePolicy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * GoogleOAuth2
 * GoogleOAuth認証画面からログイン画面へ遷移する為のアクション
 * @author Akira Funakoshi
 * @since 2015/06/10
 * @version 1.0
 */
public class GoogleOAuth2 extends ActionSupport implements ServletRequestAware,SessionAware {
	/**
	 * @author Akira Funakoshi
	 * @since 2015/06/10
	 * PROTECTED_RESOURCE_URL リソースURL 
	 * EMPTY_TOKEN エンプティトークン
	 * request　リクエスト
	 * sessionMap　セッション
	 * customerType 会員タイプ
	 */
	private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
	private static final Token EMPTY_TOKEN = null;
	private HttpServletRequest request;
	private Map<String, Object> sessionMap;
	public int customerType = 3;
	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author Akira Funakoshi
	 * @since 2015/06/10
	 * @return SUCCESS 
	 * @throws Exception
	 * @throws IOException
	 */	
	public String execute() throws Exception {
		AccessToken();
		return SUCCESS;
	}
	public void AccessToken() throws IOException {
		String verifier1 = request.getParameter("code");
		Verifier verifier =new Verifier(verifier1);
		Token accessToken = new Token("ACCESS_TOKEN", "REFRESH_TOKEN");
		HttpSession session = request.getSession();
		OAuthService service = (OAuthService) session.getAttribute("SERVICE");
		accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, request);
		Response response = request.send();
		// JSON形式で送られてきたデータをmapに入れる
				Map<String,String> map = new LinkedHashMap<>();
				ObjectMapper mapper = new ObjectMapper();
				try {
					map = mapper.readValue(response.getBody(), new TypeReference<LinkedHashMap<String,String>>(){});
					System.out.println(map);
					System.out.println(map.get("id"));
					System.out.println(map.get("name"));
					sessionMap.put("familyname", map.get("name"));
					sessionMap.put("customerType",customerType);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	/**
	 * サーブレットレスポンス格納メソッド
	 * @author Akira Fuakoshi
	 * @since 2015/06/10
	 * @param response
	 */	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * サーブレットリクエスト格納メソッド
	 * @author Akira Fuakoshi
	 * @since 2015/06/10
	 * @param request
	 */	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
}