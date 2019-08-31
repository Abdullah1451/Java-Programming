class Student{
	int rollno;
     	String name;
     	static String college = "ITS";

    	static void change(){
     		college = "BBDIT";
		
     	}

     	Student(int r, String n){
     		rollno = r;
     		name = n;
     	}

	void display(){System.out.println(rollno+" "+name+" "+college);}

	public static void main(String args[]){

    		change();

    		//creating objects
    		Student s1 = new Student(111,"Karan");

		Student s2 = new Student(222,"Aryan");
		Student s3 = new Student(333,"Sonoo");
		
    		//calling display method
    		s1.display();
    		s2.display();
    		s3.display();
	}
}




//public class TestStaticMethod{}
