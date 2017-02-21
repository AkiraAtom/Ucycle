package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;

/**
 * WithdrawCompleteDAO 
 * 顧客情報をDBから取得するクラス
 * @author Nogami Yuko
 * @since 2015/06/10
 * @version 1.0
 */
public class WithdrawCompleteDAO extends ActionSupport {
	int i;
	Connection con = null;
	PreparedStatement ps = null;
	boolean resultDAO = false;
	/**
	 * DBに格納されている顧客情報を参照し、削除するメソッド
	 * @author Nogami Yuko
	 * @since 2015/06/09
	 * @param mailaddress
	 * @param password
	 * @return resultDAO
	 * @throws SQLException
	 * @see DBconnector
	 */
	public boolean select(String mailaddress, String password)
			throws SQLException {
		con = DBconnector.getConnection();
		try {
			String sql = "SELECT * FROM customer where  mailaddress =? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mailaddress);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			System.out.println("DAO-" + rs);
			if (rs.next()) {
				resultDAO = true;
				String sql2 = "delete FROM customer where  mailaddress =? and password=?";
				ps = con.prepareStatement(sql2);
				ps.setString(1, mailaddress);
				ps.setString(2, password);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return resultDAO;
	}
}
