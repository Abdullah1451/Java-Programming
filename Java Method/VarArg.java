public class VarArg{
	public static void main(String args[]){
		VarArg o = new VarArg();
		o.myfun(100,112,12,133,45,65);
	}	
		
	public void myfun(int i,int... x){
		System.out.println(x[2]);
		/*System.out.println();	
		for(int m:x)
			System.out.println(m);*/
		
	}	
		
	
}