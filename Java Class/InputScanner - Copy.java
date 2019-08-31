import java.util.Scanner;

public class InputScanner{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name ");
		String name=sc.next();
		
		System.out.println("Enter Yr Name ");
		String name2=sc.next();

		System.out.println("Hello "+name2+" and "+name);
		System.out.println("Enter prices ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println(a);
	}
}

/*
//System.out.println("Hello "+name);

		System.out.println("Enter Yr Name ");
		String name2=sc.nextLine();*/