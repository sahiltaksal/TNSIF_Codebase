package singleinheritance;

public class Citizen {
  private String name;
  private String adharno;
  private String address;
  private long phone;
public Citizen() {
	System.out.println("citizen object created");
}
public Citizen(String name, String adharno, String address, long phone) {
	super();
	this.name = name;
	this.adharno = adharno;
	this.address = address;
	this.phone = phone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAdharno() {
	return adharno;
}
public void setAdharno(String adharno) {
	this.adharno = adharno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Citizen [name=" + name + ", adharno=" + adharno + ", address=" + address + ", phone=" + phone + "]";
}

  
  
}
