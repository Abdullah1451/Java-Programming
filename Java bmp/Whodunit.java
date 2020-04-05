import java.io.*;

public class Whodunit{
	

	public void readWhodunit(String readFromFile, HeaderBmp header){
		try{
			File ob	  =   new File("verdict3.bmp");
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
				//System.out.println(t);
				nf.write(t);
			}
			

			//long totalPixels = header.bmpInfoHeader.biWidth*header.bmpInfoHeader.biHeight;
			//System.out.println("total PIxels - "+totalPixels);
			int padding = header.bmpInfoHeader.biWidth % 4;
			int i=0,sum=0,avg=0;
			Triplet[] triplets = new Triplet[(int)file.length()];

			while(dis.available() > 2){
				
				triplets[i] = new Triplet();

				triplets[i].b = (short)dis.read();
				//triplets[i].b = (short)c2;
				

				triplets[i].g = (short)dis.read();
				//triplets[i].g = (short)c;
				
				triplets[i].r = (short)dis.read();
				
				if(triplets[i].b ==0 && triplets[i].g == 0){
					triplets[i].b = 255;
					triplets[i].g = 255;
					triplets[i].r = 255;
					nf.write(triplets[i].b);
					nf.write(triplets[i].g);
					nf.write(triplets[i].r);
				}
				else{
					sum = triplets[i].b + triplets[i].g + triplets[i].r;
					avg = sum/3;
					System.out.println("Avg = "+avg);
					/*if(avg <= 233){
						avg = avg-35;
						triplets[i].b = (short)avg;
						triplets[i].g = (short)avg;
						triplets[i].r = (short)avg;
						nf.write(triplets[i].b);
						nf.write(triplets[i].g);
						nf.write(triplets[i].r);
					}
					else{*/
					/*if(avg > 180){
						triplets[i].b = 255;
						triplets[i].g = 255;
						triplets[i].r = 255;
						nf.write(triplets[i].b);
						nf.write(triplets[i].g);
						nf.write(triplets[i].r);
					}
					else{*/
						triplets[i].b = (short)avg;
						triplets[i].g = (short)avg;
						triplets[i].r = (short)avg;
						nf.write(triplets[i].b);
						nf.write(triplets[i].g);
						nf.write(triplets[i].r);
					//}
				}
				i++;
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
		String readFromFile = "clue.bmp";
		
		Whodunit obj = new Whodunit();
		HeaderBmp header = obj.getHeaderInfo(readFromFile);
		obj.readWhodunit(readFromFile,header);
	}
}

class Triplet{
	short r;
	short g;
	short b;
}