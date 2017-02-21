package jp.co.internous.facebook;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import facebook4j.Facebook;

/**
 * TwitterRequestToken
 *  
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class LogoutServlet extends ActionSupport implements
		ServletResponseAware, ServletRequestAware {
	/**
	 * 実行メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return result 
	 * serialVersionUID
	 * HttpServletResponse response  サーバーからのレスポンス情報
	 * HttpServletRequest request    サーバーからのレスポンス情報
	 * sessionMAP					 セッションマップ
	 */

	private static final long serialVersionUID = 5357658337449255998L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> sessionMap;
	public String execute() throws Exception {
		doGet(request, response);
		sessionMap.clear();
		return SUCCESS;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facebook facebook = (Facebook) request.getSession().getAttribute(
				"facebook");
		String accessToken = "";
		try {
			accessToken = facebook.getOAuthAccessToken().getToken();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		request.getSession().invalidate();
		StringBuffer next = request.getRequestURL();
		int index = next.lastIndexOf("/");
		next.replace(index + 1, next.length(), "");
		response.sendRedirect("http://www.internousdev.com:8080/Ucycle/Main.jsp");
	}
	/**
	 * リクエスト格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param request  httpリクエスト
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * レスポンス格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param request httpリクエスト
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * セッション取得メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param sessionMap  セッションに保存するMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッション格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param sessionMap　セッションに保存するMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
