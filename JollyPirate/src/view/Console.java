package view;

import java.util.Scanner;



public class Console {
public static void main(String[] args) {
		
		
		try {
			model.FileReader.loadXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start();
	
		
		}	


	public static void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?");
		
		System.out.println("1. Create a new member");
		System.out.println("2. Change a member");
		System.out.println("3. View a specific member");
		System.out.println("4. Delete a member");
		System.out.println("5. Add a boat");
		System.out.println("6. Delete a boat");
		System.out.println("7. Change a boat");
		System.out.println("8. Show members(compact list)");
		System.out.println("9. Show members(verbose list)");
		System.out.println("10. Exit and save");





		int choice = sc.nextInt();
		
		if(choice == 1) {
			Methods.createMember();
		} else if(choice == 2) {
			Methods.changeMember();
		}
		else if(choice == 3) {
			Methods.viewMember();
		} else if(choice == 4) {
			Methods.deleteMember();
		} else if(choice == 5) {
			Methods.addBoat();
		} else if(choice == 6) {
			Methods.deleteBoat();
		} else if(choice == 7) {
			Methods.changeBoat();
		} else if(choice == 8) {
			Methods.showCompactList();
		} else if(choice == 9) {
			Methods.showVerboseList();
		} else if(choice == 10) {
			try {
				model.FileReader.saveXML();
			} catch(Exception e ) {
				e.printStackTrace();
			}
		}
		
		else {
			start();
		}
		sc.close();
	}
	
	
}
