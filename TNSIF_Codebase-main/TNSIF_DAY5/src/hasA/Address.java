package hasA;

public class Address {
 public String steet;
 public  String city;
 public String state;
 public int pincode;
 
 
public Address(String steet, String city, String state, int pincode) {
	super();
	this.steet = steet;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
}

public String getSteet() {
	return steet;
}
public void setSteet(String steet) {
	this.steet = steet;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [steet=" + steet + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
}
}
