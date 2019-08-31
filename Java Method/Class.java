public class Class{
	int x;
	public void myfun(){
		Class a=new Class();
		Class b=new Class();
		a.x=5;
		b.x=x+5;
		System.out.println(a.x);
		System.out.println(b.x);
	}
	
	public static void main(String args[]){
		Class c=new Class();
		
		c.myfun();
		
		
		
	}
}