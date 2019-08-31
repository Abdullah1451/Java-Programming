import java.io.*;

public class ReadFile{
	public static void main(String args[])throws Exception{
		
			File ob = new File("D:\\Abdullah Working\\Java\\Java file\\MyFile2.txt");
			BufferedReader r = new BufferedReader(new FileReader(ob));
			String l;
			System.out.println(ob.getName());
			while((l=r.readLine()) != null)
				System.out.println(l);
			
		
	}
}