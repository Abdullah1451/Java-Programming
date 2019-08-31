import java.io.*;

public class WriteFile{
	public static void main(String args[]){
		try{
			File ob = new File("D:\\Abdullah Working\\Java\\Java file\\MyFile2.txt");
			if(ob.exists()){
				PrintWriter p = new PrintWriter(ob);
				p.println("Abdullah        7838   GNDIT");
				p.println("Mohd.Azhar      7838   SANT");
				p.println("Mohd.Ashhar     7053   GGIP");
				p.println("Mohd.Anas       9560   NIEC");
				p.close();
				System.out.println("done");
			}
			else{
				System.out.println("n");
			}
		}
		catch(FileNotFoundException e){
			System.out.println("sasddd");	
		}
	}
}