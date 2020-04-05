import java.lang.Math;

public class Quadratic{

	int a,b,c;
	public Quadratic(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void roots(){
		double sqd,x,x1;
		int d;

		d = b*b - 4*a*c;
		sqd = Math.sqrt(d);

		x = (-b + sqd)/(2*a);
		x1 = (-b - sqd)/(2*a);

		System.out.println(x);
		System.out.println(x1);

	}

	public static void main(String ar[]) {
		Quadratic qd = new Quadratic(3,2,-1);
		qd.roots();
	}
}