import java.sql.*;  
public class JdbcTest {

	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Ammi@147");  

			//here sonoo is database name, root is username and password 
 
			Statement stmt=con.createStatement();  

			ResultSet rs=stmt.executeQuery("select empId,empName from employee");
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();  
			while(rs.next()) { 
				for(int columnIndex = 1; columnIndex<=columnsNumber;columnIndex++){
					System.out.print(rs.getString(columnIndex)+"   ");
				}
				System.out.println();
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
			}  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
}
