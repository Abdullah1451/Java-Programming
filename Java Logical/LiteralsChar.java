public class LiteralsChar{
	public static void main(String args[]){

		//char i = a;	//error: cannot find symbol ,  symbol: variable a , location: class LiteralsChar

		//char b = "a";	//error: incompatible types: String cannot be converted to char

		//char c = 'ab'; 	//error: not a statement , error: unclosed character literal(for a) , error: unclosed character literal(for b)
		
		char d = 97;	//output = a

		char e = 35536;	//output = ?

		//char f = 65536;	//error: incompatible types: possible lossy conversion from int to char
		
		char g = '\uFFFF';	//output = ?

		System.out.println(d);
		System.out.println(e);
		
		
		
		
			
	}
}