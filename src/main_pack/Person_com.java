package main_pack;

public class Person_com extends Person{
	private String dept;
	private int exp;

	Person_com(String name, String phoneNum, int age, String dept, int exp){
		super(name, phoneNum, age);
		this.dept = dept;
		this.exp = exp;
	}
	
	String getDept() {
		return this.dept;
	}
	void setDept(String Dept) {
		this.dept = Dept;
	}
	int getExp() {
		return this.exp;
	}
	void setExp(int exp) {
		this.exp = exp;
	}
	void expUp() {
		this.exp++;
	}
	void expUp(int year) {
		this.exp += year;
	}
	String printType() {
		return "Company coworker";
	}
	void printInfo() {
		super.printInfo();
		System.out.println("Department: " + this.dept);
		System.out.println("Work experience: " + this.exp);
	}
}
