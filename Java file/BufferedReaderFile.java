import java.io.*;

public class BufferedReaderFile{
	public static void main(String args[]){
		try{
			//FileReader ob = new FileReader("D:\\Abdullah Working\\Java\\Java file\\MyFile3.txt");
			BufferedReader bf = new BufferedReader(new FileReader("D:\\Abdullah Working\\Java\\Java file\\MyFile3.txt"));
			String l;
			while((l = bf.readLine()) != null)
				System.out.println(l);
			bf.close();
		}
		catch(IOException e){
			System.out.println("sasddd");	
		}
	}
}