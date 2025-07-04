package static_keyword;

public class Myclass {

	private int section;
	private static int srno;
	
	static {
		srno=1000;
		//Cannot make a static reference to the non-static field section
		//section=101;
		
		System.out.println("-----------within static block");
	}

	public Myclass() {
		System.out.println("-----within default constructor");
		srno++;
		section++;
	}

	@Override
	public String toString() {
		return "Myclass [serial no "+srno+",section=" + section + "]";
	}
	
	static void display() {
		
		//Cannot make a static reference to the non-static field section
		//System.out.println(section);
		
		System.out.println("serial No: "+ srno);
	}
	
}
