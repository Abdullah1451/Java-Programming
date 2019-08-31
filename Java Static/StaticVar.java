class A{
	static int a=90;	
	public static void main(String args[]){
		//B.m1();
		System.out.println(a);
	}
}


class B{
	static public A a;
	
	public static void m1(){
		a.a=A.a+40;
		System.out.println(a);
		Child.run2();
	}
	public static void main(String args[]){
		//System.out.println(A.main2());
	}
}