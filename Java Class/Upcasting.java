class UpcastingParent{
	public static void run2(){
		System.out.println("parent");
	}
	public static void main(String args[]){
		int a=23;
		System.out.print(a);
		Parent p = new Child();
		p.run2();
	}
	
}

class UpcastingChild extends UpcastingParent{
	public static void run2(){
		System.out.println("child");
	}
}


class UpcastingNoRelation{
	public void run(){
		System.out.println("parent");
	}
}