package hierarchicalinheritance;

public class Student extends Person {
	private String studentclass;
	private float percent;
	public Student() {
		
		System.out.println("student class default");
		studentclass="BE";
		percent=88.8f;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "Student [studentclass=" + studentclass + ", percent=" + percent + ", Personname=" + getPersonname()
				+ ", Personcity=" + getPersoncity() + "]";
	}
	

}
