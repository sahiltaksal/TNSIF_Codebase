package hasA;

public class Exeuctor {

	public static void main(String[] args) {
		Address address=new Address("pune","pune","maharashtra",121);
		Person person=new Person("sahil", address);
		person.displayinfo(address);
		System.out.println(person);
	}

}
