import java.nio.*; 
import java.io.*; 

public class Byte{
	public static void main(String Ar[]) {
        	try {
			int a = 160;
			short[] tempShort = new short[4];
			for (int b = 0; b < 4; b++) {
    				tempShort[b] = (short)a;
			}
			/*short ans = tempShort[0];
			ans += tempShort[1]<<8;
			ans += tempShort[2]<<16;
			ans += tempShort[3]<<24;*/
			FileOutputStream fos = new FileOutputStream("text.txt");
            		DataOutputStream out = new DataOutputStream (fos);
			System.out.println(a<<24>>24);
			System.out.println(a<<16>>24);
			System.out.println(a<<8>>24);
			System.out.println(a>>24);
			out.write(a<<24>>24);
			out.write(a<<16>>24);
			out.write(a<<8>>24);
			out.write(a>>24);

		}
        	catch (Exception e) {
            		System.out.println ("I/O exception: " + e);
        	}
    
     	}
}





/*ByteBuffer buf = ByteBuffer.allocate (4); // 1 MiB
            buf.order (ByteOrder.LITTLE_ENDIAN);
            buf.putInt (123);
            buf.flip ();
	    FileOutputStream fos = new FileOutputStream("text.txt");
            DataOutputStream out = new DataOutputStream (fos);
            out.writeInt(buf.getInt(0));
            out.close ();*/