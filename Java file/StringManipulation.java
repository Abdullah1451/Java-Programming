import java.io.*;
import java .util.*;

public class StringManipulation{
	public static void main(String args[]){
		try{
			File f=new File("Java-If.txt");
			File f2=new File("Java-If2.txt");
			BufferedReader br=new BufferedReader(new FileReader(f));
			BufferedWriter bw = new BufferedWriter(new FileWriter(f2,true));

			ArrayList<String> aList = new ArrayList<String>();

	      	String line;
	      	int i=0,length=0,k=-1;
	      	

	      	while ((line = br.readLine()) != null){
	      		aList.add(i,line);

	      		length = line.length();	

	      		for(int c=0; c<length; c++){
	      			
	      			if(line.charAt(c) == 'i' && line.charAt(c+1) == 'f' && line.charAt(c+2) == '(' && c < 5){
	      				aList.add(i+1,"{");

	      				i++;
	      				k = i+2;
	      			}
	        	}
	     		
	     		if(i == k-1){
	     			aList.add(k,"}");
	     		}
	        	i++;
	      	}
	      	for(String s : aList){
	      		bw.write(s);
	      		System.out.println("asdd");
	      		bw.newLine();
	      	}

	      	bw.close();
	      	br.close();

		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found");	
		}
		catch(Exception e){
			System.out.println(e);	
		}



	}
}






/*import java.io.*;

public class WriteFile{
	public static void main(String args[]){
		try{
			File ob = new File("D:\\Abdullah Working\\Java\\Java file\\MyFile2.txt");
			if(ob.exists()){
				PrintWriter p = new PrintWriter(ob);
				p.println("Abdullah        7838   GNDIT");
				p.println("Mohd.Azhar      7838   SANT");
				p.println("Mohd.Ashhar     7053   GGIP");
				p.println("Mohd.Anas       9560   NIEC");
				p.close();
				System.out.println("done");
			}
			else{
				System.out.println("n");
			}
		}
		catch(FileNotFoundException e){
			System.out.println("sasddd");	
		}
	}
}*/