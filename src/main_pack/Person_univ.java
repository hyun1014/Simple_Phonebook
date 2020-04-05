package main_pack;

public class Person_univ extends Person {
	private String dept;
	private int year;
	
	Person_univ(String name, String phoneNum, int age, String dept, int year){
		super(name, phoneNum, age);
		this.dept = dept;
		this.year = year;
	}
	
	String getDept() {
		return this.dept;
	}
	void setDept(String dept) {
		this.dept = dept;
	}
	int getYear() {
		return this.year;
	}
	void setYear(int year) {
		this.year = year;
	}
	String printType() {
		return "Univ person";
	}
	void printInfo() {
		super.printInfo();
		System.out.println("Department: " + this.dept);
		System.out.println("Year: " + this.year);
	}
}
