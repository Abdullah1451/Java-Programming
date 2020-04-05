import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UploadingFile{
	public static String URL = "jdbc:mysql://localhost:3306/family";
	static final String USER = "root";
	static final String PASS = "Ammi@147";
	
	static String filePath = "C:\\Users\\Azmi\\Downloads\\Java-Polymorphism.html";


	//Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  

			Connection con = DriverManager.getConnection(URL,USER,PASS);

			String sql = "insert into htmlimage(contentname,content) values(?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);  
			stmt.setString(1,"Java-Polymorphism");
			//stmt.setString(2,".pdf");
	
			InputStream inputStream = new FileInputStream(new File(filePath));
 						//System.out.println(inputStream);
            stmt.setBlob(2, inputStream);

			int row = stmt.executeUpdate();
			if (row > 0) {

                		System.out.println("A contact was inserted with photo image.");
            		}

			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
		
}

