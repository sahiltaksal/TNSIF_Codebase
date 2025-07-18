package hierarchicalinheritance;

public class Employee extends Person {
private int empid;
private float salary;
private String dept;
public Employee() {
	empid=101;
	salary=5000.0f;
	dept="comp";
	
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", salary=" + salary + ", dept=" + dept + ", Personname=" + getPersonname()
			+ ", Personcity=" + getPersoncity() + "]";
}
	
}
