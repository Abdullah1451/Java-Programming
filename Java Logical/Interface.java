
//Showing Intreface And Mutiple Inheritance Using Interface In Java. Multiple Inheritance Is Not Possible Except Interface In Java.

interface Person{
	void name();
}

interface Admission{
	void rank();
}

interface Student extends Person,Admission{
	void roll();
}



public class Interface implements Student{

	public void name(){
		System.out.println("Name");
	}

	public void rank(){
		System.out.println("rank");
	}

	public void roll(){
		System.out.println("roll");
	}

	public static void main(String[] args) {
		Interface i = new Interface();

		i.roll();
	}
}