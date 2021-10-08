package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//DataAccessObject：Beansを経由して受け取った値でDB操作を実行するクラス
public class ThreadDAO implements AutoCloseable{
	private Connection con;

	public ThreadDAO() throws ClassNotFoundException, SQLException{
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

	//新規スレッド作成メソッド
	public void createNewThread(Thread thread) throws SQLException {
		String sql = "insert into thread(threadtitle,username,texts,posteddate) "+
					" values(?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,thread.getThreadtitle() );
		stmt.setString(2,thread.getUsername());
		stmt.setString(3,thread.getTexts());
		stmt.setString(4,thread.getPosteddate());
		stmt.executeUpdate();
        stmt.close();
	}

	//スレッド内容表示メソッド
	public List<Thread> getThread(String threadtitle) throws SQLException{
		List<Thread> threads = new ArrayList<>();
		String sql = "select ifnull(nullif(username,''),'名無し') as username,texts,posteddate from thread where threadtitle = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, threadtitle);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			threads.add(new Thread(rs.getString("username"),rs.getString("texts"),rs.getString("posteddate")));
		}
        stmt.close();
        rs.close();
        return threads;
	}

	//スレッド一覧表示メソッド
	public List<String> getAllThreads() throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "select threadtitle from thread";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			list.add(rs.getString("threadtitle"));

		}
		//スレッド名の重複削除
		List<String> allthreadtitles = list.stream().distinct().collect(Collectors.toList());
		stmt.close();
        rs.close();
		return allthreadtitles;
	}

}
