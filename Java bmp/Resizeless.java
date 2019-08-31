import java.io.*;

public class Resizeless{
	
	public int n = 3;
	public void readResize(String readFromFile, HeaderBmp header){

		try{
			File ob	  =   new File("smallvictim.bmp");
			FileOutputStream fos = new FileOutputStream(ob);
			DataOutputStream data = new DataOutputStream(fos);
			
			if(!ob.exists()){
				ob.createNewFile();
				System.out.println("File Name: "+ ob.getName());
			}	
 
			boolean no = false,yes = true;

			File file = new File(readFromFile);
			InputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			BufferedInputStream bis = new BufferedInputStream(fis);
			

			ConvToShort(no,dis,data);
			size(header,dis,data);
									//ConvToInt(no,dis,data);
			ConvToShort(no,dis,data);
			ConvToShort(no,dis,data);
			ConvToInt(no,dis,data);
			
			ConvToInt(no,dis,data);
			ConvToInt(yes,dis,data);
			ConvToInt(yes,dis,data);
			ConvToShort(no,dis,data);
			ConvToShort(no,dis,data);
			ConvToInt(no,dis,data);
			ConvToInt(no,dis,data);
			ConvToInt(no,dis,data);
			ConvToInt(no,dis,data);
			ConvToInt(no,dis,data);
			ConvToInt(no,dis,data);

									//System.out.println("w - "+header.bmpIdataoHeader.biWidth);
									//System.out.println("h - "+header.bmpIdataoHeader.biHeight);
			int padding = header.bmpInfoHeader.biWidth % 4;
			System.out.println("padding - "+padding);
			//int newPadding = (header.bmpInfoHeader.biWidth*n) % 4;
									//System.out.println("new padding - "+newPadding);
			int i = 1,k=0,pc=0;
			int sumb=0,sumg=0,sumr=0;

			Triplet[] triplets = new Triplet[(int)file.length()];
									//System.out.println(bis.available());
			while(bis.available() > 2){
				k=i;
				triplets[i] = new Triplet();

				triplets[i].b = (short)bis.read();
				triplets[i].g = (short)bis.read();
				triplets[i].r = (short)bis.read();

									//System.out.println("i = "+i+"  avi = "+bis.available());
								       //System.out.println("before b = "+triplets[i].b+"  g = "+triplets[i].g+"  r = "+triplets[i].r);
				if(i%3==0){
					for(i=i-2;i<=k;i++){
									//System.out.println("b = "+triplets[i].b+"  g = "+triplets[i].g+"  r = "+triplets[i].r);
						sumb += triplets[i].b;
						sumg += triplets[i].g;
						sumr += triplets[i].r;
						//System.out.println("b = "+sumb+"  g = "+sumg+"  r = "+sumr);
						pc++;
							/*if(pc % (header.bmpInfoHeader.biWidth*n) == 0){
								for(int x=0,temp; x<newPadding; x++){
									temp = 0;
												//System.out.println("new temp = "+temp);
									data.write(temp);
								}
							}*/
						
					}
				}
				i=k;

				if(i%3==0){
					sumb = sumb/3;
					sumg = sumg/3;
					sumr = sumr/3;
					//System.out.println("after b = "+sumb+"  g = "+sumg+"  r = "+sumr);
					data.write(sumb);
					data.write(sumg);
					data.write(sumr);
					sumb=0;
					sumg=0;
					sumr=0;
				}
				
				
				if(i % header.bmpInfoHeader.biWidth == 0){
						for(int x=0,temp; x<padding; x++){
							temp = bis.read();
											//System.out.println("temp = "+temp);
											//data.write(temp);
						}
				}
				i++;	
			}

			bis.close();
			System.out.println("Done");

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
		}
	}



	public void size(HeaderBmp header,DataInputStream dis,DataOutputStream data){
		try{
			int newWidth = header.bmpInfoHeader.biWidth*n;
			int newHeight = header.bmpInfoHeader.biHeight*n;
			int Size = ((3 * newWidth)*newHeight )+54;
			short[] tempShort = new short[4];
			for (int b = 0; b < 4; b++) {
    				tempShort[b] = (short)dis.readUnsignedByte();
			}
			data.write(Size<<24>>24);
			data.write(Size<<16>>24);
			data.write(Size<<8>>24);
			data.write(Size>>24);
			System.out.println(Size<<24>>24);
			System.out.println(Size<<16>>24);
			System.out.println(Size<<8>>24);
			System.out.println(Size>>24);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
		}
	}
	



	public int ConvToInt(boolean ny,DataInputStream dis,DataOutputStream data){
		try{
			short[] tempShort = new short[4];
			if(ny == true){
				for (int b = 0; b < 4; b++){
    					tempShort[b] = (short)dis.readUnsignedByte();
				}
				int answer = tempShort[0];
				answer += tempShort[1] << 8;
				answer += tempShort[2] << 16;
				answer += tempShort[3] << 24;
				answer /= n;
				data.write(answer<<24>>24);
				data.write(answer<<16>>24);
				data.write(answer<<8>>24);
				data.write(answer>>24);
				System.out.println(answer<<24>>24);
				System.out.println(answer<<16>>24);
				System.out.println(answer<<8>>24);
				System.out.println(answer>>24);
					
				
			}
			else{
				for (int b = 0; b < 4; b++) {
    					tempShort[b] = (short)dis.readUnsignedByte();
					data.write(tempShort[b]);
					System.out.println(tempShort[b]);
				}
			}
			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
			return 0;
		}  
	}




	public short ConvToShort(boolean ny,DataInputStream dis,DataOutputStream data){
		try{
			short[] tempShort = new short[2];
			for(int b = 0; b < 2; b++){
    				tempShort[b] = (short)dis.readUnsignedByte();  
				data.write(tempShort[b]); 
				System.out.println(tempShort[b]);   
			}   
			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
			return 0;
		}
	}

	public HeaderBmp getHeaderInfo(String fileName){
		HeaderBmp header = new HeaderBmp();
		header.getHeaderInfo(fileName);
		return header;
	}

	public static void main(String as[]){
		String readFromFile = "victim.bmp";
		
		Resizeless obj = new Resizeless();
		HeaderBmp header = obj.getHeaderInfo(readFromFile);
		obj.readResize(readFromFile,header);
	}
}

class Triplet{
	short r;
	short g;
	short b;
}