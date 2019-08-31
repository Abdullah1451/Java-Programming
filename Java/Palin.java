public class Palin{
	public static void main(String args[]){
		String s="abcdcba";
		
		int l=s.length();
		int n=0;
		//System.out.println(l);
		
		for(int i=0;i<=(l/2)&& l>=(l/2);i++,l--)
		{
			if(s.charAt(i)==s.charAt(l-1))
			{
				n++;
			}
			else{
				System.out.println("Not pallin");
				System.exit(0);
			}
		}
		if(n==(l/2)+1)
		{
			System.out.println("Yes");
		}
		else
			System.out.println("No");
		
		
		
		
		
	}

}