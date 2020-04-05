package main_pack;

//Base type for information
public class Person {
	private String name;
	private String phoneNum;
	private int age;
	
	public Person(String name, String phoneNum, int age){
		this.name = name;
		this.phoneNum = phoneNum;
		this.age = age;
	}
	
	String getName() {
		return this.name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getNum() {
		return this.phoneNum;
	}
	void setNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	int getAge() {
		return this.age;
	}
	void setAge(int age) {
		this.age = age;
	}
	String printType() {
		return "Default";
	}
	void printInfo() {
		System.out.println("Type - " + this.printType());
		System.out.println("Name: " + this.name);
		System.out.println("Phone number: " + this.phoneNum);
		System.out.println("Age: " + this.age);
	}
}