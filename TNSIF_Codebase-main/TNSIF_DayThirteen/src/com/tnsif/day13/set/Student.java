package com.tnsif.day13.set;

public class Student {
	
	private int sId;
	private String sName;
	private Double per;
	public Student() {
		
	}
	public Student(int sId, String sName, Double per) {
		
		this.sId = sId;
		this.sName = sName;
		this.per = per;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Double getPer() {
		return per;
	}
	public void setPer(Double per) {
		this.per = per;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", per=" + per + "]";
	}

	
	
}
