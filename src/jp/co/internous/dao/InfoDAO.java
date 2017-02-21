package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.dto.InfoDTO;
import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;
/**
 * InfoDAO
 * 顧客情報を取得するためのDAOクラス
 * @author Okumura Reo
 * @since 2015/6/3
 * @version 1.0
 */
public class InfoDAO extends ActionSupport {
	public static final int DBexpiredate = 0;
	Connection con = null;
	PreparedStatement ps = null;
	private boolean result = false;
	/**
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * DBcustomerType 会員タイプ
	 * DBfamilyName 顧客苗字
	 * DBgivenName 顧客名前
	 * DBpassword パスワード
	 * DBphone 電話番号
	 * DBmailaddress メールアドレス
	 * DBpostcode 郵便番号
	 * DBaddress 住所
	 * DBhousenumber　番地以降住所
	 * DBcreditName クレジットカード名義
	 * DBcreditNumber　クレジットカード番号
	 * DBexipireDate クレジットカード有効期限
	 * DBsecurity クレジットカードセキュリティコード
	 */
	public int DBcustomerType;
	public int DBcustomerId;
	public String DBfamilyName = null;
	public String DBgivenName = null;
	public String DBpassword = null;
	public String DBphone = null;
	public String DBmailaddress = null;
	public int DBpostcode;
	public String DBaddress = null;
	public String DBhousenumber = null;
	public String DBcreditName;
	public String DBcreditNumber;
	public int DBexpireDate;
	public int DBsecurity;
	/**
	 * DBに格納されている顧客情報を参照するためのメソッド
	 * @author Okumura Reo
	 * @since 2015/6/3
	 * @param customerId
	 * @return result
	 * @throws SQLException
	 */
	public boolean select(int customerId) throws SQLException {
		con = DBconnector.getConnection();
		try {
			String sql = "select * from customer where customer_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
				InfoDTO dto = new InfoDTO();
				dto.setCustomerType(rs.getInt(1));
				DBcustomerType = dto.getCustomerType();
				dto.setCustomerId(rs.getInt(2));
				DBcustomerId = dto.getCustomerId();
				dto.setFamilyName(rs.getString(3));
				DBfamilyName = dto.getFamilyName();
				dto.setGivenName(rs.getString(4));
				DBgivenName = dto.getGivenName();
				dto.setPassword(rs.getString(5));
				DBpassword = dto.getPassword();
				dto.setPhone(rs.getString(6));
				DBphone = dto.getPhone();
				dto.setMailaddress(rs.getString(7));
				DBmailaddress = dto.getMailaddress();
				dto.setPostcode(rs.getInt(8));
				DBpostcode = dto.getPostcode();
				dto.setAddress(rs.getString(9));
				DBaddress = dto.getAddress();
				dto.setHousenumber(rs.getString(10));
				DBhousenumber = dto.getHousenumber();
				dto.setCreditName(rs.getString(11));
				DBcreditName = dto.getCreditName();
				dto.setCreditNumber(rs.getString(12));
				DBcreditNumber = dto.getCreditNumber();
				dto.setExpireDate(rs.getInt(13));
				DBexpireDate = dto.getExpireDate();
				dto.setSecurity(rs.getInt(14));
				DBsecurity = dto.getSecurity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}