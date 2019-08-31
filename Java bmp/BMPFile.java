import java.io.*;

public class BMPFile{
	
	public static void main(String args[]){

		try{
			/*File ob = new File("D:\\Abdullah Working\\Java\\Java bmp\\clue2.bmp");
			FileOutputStream nf = new FileOutputStream(ob);
			
			if(!ob.exists()){
				ob.createNewFile();
				System.out.println("File Name: "+ ob.getName());
			}	*/
			/*else{
				
			}*/


			InputStream f = new FileInputStream("D:\\Abdullah Working\\Java\\Java bmp\\smiley.bmp");
			BufferedInputStream bf = new BufferedInputStream(f);
			int b;
			
			for(int i=1;i<=54;i++)
			{
				b=bf.read();
				//nf.write(b);
				System.out.println(b);
			}

			
			//bf.skip(56);
						
			/*while((b = bf.read()) != -1){
				//System.out.println(b);
				if(b!=0){
					b=100;
					nf.write(b);
				}
				else
				//nf.write(b);
			
			}*/
			
			
			
			
			bf.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println();
		}
	}
}