package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;

/**
 * UpdataDAO
 * UpdataActionがDBにアクセスするためのDAOクラス
 * @author Kametani Yuki
 * @since 2015/6/2
 * @version 1.0
 */
public class UpdataDAO extends ActionSupport {
	/**
	 * update DBconnectorにアクセスして顧客情報を格納するためのメソッド
	 * @author Kametani Yuki
	 * @since 2015/6/2
	 * customerType		 会員タイプ
	 * customerId		 会員ID
	 * familyName 		 会員苗字
	 * givenName 		 会員名前
	 * customerPass1 	 パスワード
	 * customerPass2  	 確認用パスワード
	 * mailaddress 	 	 メールアドレス
	 * phone 			 電話番号
	 * postcode 		 郵便番号
	 * address 			 住所
	 * housenumber 		 番地
	 * CreditName 		 クレジット名義
	 * CreditNumber 	 クレジット番号
	 * Expiredate		 有効期限
	 * Security 		 セキュリティコード
	 * @return result 	 例外処理に入らなければレスポンスを返す
	 * @throws SQLException
	 * @throws Exception
	 * @see DBconnector
	 */
	Connection con = null;
	PreparedStatement ps2 = null;
	boolean result = false;

	public int DBcustomerType;
	public int DBcustomerId;
	public String DBfamilyName;
	public String DBgivenName;
	public String DBcustomerPass;
	public String DBphone;
	public String DBmailAddress;
	public int DBpostCode;
	public String DBaddress;
	public String DBhouseNumber;
	public String DBCreditName;
	public String DBCreditNumber;
	public int DBexpireDate;
	public int DBsecurity;

	public boolean update(int customerType, String familyName,
			String givenName, String customerPass1, String phone,
			String mailaddress, int postcode, String address,
			String housenumber, String CreditName, String CreditNumber,
			int Expiredate, int Security, int customerId) throws SQLException {

		con = DBconnector.getConnection();

		try {
			String sql = "update customer set customer_type=?,familyname=?,givenname=?,password=?,phone=?,mailaddress=?,postcode=?,address=?,housenumber=?,credit_name=?,credit_number=?,expiredate=?,security_code=? where customer_id=?";
			ps2 = con.prepareStatement(sql);

			ps2.setInt(1, customerType);
			ps2.setString(2, familyName);
			ps2.setString(3, givenName);
			ps2.setString(4, customerPass1);
			ps2.setString(5, phone);
			ps2.setString(6, mailaddress);
			ps2.setInt(7, postcode);
			ps2.setString(8, address);
			ps2.setString(9, housenumber);
			ps2.setString(10, CreditName);
			ps2.setString(11, CreditNumber);
			ps2.setInt(12, Expiredate);
			ps2.setInt(13, Security);
			ps2.setInt(14, customerId);

			int rsCount = ps2.executeUpdate();
			if (rsCount > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}