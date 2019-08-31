public class Operators{
	public static void main(String args[]){
		int i=10;
		boolean a=true,b=false;
		int j=10;

		i++;
		System.out.println("i++ Expected = 11  "+i);

		++i;
		System.out.println("++i Expected = 12  "+i);

		i--;
		System.out.println("i-- Expected = 11  "+i);

		--i;
		System.out.println("--i Expected = 10  "+i);

		j = j+j;
		System.out.println("j = j+j Expected = 20  "+j);

		j=j-10;
		System.out.println("j=j-10 Expected = 10  "+j);

		i=i*i;
		System.out.println("i=i*i Expected = 100  "+i);

		i=i/i;
		System.out.println("i=i/i Expected = 1  "+i);

		i*=100;
		System.out.println("i*=100 Expected = 100  "+i);

		i/=10;
		System.out.println("i/=10 Expected = 10  "+i);

		i+=i;
		System.out.println("i+=i Expected = 20  "+i);

		i-=10;
		System.out.println("i-=10 Expected = 10  "+i);

		i=20;
		System.out.println("i=20 Expected = 20  "+i);

		j=9%7;
		System.out.println("j=9%7 Expected = 2  "+j);

		System.out.println("i%j Expected = 12  "+(i%j));

		System.out.println("~i Expected = don't know  "+(~i));

		System.out.println("!a Expected = False  "+(!a));

		i=2147483647;
		i=i<<1;
		System.out.println("i=10,,,, i=i<<2 Expected = 40  "+i);

		i=i>>2;
		System.out.println("i=i>>2 Expected = 10  "+i);

		i=i>>>2;
		System.out.println("i=i>>>2 Expected = dont know  "+i);

		System.out.println("a&&b Expected = false  "+(a&&b));

		System.out.println("a||b Expected = true  "+(a||b));

		System.out.println("a&b Expected = false  "+(a&b));

		System.out.println("a|b Expected = true  "+(a|b));

		System.out.println("a^b Expected = false  "+(a^b));

		b&=a;
		System.out.println("b&=a Expected = false  "+b);

		a|=b;
		System.out.println("a|=b Expected = true  "+a);

		b^=a;
		System.out.println("b^=a Expected = false  "+b);

		i=10;
		j=20;
		String k=(i<j)?"true":"false";
		System.out.println("i=10,,,,j=20,,,, String k=(i<j)?true:false Expected = true  "+k);

		i<<=2;
		System.out.println("i<<=2 Expected = 40   "+i);

		i>>=2;
		System.out.println("i>>=2 Expected = 10  "+i);

		j>>>=2;
		System.out.println("j>>>=2 Expected = dont know  "+j);

		i=10;
		j=20;
		System.out.println("i=10,,,,j=20,,,, i==j Expected = false  "+(i==j));

		System.out.println("i!=j Expected = true  "+(i!=j));

		System.out.println("i<j Expected = true  "+(i<j));

		System.out.println("i>j Expected = false  "+(i>j));

		System.out.println("i<=j Expected = true  "+(i<=j));

		System.out.println("i>=j Expected = false  "+(i>=j));
		
		
		
	}
}