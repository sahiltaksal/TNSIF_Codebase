package com.Encapsulation;

public class OopsConcept {

	private String name;
	private int age;
	private int serialnum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	@Override
	public String toString() {
		return "OopsConcept [name=" + name + ", age=" + age + ", serialnum=" + serialnum + "]";
	}
	
}
