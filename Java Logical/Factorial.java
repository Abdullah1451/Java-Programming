public class Factorial{
	public int factorial(int n)
	{
    		if(n==0)
			return(1);
		
		else if(n==1)
		{	
			return(1);
		}
		else
			return(n*factorial(n-1));
			
	}

	public static void main(String args[])
	{
    		int n=5;
    		int fact=0;
		Factorial m=new Factorial();  
    		fact=m.factorial(n);
    		System.out.println(fact);
	}
}