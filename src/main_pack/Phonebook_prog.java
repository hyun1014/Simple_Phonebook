package main_pack;
import java.util.*;

public class Phonebook_prog {
	static TreeMap<String, Person> db = new TreeMap<>();
	static boolean run = true;
	static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pb_infomanager mg = Pb_infomanager.getInstance(sc);
		int ch = 0;
		mg.setDB(db);
		System.out.println("Phonebook program (v0.1)\n==========================================");
		while(run) {
			System.out.println("Input choice.\n--------------------------");
			System.out.print("1.Input data\n2.Search data\n3.Delete date\n0.Exit\nChoice: ");
			try {
				ch = sc.nextInt();
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid value. Only number is valid.\n");
				sc.nextLine();
				continue;
			}
			switch(ch) {
			case 1:
				mg.newInfo();
				break;
			case 2:
				mg.searchInfo();
				break;
			case 3:
				mg.deleteInfo();
				break;
			case 0:
				run = false;
				break;
			default:
				System.out.println("Invalid choice.");
			}
			System.out.println();
		}
		System.out.println("Program terminated.");
	}
}
