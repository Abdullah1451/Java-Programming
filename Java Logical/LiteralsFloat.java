public class LiteralsFloat{
	public static void main(String args[]){

		//float i = 10.90f; //  CE : Possible Loss Of Conversion From Double to float
		float i =4/3; // 1.0
		int a = 77;

		double octalValue = 011.54;  // 11.54
		//double hexValue = 0x11.54;  //  malformed floating point literal
		//double octalvalue3 = 089;    //  integer number too large
		double octalValue2 = 077;  // 63.0
		System.out.println(octalValue2);
	}
}