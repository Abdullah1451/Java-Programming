import java.io.*;

public class Practice{
	
	public static void main(String args[]){

		try{
			Practice bmp = new Practice();
			InputStream f = new FileInputStream("D:\\Abdullah Working\\Java\\Java bmp\\red2.bmp");
			DataInputStream dis = new DataInputStream(f);
			dis.skipBytes(18);
			short[] tempShort = new short[4];
			for (int b = 0; b < 4; b++) {
    				tempShort[b] = (short)dis.readUnsignedByte();           
			}
			int curVal = bmp.convToInt(tempShort);
			System.out.println(curVal);
			
			dis.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println();
		}
	}
	public int convToInt(short[] sb){

		short[] tempShort = new short[4];
		for (int b = 0; b < 4; b++) {
    			tempShort[b] = (short)dis.readUnsignedByte();           
		}
   		int answer = sb[0];
  		answer += sb[1] << 8;
		answer += sb[2] << 16;
		answer += sb[3] << 24;
		return answer;        
		}
}
public int ConvToInt(int x,FileOutputStream nf){
		try{
			//System.out.println(x);
			short[] tempShort = new short[4];
			for (int b = 0; b < 4; b++) {
    				tempShort[b] = (short)x;      
			}
			short ans = tempShort[0];
			ans += tempShort[1]<<8;
			ans += tempShort[2]<<16;
			ans += tempShort[3]<<24;
			System.out.println(ans>>8);
			System.out.println(tempShort[1]>>8);
			System.out.println(tempShort[2]>>16);
			System.out.println(tempShort[3]>>24);
   			nf.write(ans>>8);
			nf.write(tempShort[1]>>8);
   			nf.write(tempShort[2]>>16);
			nf.write(tempShort[3]>>24);    
			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
			return 0;
		}  
	}

	public short ConvToShort(short x,FileOutputStream nf){
		try{
			//System.out.println(x);
			short[] tempShort = new short[2];
			for(int b = 0; b < 2; b++) {
    				tempShort[b] = (short)x;      
			}
			//short ans += tempShort[0]<<8;
			//ans += tempShort[1]>>8;
			System.out.println(tempShort[0]<<24>>24);
			System.out.println(tempShort[1]>>8);
   			nf.write(tempShort[0]<<24>>24);
			nf.write(tempShort[1]>>8);
     			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println();
			return 0;
		}
	}



if(tempShort[b]*n>255){
						if(a==0){
							a =(tempShort[b]*n)-255;
							tempShort[b]=255;
							data.write(tempShort[b]);
						}
						else if(a!=0){
							a =((tempShort[b]*n)+a)-255;
							tempShort[b]=255;
							data.write(tempShort[b]);
						}
					}
					else{
						tempShort[b]*=n;
						if(tempShort[b]+a>255){
							a =(tempShort[b]+a)-255;
							tempShort[b]=255;
							data.write(tempShort[b]);
						}
						else{
							tempShort[b]+=a;
							a=0;
							data.write(tempShort[b]);
						}
					}






	short ans = tempShort[0];
			ans += tempShort[1]<<8;
			ans += tempShort[2]<<16;
			ans += tempShort[3]<<24;

			data.write(ans>>8);
			data.write(tempShort[1]>>8);
   			data.write(tempShort[2]>>16);
			data.write(tempShort[3]>>24);
