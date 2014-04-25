import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BookStoreDB {

	Connection conn=null;
	public void getConnection()
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String jdbcDriver = "jdbc:sqlserver://DBip주소:포트번호;databaseName=DB명;";
			String dbUser = "DB아이디";
			String dbPass = "DB비밀번호";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//비번 제대로 입력 했습니다. 
			System.out.println("연결 성공");
			conn.close(); 
		} catch(Exception e){
			System.out.println("연결 실패"); 
			e.printStackTrace();
		}
	}
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
}
