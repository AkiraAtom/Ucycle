package jp.co.internous.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.dto.InsertDTO;
import jp.co.internous.util.DBconnector;

import com.opensymphony.xwork2.ActionSupport;


	public class InsertDAO extends ActionSupport{

		InsertDTO dto = new InsertDTO();
		Connection con = null;
		PreparedStatement ps2 = null;
		private boolean result=false;




		public boolean insert(int customertype, String familyname, String lastname, String customerPass1,String phone,String emailadd, int postcode,
				String address,String housenumber,String creditName ,String creditNumber,int expire,int securitycode
				) throws SQLException{
			con=DBconnector.getConnection();
			try {
				String sql="insert into customer(customer_type,familyname,lastname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expire,securityCode)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps2=con.prepareStatement(sql);
				ps2.setInt(1, customertype);
				ps2.setString(2, familyname);
				ps2.setString(3, lastname);
				ps2.setString(4, customerPass1);
				ps2.setString(5, phone);
				ps2.setString(6, emailadd);
				ps2.setInt(7, postcode);
				ps2.setString(8, address);
				ps2.setString(9, housenumber);
				ps2.setString(10,creditName );
				ps2.setString(11,creditNumber );
				ps2.setInt(12,expire );
				ps2.setInt(13,securitycode );







				int rsCount = ps2.executeUpdate();
				if(rsCount>0) {
					result=true;
				}

			}catch (Exception e){
				e.printStackTrace();
			}finally{
				con.close();
			}
			return result;
		}

	}





