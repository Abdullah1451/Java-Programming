import java.sql.*;  
public class Create{  
	public static String DB = "Java";
	public static String LOC = "jdbc:mysql://localhost/";
	LOC +=DB;
	public static void main(String args[]){  
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  

			Connection con=DriverManager.getConnection(LOC,"root","Ammi@147");  

 			//here sonoo is database name, root is username and password 
 
			Statement stmt=con.createStatement(); 
			String sql = "create table Version3(id int(10))"; 
 			stmt.executeUpdate(sql);
			
			System.out.println("done");  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
} 