import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Testing{
	
	static String filePath = "D:\\Abdullah Working\\Java\\JDBC\\WebTest.png";
	//Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]){  
			int length = filePath.length();
			System.out.println(length);

			String str = filePath.substring(37,41);
			System.out.println(str);
			/*String sql = "insert into image(name,photo) values(?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);  
			stmt.setString(1,"Abdullah");
	
			InputStream inputStream = new FileInputStream(new File(filePath));
 						//System.out.println(inputStream);
            		stmt.setBlob(2, inputStream);
			int row = stmt.executeUpdate();
			if (row > 0) {

                		System.out.println("A contact was inserted with photo image.");
            		}

			con.close();  */
	 
	}
		
}

