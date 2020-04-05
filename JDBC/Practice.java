import java.sql.*;
import java.util.Scanner;

class Connect {
	//public static String URL = "jdbc:mysql://localhost/pythondb1";
	public static String URL = "jdbc:mysql://localhost/youtube";
	static final String USER = "root";
	static final String PASS = "Ammi@147";
	
	Scanner sc = new Scanner(System.in);
	
	public void Read(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  

			Connection con=(Connection) DriverManager.getConnection(URL,USER,PASS);

			Statement stmt=con.createStatement();  

			//String sql = "select * from image";
			String sql = "select videoname,thumbnailpath from videos";
			
			ResultSet rs=stmt.executeQuery(sql); 
 
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			while(rs.next()) { 
				for(int columnIndex = 1; columnIndex<=columnsNumber;columnIndex++){
					System.out.println(rs.getString(columnIndex)+"  ");
					/*if(columnIndex==1)
						System.out.print(rs.getString(columnIndex)+"  ");
					else
						System.out.print(rs.getBlob(columnIndex)+"  ");*/
				}
				System.out.println();
			}  
 
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
		
	public static void main(String a[]){
		Connect obj = new Connect();
		obj.Read();
	}
}

