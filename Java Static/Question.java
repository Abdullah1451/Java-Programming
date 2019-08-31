class A{

	int a=10;
	static int b=20;
	
	public static void main(String args[]){
		A a=new A();
		a.a+=10;
		a.b+=10;
		System.out.println(a.a);
		System.out.println(a.b);
		A b =new A();
		b.a+=10;
		b.b+=10;

		System.out.println(b.a);
		System.out.println(b.b);
	}
}