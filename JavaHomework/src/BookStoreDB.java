
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database�� �����ϴ� Ŭ����
 * @author songsh
 *
 */
public class BookStoreDB {

	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	/**
	 * connection ����
	 */
	public void getConnection()
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String jdbcDriver = "jdbc:sqlserver://DBip�ּ�:��Ʈ��ȣ;databaseName=DB��;";
			//jdbc:sqlserver://DBip�ּ�:��Ʈ��ȣ;databaseName=DB��;
			String dbUser = "DB���̵�"; //DB���̵� 
			String dbPass = "DB��й�ȣ"; //DB��й�ȣ
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
	 * connection�� ����
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
	 * ������ �����Ͽ� ����� ResultSet���� ����
	 * @param sql ���� ��Ʈ��
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
	 * sample code�� �־ �׽�Ʈ�ϴ� �Լ�
	 * sql���� �����Ͽ� �׽�Ʈ�ϼ���.
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
