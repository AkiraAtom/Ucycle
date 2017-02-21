package jp.co.internous.action;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Map;

import jp.co.internous.dao.HistoryDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * GoHistoryAction ご利用履歴画面へ遷移する為のアクション
 * @author Saitoh Jumpei
 * @since 2015/6/3
 * @version 1.0
 */
public class GoHistoryAction extends ActionSupport implements SessionAware {
	/**
	 * @author Sakai Shinya
	 * @since 2015/06/05
	 * useTimes 利用回数
	 * fee 料金
	 * totalFee 合計金額
	 */
	private String password;
	private String mailaddress;
	private String reservationDate;
	private String portID;
	private String cycleID;
	private String plan;
	String result = "error";

	private Map<String, Object> sessionMap;
	/**
	 * 実行メソッド
	  *@author Saitoh Jumpei
     * @since 2015/6/3
	 * @return success
	 */

	public String execute()throws SQLException, SocketException {
		password = (String) sessionMap.get("passpass");
		mailaddress =(String) sessionMap.get("mailaddress");

		HistoryDAO dao = new HistoryDAO();
		boolean res =  dao.select(password,mailaddress);

		if(res){
			setReservationDate(dao.getReservationDate());
			setPortID(dao.getPortID());
			setCycleID(dao.getCycleID());
			setPlan(dao.getPlan());
			result = SUCCESS;
		}else{
			result = ERROR;
		}

		return result;
		/**
		 * DAOメソッド
		 *@author Sakai Shinya
	     * @since 2015/6/5 sessionMap セッション
		 */
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * @return reservationDate
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * @param reservationDate セットする reservationDate
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * @return portID
	 */
	public String getPortID() {
		return portID;
	}

	/**
	 * @param portID セットする portID
	 */
	public void setPortID(String portID) {
		this.portID = portID;
	}

	/**
	 * @return cycleID
	 */
	public String getCycleID() {
		return cycleID;
	}

	/**
	 * @param cycleID セットする cycleID
	 */
	public void setCycleID(String cycleID) {
		this.cycleID = cycleID;
	}

	/**
	 * @return plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * @param plan セットする plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
}