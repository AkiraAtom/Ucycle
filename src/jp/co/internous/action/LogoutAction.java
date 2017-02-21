package jp.co.internous.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.internous.facebook.LogoutServlet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport implements SessionAware {

	private Map<String, Object> sessionMap;
	LogoutServlet fblogout = new LogoutServlet();
	private HttpServletRequest request;
   	private HttpServletResponse response;

	public String execute() {

		String result = "error";
		try {

			sessionMap.clear();

			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}


	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getIP() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String IP = request.getRemoteAddr();
		return IP;
	}
}