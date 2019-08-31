public abstract class Concatenation2{//abstract class cannot instantiated means cannot make object compiler will give error
	
	public abstract void t();

	public static void main(String args[]){
		
		//Concatenation2 cc = new Concatenation2();  // instantiation
		String a="Abdullah";
		int b=10;
		int c=20;
		int d=30;
		System.out.println(b+c+d+a);
		System.out.println(b+c+a+d);
		System.out.println(a+b+c+d);
		System.out.println(b+a+(c-d));
		
	}

}