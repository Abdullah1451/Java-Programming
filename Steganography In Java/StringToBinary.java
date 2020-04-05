/*import java.io.File;
import java.util.*;
import java.lang.*;


public class StringToBinary{
	public static void main(String[] args) {

		String msg = "I Love India @123";
		int len = 8;
		System.out.println("msglength = "+msg.length());
		int[] val = new int[msg.length()];
		String[] str = new String[msg.length()];

		// convert each char to 
        // ASCII value 
        for (int i=0; i<msg.length(); i++){
        	val[i] = Integer.valueOf(msg.charAt(i));

        	System.out.println("val["+i+"] = "+val[i]);
        	

        	str[i] = String.format("%" + len + "s",Integer.toBinaryString(val[i])).replaceAll(" ", "0");//Integer.toBinaryString(val[i]);//CONVERTING INT TO BINARY STRING

        	System.out.println("str["+i+"] = "+str[i]+"\n\n");

        }
        //System.out.println("strleng = "+val.length+"\n\n");
        String message = "";
        int[] val2 = new int[str.length];
        for(int i=0; i<str.length; i++){
        	val2[i] = Integer.parseInt(str[i],2);//CONVERTING BINARY STRING TO INT
        	System.out.println("val2["+i+"] = "+val2[i]+"   val = "+val[i]);

        	message += Character.toString((char) val2[i]); // String.valueOf(val2[i]);
        }

		System.out.println("\n\nMessage :: "+message);
	}
}
*/



























import java.io.File;
import java.util.*;
import java.lang.*;
import java.awt.Point;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class StringToBinary{
	
	public static void main(String[] args) {
		BufferedImage orignal_image = null;
		File file = new File("ac1.jpg");

		try
		{
			String msg = "0111100101111010";
			orignal_image = ImageIO.read(file);
			//System.out.println(orignal_image);
			System.out.println("Length of msg = " + msg.length());
			BufferedImage new_image  = new BufferedImage(orignal_image.getWidth(), orignal_image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D	graphics = new_image.createGraphics();
			graphics.drawRenderedImage(orignal_image, null);
			graphics.dispose();

			System.out.println("ssss :: "+(orignal_image.getWidth()*orignal_image.getHeight()*3));

			for (int i=0,m=0;i<orignal_image.getWidth();i++) {
		        for (int j=0; j<orignal_image.getHeight() ; j++) {


					//Get RGB Color on each pixel
		        	Color c = new Color(orignal_image.getRGB(i,j));
					int r = c.getRed();
					int g = c.getGreen();
					int b = c.getBlue();

					

					
					

					//for (int m=0; m<msg.length(); m++){
					//System.out.println("\nbit " + m + ": " + str+"  msgbitbef  :: "+msg.charAt(m));

					if(m == msg.length()){
						
					}
					else{
						String str = Integer.toBinaryString(g);//CONVERTING INT TO BINARY STRING
						System.out.println("r = "+r+" , g = "+g+" , b = "+b);
						System.out.println("\nbit " + m + ": " + str+"  msgbitbef  :: "+msg.charAt(m));
						str = str.substring(0, str.length() - 1) + msg.charAt(m);
						System.out.println("\nafterbit " + m + ": " + str+"  msgbitaf  :: "+msg.charAt(m));
						m++;
						g = Integer.parseInt(str,2);//CONVERTING BINARY STRING TO INT
						System.out.println("r = "+r+" , g = "+g+" , b = "+b+"\n\n\n");
					}

				    

					Color gColor = new Color (r,g,b);
					new_image.setRGB(i, j, gColor.getRGB());
				}
			}	

			ImageIO.write(new_image, "jpg", new File("ac2.jpg"));

		}
		catch(Exception ex)
		{
			System.out.println("exception :: "+ex);
			JOptionPane.showMessageDialog(null, 
				"Image could not be read!","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}



























/*import java.io.File;
import java.util.*;
import java.lang.*;
import java.awt.Point;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Example{
	
	public static void main(String[] args) {
		BufferedImage orignal_image = null;
		File file = new File("ab.png");

		try
		{
			String msg = "0111100101111010";
			orignal_image = ImageIO.read(file);
			//System.out.println(orignal_image);
			System.out.println("Length of msg = " + msg.length());
			BufferedImage image  = new BufferedImage(orignal_image.getWidth(), orignal_image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

			for (int i=0,m=0;i<orignal_image.getHeight();i++) {
		        for (int j=0; j<orignal_image.getWidth() ; j++) {


					//Get RGB Color on each pixel
		        	Color c = new Color(orignal_image.getRGB(i,j));
					int r = c.getRed();
					int g = c.getGreen();
					int b = c.getBlue();

					String str = Integer.toBinaryString(g);//CONVERTING INT TO BINARY STRING

					
					//System.out.println("r = "+r+" , g = "+g+" , b = "+b);

					//for (int m=0; m<msg.length(); m++){
					//System.out.println("\nbit " + m + ": " + str+"  msgbitbef  :: "+msg.charAt(m));

					if(m == msg.length()){
						
					}
					else{
						System.out.println("\nbit " + m + ": " + str+"  msgbitbef  :: "+msg.charAt(m));
						str = str.substring(0, str.length() - 1) + msg.charAt(m);
						System.out.println("\nafterbit " + m + ": " + str+"  msgbitaf  :: "+msg.charAt(m));
						m++;
					}

					

	        			/*for (int k=0; k<str.length(); ++k) {//READING BITS AND CHANGING LSB ACCORDING TO THE MESSAGE
	        				if(k == (str.length()-1)){
	        					System.out.println("bit " + k + ": " + str.charAt(k)+"  msgbitbef  :: "+msg.charAt(m));

	        					str.charAt(k) = msg.charAt(m);
	        					
	        					System.out.println("afterbit " + k + ": " + str.charAt(k)+"  msgbitaf  :: "+msg.charAt(m));
	        				}

				            //System.out.println("bit " + k + ": " + str.charAt(k));
				        }*/
				    //}

				    //g = Integer.parseInt(str,2);//CONVERTING BINARY STRING TO INT
					//System.out.println("q : ");




					//int a = c.getAlpha();
					//System.out.println("r = "+r+" , g = "+g+" , b = "+b);
					//break;



					/*Color c = new Color(orignal_image.getRGB(i,j));
					byte[] r = new byte[]{(byte)c.getRed()};
					byte g = (byte)c.getGreen();
					byte b = (byte)c.getBlue();

					BitSet bitset = BitSet.valueOf(r);
					System.out.println("Length of bitset = " + bitset.length());
        			for (int k=0; k<bitset.length(); ++k) {
			            System.out.println("bit " + k + ": " + bitset[k]);
			        }
					//int a = c.getAlpha();
					System.out.println("r = "+r[0]+" , g = "+g+" , b = "+b);
					break;*/
					//System.out.println("affffffffffffffr = "+r+" , g = "+g+" , b = "+b+"\n\n\n");
					/*Color gColor = new Color (r,g,b);
					image.setRGB(i, j, gColor.getRGB());
				}
			}	

			ImageIO.write(image, "bmp", new File("grayscale.png"));*/


			/*Graphics2D	graphics = image.createGraphics();
			graphics.drawRenderedImage(orignal_image, null);
			graphics.dispose(); 
			byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();

			final boolean hasAlphaChannel = image.getAlphaRaster() != null;
			System.out.println("has alpha = "+hasAlphaChannel+"  , plen = "+pixels.length);



			if (hasAlphaChannel) {
				final int pixelLength = 4;
				for (int pixel = 0, row = 0, col = 0,i=0; pixel + 3 < pixels.length; pixel += pixelLength,i++) {
					int argb = 0;
					System.out.println("i :: "+i+"  ,pixels[pixel]a = "+(int) pixels[pixel]+"  ,pixels[pixel + 1]b = "+(int) pixels[pixel + 1]+"  ,pixels[pixel + 2]g = "+(int) pixels[pixel + 2]+"  ,pixels[pixel + 3]r = "+(int) pixels[pixel + 3]);
					argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
					argb += ((int) pixels[pixel + 1] & 0xff); // blue
					argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
					argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
					System.out.println("argb = "+argb);
					col++;
					if (col == orignal_image.getWidth()) {
						col = 0;
					row++;
					}
				}
	      	} 
	      	else {
				final int pixelLength = 3;
				for (int pixel = 0, row = 0, col = 0,i=0; pixel + 2 < pixels.length; pixel += pixelLength,i++) {
					int argb = 0;
					System.out.println("i :: "+i+"  ,pixels[pixel]b = "+(int) pixels[pixel]+"  ,pixels[pixel + 1]g = "+(int) pixels[pixel + 1]+"  ,pixels[pixel + 2]r = "+(int) pixels[pixel + 2]);

					argb += -16777216; // 255 alpha
					argb += ((int) pixels[pixel] & 0xff); // blue
					argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
					argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
					System.out.println("argb = "+argb);
					col++;
					if (col == orignal_image.getWidth()) {
						col = 0;
						row++;
					}
				}
			}*/

	/*	}
		catch(Exception ex)
		{
			System.out.println("exception :: "+ex);
			JOptionPane.showMessageDialog(null, 
				"Image could not be read!","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}*/

