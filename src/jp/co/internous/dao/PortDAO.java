package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.dto.PortDTO;
import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;
/**
 * PortDAO
 * 駐輪場の在庫情報を取得するためのDAOクラス
 * @author Tanaka Astushi
 * @since 2015/6/10
 * @version 1.0
 */
public class PortDAO extends ActionSupport {
	PortDTO dto = new PortDTO();
	Connection con = null;
	PreparedStatement ps = null;
	private int result = 0;
	/**
	 * @author Tanaka Astushi
	 * @since 2015/6/10
	 * port_name 駐輪場名
	 * DBcount カウント
	 */
	public String port_name = null;
	public int DBcount;
	/**
	 * DBに格納されている駐輪場の在庫情報を参照するためのメソッド
	 * @author Tanaka Astushi
	 * @since 2015/6/10
	 * @param port_name
	 * @return result
	 * @throws SQLException
	 */
	public int select(String port_name) throws SQLException {
		con = DBconnector.getConnection();
		try {
			String sql = "select count(*) from cycle where port_name=? and status=1";
			ps = con.prepareStatement(sql);
			ps.setString(1, port_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto.setCount(rs.getInt(1));
				DBcount = dto.getCount();
				result = DBcount;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
