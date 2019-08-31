import java.lang.*;

public class Armstrong{
	public static void main(String args[]){
		int n=153;
		int t=n;
		double temp=0,sum=0;
		int l=(int)(Math.log10(n)+1);
		for(int i=0;i<l;i++)
		{
			temp=t%10;
			temp=Math.pow(temp,3);
			sum+=temp;
			t=t/10;
		}
		if(n==sum)
			System.out.println("Yes");
		else
			System.out.println("Not");
	}
}