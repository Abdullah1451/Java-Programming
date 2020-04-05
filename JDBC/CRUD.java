import java.util.Scanner;
import java.sql.*;

public class CRUD{
	public static String DB;

	public static String URL = "jdbc:mysql://localhost/";
	//public static String DB_URL = URL+DB;

	//Password and Username For database coonection
	static final String USER = "root";
	static final String PASS = "Ammi@147";

	Scanner sc = new Scanner(System.in); 
	public void CreateDataBase(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			//we are making connection (below line) to the mysql by giving username,password and DB URL
			Connection con=DriverManager.getConnection(URL,USER,PASS);  
 
			Statement stmt=con.createStatement();
			
			System.out.println("Enter Name Of The DataBase ");
			DB = sc.nextLine();

			String sql = "create database "; 
 			stmt.executeUpdate(sql+DB);
			
			System.out.println("done");  
			con.close();  
		}

		catch(Exception e){ 
			System.out.println(e);
		}  
	}

	public void CreateTable(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Enter Name Of The Existed DataBase ");
			DB = sc.nextLine();
			Connection con=DriverManager.getConnection(URL+DB,USER,PASS);
 
			Statement stmt=con.createStatement();

			System.out.println("Enter The MySQL Query For Making The New Table ");
			String sql = sc.nextLine(); 
 			stmt.executeUpdate(sql);
			
			System.out.println("done");  
			con.close();  
		}

		catch(Exception e){ 
			System.out.println(e);
		}  
	}

	public void Read(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  

			System.out.println("Enter Name Of The Existed DataBase ");
			DB = sc.nextLine();
			Connection con=DriverManager.getConnection(URL+DB,USER,PASS);

			Statement stmt=con.createStatement();  

			System.out.println("Enter The MySQL Query For Reading ");
			String sql = sc.nextLine();
			System.out.println();
			System.out.println();

			ResultSet rs=stmt.executeQuery(sql); 
 
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
  
			while(rs.next()) { 
				for(int columnIndex = 1; columnIndex<=columnsNumber;columnIndex++){
					System.out.print(rs.getString(columnIndex)+"   ");
				}
				System.out.println();
			}  
 
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}

	public void InsertUpdateDeleteValue(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  

			System.out.println("Enter Name Of The Existed DataBase ");
			DB = sc.nextLine();
			Connection con=DriverManager.getConnection(URL+DB,USER,PASS);  
 
			Statement stmt=con.createStatement();
			
			System.out.println("Enter MySQL Query To Insert Or To Update Or To Delete Values ");
			String sql = sc.nextLine();
 			stmt.executeUpdate(sql);

			
			System.out.println("done");  
			con.close();  
		}

		catch(Exception e){ 
			System.out.println(e);
		}  
	}

	public static void main(String args[]){
		CRUD obj = new CRUD();
		obj.CreateDataBase();
		obj.CreateTable();
		//obj.InsertUpdateDeleteValue();
		//obj.Read();
	}
}