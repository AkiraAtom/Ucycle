package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;
/**
 * ItemDAO ItemAllActionがDBにアクセスするためのDAOクラス
 * @author Mito Koutarou
 * @since 2015/6/08
 * @version 1.0
 */
	public class ReservationDAO {
		
/**
 * @author Mito Koutarou
 * @since 2015/6/08
 * @version 1.0
 * con  コネクションの値
 * customerId  顧客ID
 * portName  駐輪場名
 * cycleId  自転車ID
 * plan  利用プラン
 * due_date  返却予定日
 * status  在庫の有無
 * reservationDate  日付
 */

		Connection con = null;
		PreparedStatement ps2 = null;
		public int customerId;
		public int portName;
		public int cycleId;
		public int plan;
		public int due_date;
		public int status;
		public String reservationDate;
		
/**
 * DBに予約情報を格納するためのメソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @return true
 * @throws Excepion
 */
		
		public boolean insert(int customerId,String portName,int cycleId,int plan,String reservationDate) throws Exception {
			con = DBconnector.getConnection();

			try {
				String sql = "insert into reservation_info(customer_id,port_name,cycle_id,plan,reservation_date)values"+"(?,?,?,?,?)";
				ps2 = con.prepareStatement(sql);

			ps2.setInt(1,customerId);
			ps2.setString(2,portName);
			ps2.setInt(3,cycleId);
			ps2.setInt(4,plan);
			ps2.setString(5,reservationDate);


			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
			return true;
		}
		
/**
 * DBに予約情報を格納するためのメソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @return true
 * @throws Excepion
 */
		
		public boolean update(int cycleId,String portName,int reservationDate,int status) throws SQLException{
			  con=DBconnector.getConnection();
			  try{
			   String sql="update cycle set port_name=?,due_date=?,status==? where cycle_id=?";

			   ps2 = con.prepareStatement(sql);


			   ps2.setString(1, portName);
			   ps2.setInt(2, reservationDate);
			   ps2.setInt(3, status);
			   ps2.setInt(4, cycleId);

			   int rsCount = ps2.executeUpdate();
			   if(rsCount>0) {

			   }
			  }catch(Exception e){
			   e.printStackTrace();

			  }finally{
			   con.close();
			  }
			  return true;
			 }
		
		
/**
 * 返却予定日取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
		
	public int getDue_date() {
			return due_date;
		}
/**
 * 返却予定日格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public void setDue_date(int due_date) {
			this.due_date = due_date;
		}
/**
 * 顧客ID取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public int getCustomerId() {
		return customerId;
	}
/**
 * 顧客ID格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
/**
 * 駐輪場名取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public int getPortName() {
		return portName;
	}
/**
 * 駐輪場名格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
	 */
	
	
	public void setPortName(int portName) {
		this.portName = portName;
	}
/**
 * 自転車ID取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public int getCycleId() {
		return cycleId;
	}
/**
 * 自転車ID格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}
/**
 * 利用プラン取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public int getPlan() {
		return plan;
	}
/**
 * 利用プラン格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public void setPlan(int plan) {
		this.plan = plan;
	}
/**
 * 在庫状態取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public int getStatus() {
		return status;
	}
/**
 * 在庫状態格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public void setStatus(int status) {
		this.status = status;
	}
/**
 * 日付取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public String getReservationDate() {
		return reservationDate;
	}
/**
 * 日付取得格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/08
 * @param due_date
 */
	
	
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

}