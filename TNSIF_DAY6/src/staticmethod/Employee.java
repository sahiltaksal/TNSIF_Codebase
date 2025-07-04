package staticmethod;

import java.security.PrivateKey;

public class Employee {

	//Declare instance variable
	private String name;
	private int id;
	static String companyname="DYPCOE";
	public Employee(String name, int id) {
	
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ",company name :"+companyname+"]";
	}

}
