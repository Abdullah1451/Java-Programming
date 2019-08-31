public class Fibonacci{
	public static void main(String args[]){
		int n=20;
		int p=0,f=1;
		System.out.print(p);
		
		for(int i=1;i<=n;i++){
			System.out.print(" ,"+f);
			f=f+p;
			p=f-p;
		}


	}


}