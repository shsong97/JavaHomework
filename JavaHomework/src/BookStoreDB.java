
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database를 관리하는 클래스
 * @author songsh
 *
 */
public class BookStoreDB {

	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	/**
	 * connection 열기
	 */
	public void getConnection()
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String jdbcDriver = "jdbc:sqlserver://DBip주소:포트번호;databaseName=DB명;";
			//jdbc:sqlserver://DBip주소:포트번호;databaseName=DB명;
			String dbUser = "DB아이디"; //DB아이디 
			String dbPass = "DB비밀번호"; //DB비밀번호
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); 
			System.out.println("Connection Open");
		} catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException"); 
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Connection Failed"); 
			e.printStackTrace();
		}
	}
	/**
	 * connection을 닫음
	 */
	public void closeConnection()
	{
		
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * 쿼리문 수행하여 결과를 ResultSet으로 받음
	 * @param sql 쿼리 스트링
	 * @return ResultSet
	 */
	public ResultSet executeQuery(String sql)
	{
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	/**
	 * sample code를 넣어서 테스트하는 함수
	 * sql문을 적당히 수정하여 테스트하세요.
	 */
	public void Test()
	{
		String sql="select * from user";
		ResultSet rs=executeQuery(sql);
		try {
			while(rs.next())
			{
				String username=rs.getString("username");
				System.out.println("User Name : "+username);
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
