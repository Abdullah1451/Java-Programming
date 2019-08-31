public class Override{
	static Override2 p = new Override2();
	public static void main(String args[]){
		p.method();
	}
}

class Override2{
	public void method(){
		System.out.println("hello");
	}
	
}








/*class Pchild extends java.io.PrintStream{
	public void println(int r){
		System.out.println(r);
		
	}
	public static void main(String args[]){
		int r=10;
		Pchild out = new Pchild();
		out.println(r);
		System.out.println(33);
}

}*/