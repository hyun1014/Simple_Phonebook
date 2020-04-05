package main_pack;
import java.util.TreeMap;
import java.util.Scanner;

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
		int age, year;
		int ch = -1;
		while(ch<0 || ch>3) {
			System.out.println("Select person type:\n1.Company / 2.University / 3.Default / 0.Exit");
			ch = sc.nextInt();
			sc.nextLine();
			if(ch<0 && ch>3)
				System.out.println("Invalid choice.");
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
		System.out.print("Age: ");
		age = sc.nextInt();
		sc.nextLine();
		if(ch==3)
			db.put(name, new Person(name, phoneNum, age));
		else if(ch==1) {
			System.out.print("Department: ");
			dept = sc.nextLine();
			System.out.print("Experience year: ");
			year = sc.nextInt();
			sc.nextLine();
			db.put(name, new Person_com(name, phoneNum, age, dept, year));
		}
		else {
			System.out.print("Department: ");
			dept = sc.nextLine();
			System.out.print("Year: ");
			year = sc.nextInt();
			sc.nextLine();
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
		System.out.println("Do you want to delete info? [Y/N]");
		ch = sc.nextLine().charAt(0);
		System.out.println();
		if(ch=='y'||ch=='Y') {
			db.remove(tar.getName());
			System.out.println("Deleted.");
		}
		else if(ch=='n'||ch=='N')
			System.out.println("Canceled.");
		else
			System.out.println("Invalid choice.");
	}
}
