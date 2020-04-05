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

	public String decode(String path, String stegano_image_name){

		try{
			//user space is necessary for decrypting
			BufferedImage stegano_image  = user_space(getImage(stegano_image_name));

			String decode = decode_Text(stegano_image);

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





	private String decode_Text(BufferedImage stegano_image){

		int[] image = get_Int_data(stegano_image);

		String password = check_Password_Exist(image);

		if(password == null){

			int messageLength = messageLengthBytes_Into_Int(image);//getting message length

			int[] messageInInt = message_In_Int(image, messageLength);

			String secretMessage = int_Into_String(messageInInt);

			return secretMessage;
		}
		else{
			boolean bool = matching_Password_WithUserInput(password);

			int messageLength = messageLengthBytes_Into_Int(image);//getting message length

			int[] messageInInt = message_In_Int(image, messageLength);


			String secretMessage = int_Into_String(messageInInt);

			return secretMessage;
		}

        //boolean bool = image_write(message_In_Int);
	}




	private int[] message_In_Int(int[] image, int messageLength){

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

		return binaryString_Into_int(messageBytes);
	}





	private int messageLengthBytes_Into_Int(int[] image){

		//initialize messageLengthBytes here
		String messageLengthBytes = "";
		int offset2 = offset + 16;
		//loop through 16 bytes of data to determine text length
		for(int i=offset; i<offset2; i++,offset++){

			String oneByteOfImage = Integer.toBinaryString(image[offset]);
			messageLengthBytes += oneByteOfImage.charAt(oneByteOfImage.length()-2);
			messageLengthBytes += oneByteOfImage.charAt(oneByteOfImage.length()-1);
		}

		int messageLength = Integer.parseInt(messageLengthBytes,2);
		return messageLength;
	}





	private String check_Password_Exist(int[] image){

		String passwordLengthBytes = "";

		//loop through 4 bytes of data to determine Password exist or not
		for(int i=0; i<4; i++){

			String oneByteOfImage = Integer.toBinaryString(image[i]);
			passwordLengthBytes += oneByteOfImage.charAt(oneByteOfImage.length()-2);
			passwordLengthBytes += oneByteOfImage.charAt(oneByteOfImage.length()-1);
		}

		int passwordLength = Integer.parseInt(passwordLengthBytes,2);
		if(passwordLength == 0){
			return null;
		}
		else{
			return extracting_Password(image, passwordLength);
		}

	}




	private String extracting_Password(int[] image, int passwordLength){

		String[] passwordBytes = new String[passwordLength];
		offset = 4;
		//loop through each byte of text
		for(int i=0; i<passwordLength; i++){

			passwordBytes[i] = "";
			//loop through each bit within a byte of text
			for(int bit=0; bit<4; bit++, offset++){

				if(image[offset] < 2){
					bit = bit-1; 
					continue;
					
				}
				else{
					String oneByteOfImage = Integer.toBinaryString(image[offset]);
					passwordBytes[i] += oneByteOfImage.charAt(oneByteOfImage.length()-2);
					passwordBytes[i] += oneByteOfImage.charAt(oneByteOfImage.length()-1);
				}
			}
		}

		return int_Into_String(binaryString_Into_int(passwordBytes));
	}




	private int[] binaryString_Into_int(String[] messageBytes){

		int[] message_In_Int = new int[messageBytes.length];

		for(int i=0; i<messageBytes.length; i++){

        	message_In_Int[i] = Integer.parseInt(messageBytes[i],2);//CONVERTING BINARY STRING TO INT
        }
        return message_In_Int;
	}





	private String int_Into_String(int[] message_In_Int){

		String message = "";

		for(int i=0; i<message_In_Int.length; i++){

        	message += Character.toString((char) message_In_Int[i]); //converting int to string
        }
        return message;
	}





	private boolean matching_Password_WithUserInput(String password){

		String enteredPassword;
        enteredPassword = JOptionPane.showInputDialog("Enter Password");

        if(password.equals(enteredPassword)){
        	return true;
        }
        else{
        	JOptionPane.showMessageDialog(null, "WRONG PASSWORD !!","Wrong Password",JOptionPane.ERROR_MESSAGE);
        	int again = JOptionPane.showConfirmDialog(null, "Do you want to enter password agin?", "RETRY",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(again == 0){//0 = yes
                matching_Password_WithUserInput(password);
            }
            else{
                dispose();
                System.exit(0);
            }
            return false;
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