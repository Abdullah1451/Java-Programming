import java.sql.*;

public class Connecting {
	static String url = "jdbc:mysql://localhost/family";
	static String username  = "root";
	static String password = "Ammi@147";

	public static void main(String[] args){
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");

			Statement obj = con.createStatement();
			String query = "create table login (id int(4) auto_increment not null primary key,username varchar(255) not null,password varchar(255) not null)";
			obj.executeUpdate(query);
			
			con.close();
			
		}
		catch(Exception e )
		{
			System.out.println(e);
			
		}
			
	}

}
