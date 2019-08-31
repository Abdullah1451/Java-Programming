public class VarArg2{
	public static void main(String args[]){
		VarArg2 o = new VarArg2();
		o.myfun(100);
		o.myfun(1230,34);
	}


	public void myfun(int... x){
		System.out.println(x[0]);
		
	}	
			
	public void myfun(int[] i){
		System.out.println(i[0]);
		
	}		
}