import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.Point;
import java.awt.*;
import java.io.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferInt;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Encoding{

	public static Scanner input;
	static int offset;
	Encoding(){
		input = new Scanner(System.in);
		offset = 0;
	}

public boolean encode(String image_name, String stegano_image_name){

		BufferedImage orignal_image = getImage(image_name);
		
		//user space is not necessary for Encrypting
		BufferedImage new_image = user_space(orignal_image);
		new_image = add_text(new_image);
		
		return(setImage(new_image,new File(stegano_image_name+ "." + "png"),"png"));
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




	private String[] secret_File_Into_Bytes(String fileOrImagePath){

		try{
			
			File file = new File(fileOrImagePath);
			InputStream fis = new FileInputStream(file);
			//DataInputStream dis = new DataInputStream(fis);
			BufferedInputStream dis = new BufferedInputStream(fis);

			int i = 0;
			int small_img[] = new int[dis.available()];

			while(dis.available() > 0){
				small_img[i] = dis.read();
				i++;
			}
			String[] secretFileBytes = message_Into_Binary(small_img);

			return secretFileBytes;
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "File Not Found Exception", "Error",JOptionPane.ERROR_MESSAGE);
			return null;
		}

		
	}





	private BufferedImage add_text(BufferedImage new_image){

		//convert all items to byte arrays: image, message, message length
		int[] img = get_Int_Data(new_image);
			//System.out.println("Image length  ::  "+img.length);

		try{

			
			/*
			 *
			 *
			 Asking Want to hide file ,image or message
			 *
			 *
			 */
			System.out.print("What You Want To Hide :-\n  1.File or Image  2.Message  :: ");
			int option = input.nextInt();
			input.nextLine();
			
			/*
			 *
			 IF THEY WANT TO HIDE FILE OR IMAGE THEN 
			 THIS CONDITION WILL BE TRUE 
			 *
			 */
			if(option == 1){

				System.out.print("\nEnter File Or Image Full Path(including Name Of File)  :: ");
				String fileOrImagePath = input.nextLine();

				//converting file daa into binary string 
				String[] secretFileBytes = secret_File_Into_Bytes(fileOrImagePath);
				String[] secretFileLengthBytes = messageLength_Into_Binary(secretFileBytes.length);

				
				/*
				 *
				 *
				 ASKING WANT TO ADD PASSWORD OR NOT
				 *
				 *
				 */
				System.out.print("\nWant To Enter A Password(enter 'yes' or 'no')  :: ");
				String wantPassword = input.nextLine();

				if(wantPassword.equals("yes") || wantPassword.equals("Yes") || wantPassword.equals("YES")){
					
					String[] passwordBytes = password_Into_Bytes();
					String[] passwordLengthBytes = messageLength_Into_Binary(passwordBytes.length);

					//calling encode_text method to replace last two bits to images with secret file or message bits
					encode_Text(img, passwordLengthBytes); //0 first positiong Hiding password length
					encode_Text(img, passwordBytes); //hiding password
					encode_Text(img, secretFileLengthBytes); //0 first positiong
					encode_Text(img, secretFileBytes); //4 bytes of space for length: 4bytes*8bit = 32 bits

				}
				else if(wantPassword.equals("no") || wantPassword.equals("No") || wantPassword.equals("NO")){

					//calling encode_text method to replace last two bits to images with secret file or message bits
					encode_Text(img, secretFileLengthBytes); //0 first positiong
					encode_Text(img, secretFileBytes); //4 bytes of space for length: 4bytes*8bit = 32 bits
				}
				else{
					System.out.print("\n\nSorry Wrong!!");
					System.exit(0);
				}
				

			}
			/*
			 *
			 IF THEY WANT TO A MESSAGE THEN 
			 THIS CONDITION WILL BE TRUE 
			 *
			 */
			else if(option == 2){

				System.out.print("\nEnter Your Secret Message  :: ");
				String secretMessage = input.nextLine();

				int[] val = message_Into_Int(secretMessage);//Calling message_Into_Int() to covert message into int
				String[] secretMessageBytes = message_Into_Binary(val);
		        String[] secretMessageLengthBytes = messageLength_Into_Binary(secretMessage.length());


		        /*
				 *
				 *
				 ASKING WANT TO ADD PASSWORD OR NOT
				 *
				 *
				 */
				System.out.print("\nWant To Enter A Password(enter 'yes' or 'no')  :: ");
				String wantPassword = input.nextLine();

				if(wantPassword.equals("yes") || wantPassword.equals("Yes") || wantPassword.equals("YES")){
					
					String[] passwordBytes = password_Into_Bytes();
					String[] passwordLengthBytes = messageLength_Into_Binary(passwordBytes.length);

					//calling encode_text method to replace last two bits to images with secret file or message bits
					encode_Text(img, passwordLengthBytes); //0 first positiong Hiding password length
					encode_Text(img, passwordBytes); //hiding password
					encode_Text(img, secretMessageLengthBytes); //0 first positiong
					encode_Text(img, secretMessageBytes); //4 bytes of space for length: 4bytes*8bit = 32 bits

				}
				else if(wantPassword.equals("no") || wantPassword.equals("No") || wantPassword.equals("NO")){

					//calling encode_text method to replace last two bits to images with secret file or message bits
					encode_Text(img, secretMessageLengthBytes); //0 first positiong
					encode_Text(img, secretMessageBytes); //4 bytes of space for length: 4bytes*8bit = 32 bits
				}
				else{

					System.out.print("\n\nSorry Wrong input bye bye!!");
					System.exit(0);
				}

			}
			/*
			 *
			 IF NON OF THEM IS THEN THE PROGRAM WILL EXIT IN ELSE BLOCK 
			 *
			 */
			else{
				System.out.print("\n\nWrong!!");
				System.exit(0);
			}
		}
		catch(Exception e){

			System.out.println("EXCEPTION  ::::  "+e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Target File cannot hold message!", "Error",JOptionPane.ERROR_MESSAGE);
		}
		return new_image;
	}




	private String[] password_Into_Bytes(){

		System.out.print("\nEnter Password(Total 8 Characters)  :: ");
		String password = input.nextLine();

		if(password.length() == 8){
			
			int[] passwordInInt = message_Into_Int(password);
			String[] passwordBytes = message_Into_Binary(passwordInInt);
			return passwordBytes;
		}
		else{
			return password_Into_Bytes();
		}
	}





	private int[] message_Into_Int(String secretMessage){

		int[] val = new int[secretMessage.length()];

		for (int i=0; i<secretMessage.length(); i++){
        	val[i] = Integer.valueOf(secretMessage.charAt(i));
        }
        return val;
	}





	private String[] message_Into_Binary(int[] small_img_or_message){

		int len = 8;
		System.out.println("msglength = "+small_img_or_message.length);
		//int[] val = new int[msg.length()];
		String[] str = new String[small_img_or_message.length];

		// convert each char to 
        // ASCII value 
        for (int i=0; i<small_img_or_message.length; i++){

        	str[i] = String.format("%" + len + "s",Integer.toBinaryString(small_img_or_message[i])).replaceAll(" ", "0");//Integer.toBinaryString(val[i]);//CONVERTING INT TO BINARY STRING
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




	private int[] encode_Text(int[] img, String[] messageOrLength){
 
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





	private int[] get_Int_Data(BufferedImage new_image){

		WritableRaster raster   = new_image.getRaster();
		DataBufferInt buffer = (DataBufferInt)raster.getDataBuffer();
		return buffer.getData();
	}



	
	public static void main(String[] args) {
		
		Encoding obj = new Encoding();


		System.out.print("Select One Option :-\n  1.Encode  2.Decode  :: ");
		int option = input.nextInt();
		input.nextLine();

		if(option == 1){
			System.out.print("\n\nEnter The Path Of Image Folder  :: ");
			String path = "D:\\Abdullah Working\\Java\\Steganography In Java";

			System.out.print("\nEnter Image Name  :: ");
			String imageName = input.nextLine();

			System.out.print("\nEnter New Image Name  :: ");
			String newImageName = input.nextLine();

			newImageName = path  + "/" + newImageName;
			path = path + "/" + imageName;

			boolean bool = obj.encode(path, newImageName);
			if(bool == true){
				System.out.println("DONE!!");
			}
			else{
				System.out.println("SORRY!!");
			}
		}
		else{
			System.out.println("Wrong Input Sorry!");
		}
	}
}