import java.io.*;
public class CreateFile{
	public static void main(String args[]){

		try{
			File ob = new File("D:\\Abdullah Working\\Java\\Java file\\MyFile2.txt");
			
			if(!ob.exists()){
				ob.createNewFile();
				System.out.println("File Name: "+ ob.getName());
				
			}	
			else{
				System.out.println("No");
			}
		}
		catch (IOException e) {
      			System.out.println("An error occurred.");
      			//e.printStackTrace();
		}
	}
}