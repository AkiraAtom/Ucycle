package jp.co.internous.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.dto.LoginDTO;
import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;


/**
 * LoginDAO LoginActionがDBに接続するためのDAOクラス
 * @author Miyazono Akira
 * @since 2015/5/18
 * @version 1.0
 */
public class LoginDAO extends ActionSupport {

/**
 *@author Miyazono Akira
 * @since 2015/05/18
 * @param DBcustomerType 会員タイプ
 * @param DBcustomerId  会員ID
 * @param DBcustomerName  会員名
 * @param DBmailaddress  メールアドレス
 * @param DBpostcode  郵便番号
 * @param DBaddress  住所
 * @param DBtellnumber  電話番号
 * @param DBcustomerPass  パスワード
 */
	public int DBcustomerType=0;
	public int DBcustomerId=0;
	public String DBfamilyname=null;

	public String DBmailaddress=null;
	public String DBpassword=null;

	private boolean resultDAO = false;
/**
 * 入力された情報とDBcustomer_infoにある情報を照合するメソッド
 * @author Miyazono Akira
 * @since 2015/5/18
 * @param customerPass  会員ID
 * @param mailaddress  メールアドレス
 * @return resultDAO  DAOの結果を返す
 * @throws SQLException
 * @see DBconnector LoginDTO
 */

	public boolean select(String password,String mailaddress) throws SQLException{



		try {
			Connection con = DBconnector.getConnection();
				String sql = "SELECT * FROM customer where  password=? and mailaddress=?";

				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, password);
				ps.setString(2, mailaddress);


				ResultSet rs = ps.executeQuery();

				while(rs.next()){

					resultDAO = true;

					LoginDTO dto=new LoginDTO();

					dto.setCustomerType(rs.getInt(1));
					DBcustomerType=dto.getCustomerType();

					dto.setCustomerId(rs.getInt(2));
					DBcustomerId=dto.getCustomerId();

					dto.setFamilyname(rs.getString(3));
					DBfamilyname=dto.getFamilyname();

					dto.setPassword(rs.getString(5));
					DBpassword=dto.getPassword();

					dto.setMailaddress(rs.getString(7));
					DBmailaddress=dto.getMailaddress();

					con.close();
				}
		} catch (Exception e) {
			e.printStackTrace();

		}finally{
			System.out.println("finally");
		}
		System.out.println("resultDAO"+resultDAO);
		return resultDAO;
	}
public int getDBcustomerType() {
	return DBcustomerType;
}

public int getDBcustomerId() {
	return DBcustomerId;
}
public String getDBfamilyname() {
	return DBfamilyname;
}
public String getDBMailaddress() {
	return DBmailaddress;
}
public String getDBpassword() {
	return DBpassword;
}
}
