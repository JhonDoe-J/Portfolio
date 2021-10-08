package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements AutoCloseable{
	private Connection con;

	public UserDAO() throws ClassNotFoundException, SQLException{
		 Class.forName("com.mysql.cj.jdbc.Driver");
	        // データベースに接続する ----
	        con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/db1?characterEncoding=UTF-8&serverTimezone=JST",
	                "root", "Mysql@2019");
	    }

	@Override
	public void close() throws Exception {
		if(con != null)
			con.close();
			con = null;
	}

	public void createNewAccount(User user) throws SQLException {
		String sql = "insert into useraccount(yuuzaamei,pasuwaado,createddate) " + " values(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,user.getYuuzaamei() );
		stmt.setString(2,user.getPasuwaado());
		stmt.setString(3,user.getCreateddate());
		stmt.executeUpdate();
        stmt.close();
	}

	public User accountAuthentication(User user) throws SQLException{
		User userresult = null;
		//String sql = "select yuuzaamei,pasuwaado from useraccount where yuuzaamei = '長澤' and pasuwaado = 'テスト'";
		String sql = "select yuuzaamei,pasuwaado from useraccount "
				+ "where yuuzaamei = ? and pasuwaado = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getYuuzaamei());
		stmt.setString(2, user.getPasuwaado());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
		  userresult = new User(rs.getString("yuuzaamei"),rs.getString("pasuwaado"));

		}
        stmt.close();
        rs.close();
        return userresult;
	}

}

/*
 *  User userresult = new User(rs.getString("yuuzaamei"),rs.getString("pasuwaado"));
		  if(userresult != null) {
			  result = true;
 *
 * */
