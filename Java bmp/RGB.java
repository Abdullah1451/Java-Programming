import java.io.*;

public class RGB{
	

	public void readRGB(String readFromFile, HeaderBmp header){
		try{
			File ob	  =   new File("D:\\Abdullah Working\\Java\\Java bmp\\scopy.bmp");
			FileOutputStream nf = new FileOutputStream(ob);
			
			if(!ob.exists()){
				ob.createNewFile();
				System.out.println("File Name: "+ ob.getName());
			}	

			
			File file = new File(readFromFile);
			InputStream fis = new FileInputStream(file);
			//DataInputStream dis = new DataInputStream(fis);
			BufferedInputStream dis = new BufferedInputStream(fis);
			

			for(int i=1,t;i<=54;i++)
			{
				t=dis.read();
				System.out.println(t);
				nf.write(t);
			}

			//long totalPixels = header.bmpInfoHeader.biWidth*header.bmpInfoHeader.biHeight;
			System.out.println("File size - "+(int)file.length());
			//System.out.println("total PIxels - "+totalPixels);
			int padding = header.bmpInfoHeader.biWidth % 4;
			
			Triplet[] triplets = new Triplet[(int)file.length()];
			int i=0,c=0,c2=255,c3 =150;
			boolean ccc=false;
			while(dis.available() > 2){
				
				triplets[i] = new Triplet();

				if(dis.available() > 885){
					triplets[i].b = (short)dis.read();
					triplets[i].b = (short)c2;
					nf.write(triplets[i].b);

					triplets[i].g = (short)dis.read();
					triplets[i].g = (short)c;
					nf.write(triplets[i].g);

					triplets[i].r = (short)dis.read();
					triplets[i].r = (short)c3;
					nf.write(triplets[i].r);
				}
				if(dis.available() < 885){
					triplets[i].b = (short)dis.read();
					triplets[i].b = (short)c2;
					nf.write(triplets[i].b);

					triplets[i].g = (short)dis.read();
					triplets[i].g = (short)c;
					nf.write(triplets[i].g);

					triplets[i].r = (short)dis.read();
					triplets[i].r = (short)c3;
					nf.write(triplets[i].r);
				}
				if(c==255 && c2==0){
					c=0;
					c2=255;
					if(ccc==true)
						c3=255;
					ccc=true;
				}

				//System.out.println(i+" -> "+dis.available()+" R - "+triplets[i].r+" G - "+triplets[i].g+" B - "+triplets[i].b);
				i++;
				c++;
				c2--;
				c3--;
				if(i % header.bmpInfoHeader.biWidth == 0){
						for(int x=0,temp; x<padding; x++){
							temp = dis.read();
							nf.write(temp);
						}
				}	
			}

			dis.close();

			
			/*for(i=0;triplets[i]!=null;i++){
				

				triplets[i].r = 0;
				nf.write(triplets[i].r);
				triplets[i].g = 0;
				nf.write(triplets[i].g);
				triplets[i].b = 0;
				nf.write(triplets[i].b);
				System.out.println("R - "+triplets[i].r);
				System.out.println("G - "+triplets[i].g);
				System.out.println("B - "+triplets[i].b);
			}
			while((i=dis.read()) != -1){
				nf.write(i);
				System.out.println(i);
			}*/
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
		}
	}
	
	public HeaderBmp getHeaderInfo(String fileName){
		HeaderBmp header = new HeaderBmp();
		header.getHeaderInfo(fileName);
		return header;
	}

	public static void main(String as[]){
		String readFromFile = "D:\\Abdullah Working\\Java\\Java bmp\\smiley1.bmp";
		
		RGB obj = new RGB();
		HeaderBmp header = obj.getHeaderInfo(readFromFile);
		obj.readRGB(readFromFile,header);
	}
}

class Triplet{
	short r;
	short g;
	short b;
}