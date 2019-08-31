import java.io.*;

public class BufferedWriterFile{
	public static void main(String args[]){
		try{
			FileWriter ob = new FileWriter("D:\\Abdullah Working\\Java\\Java file\\MyFile3.txt",true);
			BufferedWriter bf = new BufferedWriter(ob);
			bf.write("Abdullsdewefcsdah        7838   GNDIT");
			bf.newLine();
			bf.write("Mohd.sdfAzhar      7838   SANT\n");
			bf.write("Mohd.Asdfhhar     7053   GGIP");
			bf.write("Mohd.Agbnas       9560   NIEC");
			bf.close();
			System.out.println("sdf");
		}
		catch(IOException e){
			System.out.println("sasddd");	
		}
	}
}