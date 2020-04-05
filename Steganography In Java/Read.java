import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.Point;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferInt;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Read{

	
	public int meth(static int offset){
		
		System.out.println("\n\noffset ::  "+offset);
		offset+=10;
		System.out.println("offsetafter ::  "+offset);
		return 0;
	}

	public static void main(String[] args) {
		

		Read r = new Read();

		r.meth(0);
		r.meth(1);
		r.meth(2);


		/*String readFromFile = "D:\\Abdullah Working\\Java\\Steganography In Java\\Formulae.pdf";
		try{

			File file = new File(readFromFile);
			InputStream fis = new FileInputStream(file);
			//DataInputStream dis = new DataInputStream(fis);
			BufferedInputStream dis = new BufferedInputStream(fis);
			int i = 0;
			System.out.println("ava ::  "+dis.available());
			while(dis.available() > 0){
				System.out.println("i :: "+i+"   ::::  "+dis.read());
				i++;
			}

		}
		catch (Exception e) {
				System.out.println(e);
		}*/	
	}
}