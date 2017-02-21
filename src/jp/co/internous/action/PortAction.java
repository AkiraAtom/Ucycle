package jp.co.internous.action;

import java.net.SocketException;
import java.sql.SQLException;
import java.util.Map;

import jp.co.internous.dao.PortDAO;
import jp.co.internous.dto.PortDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * PortAction 
 * 駐輪場選択画面から顧客の退会処理をする為のアクション
 * @author Tanaka Astushi
 * @since 2015/06/10
 * @version 1.0
 */
public class PortAction extends ActionSupport implements SessionAware {
	/**
	 * @author Tanaka Astushi
	 * @since 2015/06/10 
	 * shopAddress 店舗住所
	 * DBstatus 在庫状況
	 * DBport_name 駐輪場名
	 * sessionMap セッション
	 */
	public String result = "error";
	public String shopAddress;
	public String port_time;
	public int status;
	public int DBstatus;
	public String DBport_name;
	public Map<String, Object> sessionMap;
	PortDAO dao = new PortDAO();
	PortDTO dto = new PortDTO();
	/**
	 * 入力された値を照合した後にセッション引継ぎ、resultを返すメソッド
	 * @author Tanaka Astushi
	 * @since 2015/06/10
	 * @version 1.0
	 */
	public String execute() throws SQLException, SocketException {
		if (dao.select(shopAddress) > 0) {
			result = "success";
			sessionMap.put("port_time", port_time);
			sessionMap.put("port_name", shopAddress);
		}
		return result;
	}
	/**
	 * 在庫状況取得メソッド
	 * @author Tanaka Astushi
	 * @since 2015/06/10
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 在庫状況格納メソッド
	 * @author Tanaka Astushi
	 * @since 2015/06/10
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * セッション取得メソッド
	 * @author Tanaka Astushi
	 * @since 2015/06/10
	 * @return sessionMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッション格納メソッド
	 * @author Tanaka Astushi
	 * @since 2015/06/10
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
