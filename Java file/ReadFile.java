import java.io.*;

public class ReadFile{
	public static void main(String args[])throws Exception{
		
			File ob = new File("aa.jpg");
			BufferedInputStream r = new BufferedInputStream(new FileInputStream(ob));
			String l;
			System.out.println(ob.getName());
			while((r.available()) >1)
				System.out.println(r.read());
			
		
	}
}