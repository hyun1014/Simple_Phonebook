package main_pack;
import java.util.*;

public class Pb_infomanager {
	static Pb_infomanager m = null;
	TreeMap<String, Person> db = null;
	Scanner sc;
	
	private Pb_infomanager(Scanner sc){
		System.out.println("Manager loaded.");
		this.sc = sc;
	}
	static Pb_infomanager getInstance(Scanner sc) {
		if(m==null)
			m = new Pb_infomanager(sc);
		return m;
	}
	
	void setDB(TreeMap<String, Person> db) {
		this.db = db;
	}
	void newInfo() {
		String name, phoneNum, dept;
		int age = -1, year = -1;
		int ch = -1;
		while(ch<0 || ch>3) {
			System.out.println("Select person type:\n1.Company / 2.University / 3.Default / 0.Exit");
			try {
				ch = sc.nextInt();
				sc.nextLine();
				if(ch<0 || ch>3)
					System.out.println("Invalid choice.\n");
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input. Only number is valid.\n");
				sc.nextLine();
				ch = -1;
			}
		}
		if(ch==0) {
			System.out.println("Canceled.");
			return;
		}
		System.out.println("Type - " + ((ch==1) ? "Company" : ((ch==2) ? "University" : "Default")));
		System.out.print("Name: ");
		name = sc.nextLine();
		System.out.print("Phone num: ");
		phoneNum = sc.nextLine();
		while(age<0) {
			try {
				System.out.print("Age: ");
				age = sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input. Only number is valid.");
				age = -1;
			}
			finally {
				sc.nextLine();
			}
			if(age<0)
				System.out.println("Invalid value.");
		}
		if(ch==3)
			db.put(name, new Person(name, phoneNum, age));
		else if(ch==1) {
			System.out.print("Department: ");
			dept = sc.nextLine();
			while(year<0) {
				try {
					System.out.print("Experience year: ");
					year = sc.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid input. Only number is valid.");
					year = -1;
				}
				finally {
					sc.nextLine();
				}
				if(year<0)
					System.out.println("Invalid value.");
			}
			db.put(name, new Person_com(name, phoneNum, age, dept, year));
		}
		else {
			System.out.print("Department: ");
			dept = sc.nextLine();
			while(year<0) {
				try {
					System.out.print("Year: ");
					year = sc.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid input. Only number is valid.");
					year = -1;
				}
				finally {
					sc.nextLine();
				}
			}
			db.put(name, new Person_univ(name, phoneNum, age, dept, year));
		}
		System.out.println("Info created.");
	}
	Person searchInfo() {
		Person tar = null;
		String name;
		boolean flag;
		System.out.print("Input name: ");
		name = sc.nextLine();
		flag = db.containsKey(name);
		System.out.println();
		if(!flag) {
			System.out.println("No matching info.");
			return tar;
		}
		tar = db.get(name);
		System.out.println("Matching info is found.\n---------------------------------");
		tar.printInfo();
		return tar;
	}
	void deleteInfo() {
		char ch;
		Person tar = searchInfo();
		if(tar==null)
			return;
		while(true) {
			System.out.println("Do you want to delete info? [Y/N]");
			ch = sc.nextLine().charAt(0);
			System.out.println();
			if(ch=='y'||ch=='Y') {
				db.remove(tar.getName());
				System.out.println("Deleted.");
				break;
			}
			else if(ch=='n'||ch=='N') {
				System.out.println("Canceled.");
				break;
			}
			else
				System.out.println("Invalid choice.");
		}
		
	}
}
