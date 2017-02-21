package jp.co.internous.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * DBconnector DBから情報を取得するメソッド
 * @author Kobori Yuki
 * @since 2015/05/18
 * @param driverName  ドライバー名
 * @param url         url名
 * @param user        ユーザー名
 * @param pass        パスワード
 * @throws ClassNotFoundException
 * @throws SQLException
 * @return con
 */
public class DBconnector {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/ucycle";
    private static String user = "root";
    private static String pass = "mysql";
    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}