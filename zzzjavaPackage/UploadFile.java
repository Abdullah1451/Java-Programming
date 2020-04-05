package javaPackage;
import java.sql.*;
//import java.util.Scanner;
import java.io.*;
import javax.servlet.http.Part;

public class UploadFile{
	public static String URL = "jdbc:mysql://localhost:3306/webpage";
	static final String USER = "root";
	static final String PASS = "Ammi@147";
	
	//Scanner sc = new Scanner(System.in);
	
	public boolean uploadFile(String user ,Part filePart){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			System.out.println("Enetered in the Upload class to connect");
			Connection con = DriverManager.getConnection(URL,USER,PASS);

			String sql = "insert into images(image_name,image) values(?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);  
			
			InputStream inputStream = null;
			if (filePart != null) {
				
	            // prints out some information for debugging
	            String imageName = filePart.getName();
	            stmt.setString(1,imageName);
	            
	            System.out.println(imageName);
	            System.out.println(filePart);
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            System.out.println(inputStream);
	        }
 
			
			if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
				stmt.setBlob(2, inputStream);
            }
			int row = stmt.executeUpdate();
			System.out.println(row);
			if (row > 0) {

                		System.out.println("A contact was inserted with photo image.");
                		return true;
            		}
			con.close();  
		}
		catch(Exception e){ System.out.println(e);}
		return false;  
	}
		
}

