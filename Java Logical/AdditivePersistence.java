import java.lang.*;
import java.util.*;

public class AdditivePersistence{
	public static void main(String args[]){

		int sum=0,sum2=0;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter The Number : ");
		int number = sc.nextInt();

		int length = (int)(Math.log10(number)+1);

		for(int i=0,temp=0,t=number; i<length; i++){

			temp=t%10;

			sum+=temp;
			
			t=t/10;
		}

		int length2 = (int)(Math.log10(sum)+1);

		for(int i=0,temp=0,t=sum; i<length2; i++){

			temp=t%10;

			sum2+=temp;
			
			t=t/10;
		}

		System.out.println("Additive Persistence is :: "+sum2);
	}
}