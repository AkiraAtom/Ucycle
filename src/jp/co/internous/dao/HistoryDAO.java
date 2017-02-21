package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import jp.co.internous.util.DBconnector;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HistoryDAO extends ActionSupport implements SessionAware{
	private String reservationDate;
	private String portID;
	private String cycleID;
	private String plan;
	private Map<String, Object> sessionMap;

    public boolean select(String password,String mailaddress) throws SQLException{
    	boolean res = false;
    	try {
			Connection con = DBconnector.getConnection();
			String sql = "SELECT * FROM customer where  password=? and mailaddress=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, mailaddress);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = true;
				sessionMap.put("portId", rs.getString(2));
				sessionMap.put("cycleId", rs.getString(3));
				sessionMap.put("plan", rs.getString(4));
				sessionMap.put("reservationDate", rs.getString(5));
				portID = rs.getString(2);
				cycleID = rs.getString(3);
				plan = rs.getString(4);
				reservationDate = rs.getString(5);
			}
			con.close();
    } catch (Exception e) {
		e.printStackTrace();

	}
	return false;
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

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}
