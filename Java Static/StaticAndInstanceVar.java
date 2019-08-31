class A{
	int i=30;
	static int a=90;	
	public static void main(String args[]){
	}
}


class B{
	static public A a;
	public A a1;
	//static public int c=0;

	B(){
		if(a==null){
			a=new A();
		}
		a1=new A();
	}
	
	public static void main(String ar[]){
		B b = new B();
		
		System.out.println(b.a); 
		System.out.println(b.a1);
		
		B b1 = new B();
		
		System.out.println(b1.a); 
		System.out.println(b1.a1);
		
	}
}