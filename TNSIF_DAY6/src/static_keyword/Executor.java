package static_keyword;

public class Executor {

	public static void main(String[] args) {
		
		Myclass.display();
		
		System.out.println();
		
		Myclass o1=new Myclass();
		System.out.println(o1);
		
		Myclass.display();

		System.out.println();
		
		Myclass o2=new Myclass();
		System.out.println(o2);
		
	}

}
