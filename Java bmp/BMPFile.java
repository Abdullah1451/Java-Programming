import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BMPFile{
	
	public static void main(String args[]){

		BufferedImage img = null;
	    File f = null;

	    //read image
	    try{
	      
		      f = new File("Blue.jpg");
		      img = ImageIO.read(f);

	      	int width = img.getWidth();
			int height = img.getHeight();

			System.out.println(width+"  "+height);

			for (int i=0,m=0; i<height; i++) {
                for (int j=0; j<width; j++,m++) {

                	long p = img.getRGB(i,j);
					System.out.println(p+"   i : "+i+"   j : "+j);
				}
			}

			

	    }
	    catch(IOException e){
	      	System.out.println(e);
	    }
	}
}














/* 
	try{
			/*File ob = new File("D:\\Abdullah Working\\Java\\Java bmp\\clue2.bmp");
			FileOutputStream nf = new FileOutputStream(ob);
			
			if(!ob.exists()){
				ob.createNewFile();
				System.out.println("File Name: "+ ob.getName());
			}	*/
			/*else{
				
			}*/

/*
			InputStream f = new FileInputStream("D:\\Abdullah Working\\Java\\Java bmp\\blue.bmp");
			BufferedInputStream bf = new BufferedInputStream(f);
			int b;
			
			for(int i=1;i<=54;i++)
			{
				b=bf.read();
				//nf.write(b);
				System.out.println(b);
			}*/

			
			//bf.skip(56);
			/*int i=0;
						
			while((b = bf.read()) != -1){
				System.out.println(b+"   i :: "+i);
				i++;
				/*if(b!=0){
					b=100;
					nf.write(b);
				}*/
				//else
				//nf.write(b);
			
		/*	}
			
			
			
			
			bf.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println();
		}
*/