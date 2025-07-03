package singleinheritance;

//child class
public class Student extends Citizen {
 
 private int rollno;
 private String collegename;
 
 //non para constructor
public Student() {
	super();
}

//parametrized constructor
public Student(int rollno, String collegename,String name, String adharno, String address, long phone) {
	super( name,  adharno,  address,  phone);
	this.rollno = rollno;
	this.collegename = collegename;
}

public int getRollno() {
	return rollno;
}

public void setRollno(int rollno) {
	this.rollno = rollno;
}

public String getCollegename() {
	return collegename;
}

public void setCollegename(String collegename) {
	this.collegename = collegename;
}

@Override
public String toString() {
	return "Student [rollno=" + rollno + ", collegename=" + collegename + ", getName()=" + getName() + ", getAdharno()="
			+ getAdharno() + ", getAddress()=" + getAddress() + ", getPhone()=" + getPhone() + "]";
}
 
 
}
