import java.io.*;

public class HeaderBmp{
	
	public BitmapHeader bmpHeader;
	public BitmapInfoHeader bmpInfoHeader;
	
	
	public HeaderBmp(){
		bmpHeader = new BitmapHeader();
		bmpInfoHeader = new BitmapInfoHeader();
	}
	
	
	public void getHeaderInfo(String fileName){
		InputStream f;
		DataInputStream dis;	
		try{	
			f = new FileInputStream(fileName);
			dis = new DataInputStream(f);	

			bmpHeader.bfType = readAndConvToShort(dis);
			bmpHeader.bfSize = readAndConvToInt(dis);
			bmpHeader.bfReserved1 = readAndConvToShort(dis);
			bmpHeader.bfReserved2 = readAndConvToShort(dis);
			bmpHeader.bfOdisBits = readAndConvToInt(dis);
			
			
			bmpInfoHeader.biSize = readAndConvToInt(dis);
			bmpInfoHeader.biWidth = readAndConvToInt(dis);
			bmpInfoHeader.biHeight = readAndConvToInt(dis);
			bmpInfoHeader.biPlanes = readAndConvToShort(dis);
			bmpInfoHeader.biBitCount = readAndConvToShort(dis);
			bmpInfoHeader.biCompression = readAndConvToInt(dis);
			bmpInfoHeader.biSizeImage = readAndConvToInt(dis);
			bmpInfoHeader.biXPelsPerMeter = readAndConvToInt(dis);
			bmpInfoHeader.biYPelsPerMeter = readAndConvToInt(dis);
			bmpInfoHeader.biClrUsed = readAndConvToInt(dis);
			bmpInfoHeader.biClrImportant = readAndConvToInt(dis);		
			
			dis.close();
			f.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
		}

	}

	public int readAndConvToInt(DataInputStream dis){
		try{
			short[] tempShort = new short[4];
			for (int b = 0; b < 4; b++) {
    				tempShort[b] = (short)dis.readUnsignedByte();
			}
			int answer = tempShort[0];
			answer += tempShort[1] << 8;
			answer += tempShort[2] << 16;
			answer += tempShort[3] << 24;
			return answer;     
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
			return 0;
		}  
	}

	public short readAndConvToShort(DataInputStream dis){
		try{
			short[] tempShort = new short[2];
			for(int b = 0; b < 2; b++) {
    				tempShort[b] = (short)dis.readUnsignedByte();      
			}
   			short answer = tempShort[0];
  			answer += tempShort[1] << 8;
			return answer;        
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
			return 0;
		}
	}

}

class BitmapHeader{
	short bfType;
	int bfSize;	
	short bfReserved1;
	short bfReserved2;
	int bfOdisBits;
}

class BitmapInfoHeader{
	int biSize;
	int biWidth;
	int biHeight;
	short biPlanes;
	short biBitCount;
	int biCompression;
	int biSizeImage;
	int biXPelsPerMeter;
	int biYPelsPerMeter;
	int biClrUsed;
	int biClrImportant;
}