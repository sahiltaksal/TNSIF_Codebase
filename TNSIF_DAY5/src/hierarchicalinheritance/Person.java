package hierarchicalinheritance;

public class Person {

	private String personname;
	private String personcity;
	public Person() {
		personname="sahil";
		personcity="pune";
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getPersoncity() {
		return personcity;
	}
	public void setPersoncity(String personcity) {
		this.personcity = personcity;
	}
	@Override
	public String toString() {
		return "Person [personname=" + personname + ", personcity=" + personcity + "]";
	}
	
}
