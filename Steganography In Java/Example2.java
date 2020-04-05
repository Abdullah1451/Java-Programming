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


public class Example2{

public boolean encode(String path, String original_image_name, String ext, String stegano_image_name, String message){

		String image_name = path + "/" + original_image_name + "." + ext;
		BufferedImage orignal_image = getImage(image_name);
		
		//user space is not necessary for Encrypting
		BufferedImage new_image = user_space(orignal_image);
		new_image = add_text(new_image,message);
		
		return(setImage(new_image,new File(path + "/" + stegano_image_name + "." + "png"),"png"));
	}





	public String decode(String path, String stegano_image_name){

		try{
			//user space is necessary for decrypting
			BufferedImage stegano_image  = user_space(getImage(path + "/" + stegano_image_name + "." + "png"));

			String decode = decode_text(stegano_image);

			System.out.println(decode);
			JOptionPane.showMessageDialog(null, "Your message :  "+ decode);
			return(decode);
		}
		catch(Exception e){
			System.out.println("EXCEPTION  ::::  "+e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There is no hidden message in this image!","Error",JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}





	private BufferedImage getImage(String image_name){

		BufferedImage orignal_image	= null;
		File file = new File(image_name);
		
		try{
			orignal_image = ImageIO.read(file);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Image could not be read!","Error",JOptionPane.ERROR_MESSAGE);
		}
		return orignal_image;
	}





	private boolean setImage(BufferedImage new_image, File file, String ext){
		try{
			file.delete(); //delete resources used by the File
			ImageIO.write(new_image,ext,file);
			return true;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"File could not be saved!","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}





	private BufferedImage user_space(BufferedImage orignal_image){

		//create new_image with the attributes of image
		BufferedImage new_image  = new BufferedImage(orignal_image.getWidth(), orignal_image.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D	graphics = new_image.createGraphics();
		graphics.drawRenderedImage(orignal_image, null);
		graphics.dispose(); //release all allocated memory for this image
		return new_image;
	}





	private BufferedImage add_text(BufferedImage new_image, String text){
		//convert all items to byte arrays: image, message, message length
		int[] img = get_Int_data(new_image);
		System.out.println("smkslml :  "+img.length);
		String readFromFile = "D:\\Abdullah Working\\Java\\Steganography In Java\\Formulae.pdf";
		 
		//byte len[]   = bit_conversion(msg.length);
		
		try{

			File file = new File(readFromFile);
			InputStream fis = new FileInputStream(file);
			//DataInputStream dis = new DataInputStream(fis);
			BufferedInputStream dis = new BufferedInputStream(fis);

			int i = 0;
			int small_img[] = new int[dis.available()];
			String[] secretMessageLengthBytes = messageLength_Into_Binary(dis.available());


			while(dis.available() > 0){
				small_img[i] = dis.read();
				i++;
			}
			String[] secretMessageBytes = message_Into_Binary(small_img);

			encode_text(img, secretMessageLengthBytes,  0); //0 first positiong
			encode_text(img, secretMessageBytes, 16); //4 bytes of space for length: 4bytes*8bit = 32 bits

		}
		catch(Exception e){
			System.out.println("EXCEPTION  ::::  "+e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Target File cannot hold message!", "Error",JOptionPane.ERROR_MESSAGE);
		}
		return new_image;
	}





	private String[] message_Into_Binary(int[] small_img){

		int len = 8;
		System.out.println("msglength = "+small_img.length);
		//int[] val = new int[msg.length()];
		String[] str = new String[small_img.length];

		// convert each char to 
        // ASCII value 
        for (int i=0; i<small_img.length; i++){

        	//val[i] = Integer.valueOf(msg.charAt(i));
        	str[i] = String.format("%" + len + "s",Integer.toBinaryString(small_img[i])).replaceAll(" ", "0");//Integer.toBinaryString(val[i]);//CONVERTING INT TO BINARY STRING
        }
        return str;
	}





	private String[] messageLength_Into_Binary(int messageLength){
		String[] messageLengthBytes = new String[4];

		if(messageLength <=255){
			messageLengthBytes[0] = "00000000";
			messageLengthBytes[1] = "00000000";
			messageLengthBytes[2] = "00000000";
			messageLengthBytes[3] = String.format("%" + 8 + "s",Integer.toBinaryString(messageLength)).replaceAll(" ", "0");

		}
		else if(messageLength >= 256 && messageLength <= 65535){
			messageLengthBytes[0] = "00000000";
			messageLengthBytes[1] = "00000000";
			String s = String.format("%" + 16 + "s",Integer.toBinaryString(messageLength)).replaceAll(" ", "0");
			messageLengthBytes[2] = s.substring(0,8);
			messageLengthBytes[3] = s.substring(8,16);

		}
		return messageLengthBytes;
	}




	private int[] encode_text(int[] img, String[] messageOrLength, int offset){
 
		if(messageOrLength.length*4 > img.length){
			throw new IllegalArgumentException("File not long enough!");
		}

		for(int i=0; i<messageOrLength.length; i++){
			//loop through the 8 bits of each byte
			String dataByte = messageOrLength[i];

			for(int bit=0; bit<=7; bit++, offset++){ //ensure the new offset value carries on through both loops

				if(img[offset] < 2){
					bit=bit-1;
					continue;
				}
				else{

					String oneByteOfImage = Integer.toBinaryString(img[offset]);// One Image Byte Is Converting To Binary String
							//System.out.println("\n\noneByteOfImage  ::::  "+oneByteOfImage+"  img[offset] ::  "+img[offset]+"   ::::   " +dataByte.charAt(bit) + dataByte.charAt(bit+1));
					//Replacing Last One Bit Of Message Or Length Binary String To Image Binary String 
					oneByteOfImage = oneByteOfImage.substring(0, oneByteOfImage.length() - 2) + dataByte.charAt(bit) + dataByte.charAt(bit+1);
					bit++;
					img[offset] = Integer.parseInt(oneByteOfImage,2);//Converting Binary String Into Int
							//System.out.println("AFTERoneByteOfImage  ::::  "+oneByteOfImage+"  img["+offset+"] ::  "+img[offset]);
				}
			}
		}
		
		return img;
	}





	private String decode_text(BufferedImage stegano_image){

		int[] image = get_Int_data(stegano_image);
		int messageLength = 0;
		int offset  = 16;
		String messageLengthBytes = "";

		//loop through 16 bytes of data to determine text length
		for(int i=0; i<16; i++){

			String oneByteOfImage = Integer.toBinaryString(image[i]);
			messageLengthBytes += oneByteOfImage.charAt(oneByteOfImage.length()-2);
			messageLengthBytes += oneByteOfImage.charAt(oneByteOfImage.length()-1);
		}

		messageLength = Integer.parseInt(messageLengthBytes,2);
		String[] messageBytes = new String[messageLength];
		//loop through each byte of text
		for(int i=0; i<messageBytes.length; i++ ){

			messageBytes[i] = "";
			//loop through each bit within a byte of text
			for(int j=0; j<4; j++, offset++){

				if(image[offset] < 2){
					j=j-1; 
					continue;
					
				}
				else{
					String oneByteOfImage = Integer.toBinaryString(image[offset]);
					messageBytes[i] += oneByteOfImage.charAt(oneByteOfImage.length()-2);
					messageBytes[i] += oneByteOfImage.charAt(oneByteOfImage.length()-1);
				}
			}
		}

		int[] message_In_Int = new int[messageLength];
		//String secretMessage = "";

		for(int i=0; i<messageLength; i++){

        	message_In_Int[i] = Integer.parseInt(messageBytes[i],2);//CONVERTING BINARY STRING TO INT
        	//secretMessage += Character.toString((char) message_In_Int[i]); // String.valueOf(val2[i]);
        }

        boolean bool = image_write(message_In_Int);

        if(bool == true){
        	return "Image Formed";
        }else{
        	return "Image Not Formed";
        }
	}



	private boolean image_write(int[] message_In_Int){
		try{
			File ob	  =   new File("D:\\Abdullah Working\\Java\\Steganography In Java\\formu.pdf");
			FileOutputStream nf = new FileOutputStream(ob);
			
			if(!ob.exists()){
				ob.createNewFile();
				System.out.println("File Name: "+ ob.getName());
			}
			
			for (int i=0; i<message_In_Int.length; i++) {
				nf.write(message_In_Int[i]);
			}
			return true;
		}
		catch (Exception e) {
			System.out.println("EXCEPTION  ::::  "+e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There is no hidden message in this image!","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}





	private int[] get_Int_data(BufferedImage new_image){

		WritableRaster raster   = new_image.getRaster();
		DataBufferInt buffer = (DataBufferInt)raster.getDataBuffer();
		return buffer.getData();
	}





	

	
	public static void main(String[] args) {
		
		Example2 obj = new Example2();
		Scanner input = new Scanner(System.in);


		System.out.print("Select One Option :-\n  1.Encode  2.Decode  :: ");
		int option = input.nextInt();
		input.nextLine();

		if(option == 1){
			System.out.print("\n\nEnter The Path Of Image Folder  :: ");
			String path = "D:\\Abdullah Working\\Java\\Steganography In Java";

			System.out.print("\nEnter Image Name  :: ");
			String imageName = input.nextLine();

			System.out.print("\nEnter Image Type(jpg,png)  :: ");
			String imageType = input.nextLine();

			System.out.print("\nEnter New Image Name  :: ");
			String newImageName = input.nextLine();

			System.out.print("\nEnter Secret Message  :: ");
			String secretMessage = input.nextLine();

			boolean bool = obj.encode(path, imageName, imageType, newImageName, secretMessage);
			if(bool == true){
				System.out.println("DONE!!");
			}
			else{
				System.out.println("SORRY!!");
			}
		}
		else if(option == 2){
			System.out.print("\n\nEnter The Path Of Image Folder  :: ");
			String path = "D:\\Abdullah Working\\Java\\Steganography In Java";


			System.out.print("\nEnter Name Of Steganographic Image  :: ");
			String imageName = input.next();

			obj.decode(path, imageName);
		}
		else{
			System.out.println("Wrong Input Sorry!");
		}
	}
}