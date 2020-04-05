import java.util.ArrayList;
import java.util.List;

	public class ArrayMani{

		public static void main (String arg[]){
		ArrayList<String> aList = new ArrayList<String>();
		aList.add(0, "App123le");
		aList.add(1, "Mango");
		aList.add(2, "Banana");
		aList.add(1, "Melon");
		aList.add(5, "Guava");

		for(String s : aList){
			int length = s.length();

			System.out.println(s);
		}
	}

	}