import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Stuff {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			CreateTable();
			Post();
	}

	public static Connection GetConnection() throws Exception
	{
		try 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testschema?useSSL=false"
					+ "&useUnicode=true"
					+ "&useJDBCCompliantTimezoneShift=true"
					+ "&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "rootroot";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e) {System.out.println(e);}
		
		
		return null;
		
	}
	
	public static void CreateTable() throws Exception
	{
		try
		{
			Connection con = GetConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS "
					+ "playTable(id int NOT NULL AUTO_INCREMENT,first varchar(255), last varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Function has been completed");
		}
	}
	
	public static void Post() throws Exception
	{
		final String var1 = "Christopher";
		final String var2 = "Andrews";
		try
		{
			Connection con = GetConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO playTable (first, last) "
					+ "VALUES ('"+var1+"','"+var2+"')");
			posted.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("post completed");
		}
	}
}
