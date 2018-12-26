package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
	public static Connection getConnection()
	{
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		String url = "jdbc:sqlserver://localhost:1433; DataBaseName = JD";
		String user = "sa" ;
		String password = "123";
		Connection con = null ;
		try {
			
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con ;
		
	}
	
	/**
	 * πÿ±’¡¨Ω”
	 */
	public static void free(ResultSet rs, Statement sta , Connection con)
	{
		try {
			if(null != rs)
			{
				rs.close();
				rs = null ;
			}
			
			if(null != sta)
			{
				sta.close();
				sta = null ;
			}
			
			if(null != con)
			{
				con.close();
				con = null ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
