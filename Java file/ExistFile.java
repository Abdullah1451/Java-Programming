import java.io.*;

public class ExistFile{
	public static void main(String args[]){

		File ob = new File("D:\\Abdullah Working\\Java\\Java file\\MyFile2.txt");
		
		if(ob.exists()){
			System.out.println("File Name : " + ob.getName());
			System.out.println("File R " + ob.canRead());
			System.out.println("File W " + ob.canWrite());
			System.out.println("File P " + ob.getParent());
			System.out.println("File F " + ob.isFile());
			System.out.println("File H " + ob.isHidden());
			System.out.println("File M " + ob.lastModified());
			System.out.println("File S " + ob.length());
		}	

		else{
			System.out.println("No");
		}

	}
}