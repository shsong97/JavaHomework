import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BookStoreDB {

	Connection conn=null;
	public void getConnection()
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String jdbcDriver = "jdbc:sqlserver://DBip�ּ�:��Ʈ��ȣ;databaseName=DB��;";
			String dbUser = "DB���̵�";
			String dbPass = "DB��й�ȣ";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//��� ����� �Է� �߽��ϴ�. 
			System.out.println("���� ����");
			conn.close(); 
		} catch(Exception e){
			System.out.println("���� ����"); 
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
