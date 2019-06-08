package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Boat;
import model.Member;

public class Methods {
	
	public static ArrayList<Member> memberList = model.MemberList.getMemberList();


	/* ------------- MEMBERS ---------------*/
	public static void createMember() {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter your firstname: ");
			String firstName = sc.next();
		
			System.out.println("Enter your lastname: ");
			String lastName = sc.next();
			
			System.out.println("Enter your personal ID: ");
			String personalId = sc.next();
			
			model.Member.createMember(firstName, lastName, personalId);

			Console.start();
			
			sc.close();
	}
	
	public static void deleteMember() {		
		isMemberListEmpty("There is no members to delete");

		startOfMethod("Which member would you like to delete?");

		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		if(userInput > memberList.size()) {
			deleteMember();
		}
		
		model.MemberList.deleteMember(userInput-1);
		Console.start();
		sc.close();
		
		
	}
	public static void changeMember() {
		
		isMemberListEmpty("There is no members to show");
		
		startOfMethod("Which member would you like to change?");
		
		Scanner sc = new Scanner(System.in);
		int numberToChange = sc.nextInt()-1;
		
		if(numberToChange > memberList.size()) {
			changeMember();
		}
		
		model.Member member = memberList.get(numberToChange);
		
		System.out.println("Changing " + member.getFirstName() + " " + member.getLastName());
		
		System.out.println("Enter your firstname: ");
		String firstName = sc.next();
	
		System.out.println("Enter your lastname: ");
		String lastName = sc.next();
		
		System.out.println("Enter your personal ID: ");
		String personalId = sc.next();
		
		model.Member.changeMember(member, firstName, lastName, personalId);
		
		Console.start();

		sc.close();
		
	}

	public static void viewMember() {
		
		isMemberListEmpty("There is no members to show");

		startOfMethod("Which member would you like to show?");
		
		
		Scanner sc = new Scanner(System.in);
		
		int userInput = sc.nextInt();
		
		if(userInput > memberList.size()) {
			viewMember();
		}
		
		model.Member member = memberList.get(userInput-1);
		
		System.out.println("Name: " + member.getFirstName() + " " + member.getLastName());
		System.out.println("Personal ID: " + member.getPersonalId());
		System.out.println("Member ID: " + member.getMemberId());
		ArrayList<Boat> boats = member.getBoats();
		
		System.out.println("Boats: ");
		
		for(int j = 0; j < boats.size(); j++) {
			System.out.println(j+1 + ". Type: " + model.Boat.getTypeAsString(boats.get(j).getType()) + ", Length: " + boats.get(j).getLength());
			}
			System.out.println();
		
		back();
			
		sc.close();
	}
	
	
	/* ------------- LISTS ---------------*/
	public static void cleanList() {
		
		for(int i = 0; i < memberList.size(); i++) {
			System.out.println(i+1 + ". " + memberList.get(i).getFirstName() + " " + memberList.get(i).getLastName());
		}
	}
	
	public static void showCompactList() {
		
		isMemberListEmpty("There is no members to show");

		for(int i = 0; i < memberList.size(); i++) {
			Member current = memberList.get(i);
			System.out.println(i+1 + ". " + current.getFirstName() + " " + current.getLastName());
			System.out.println("Member ID: " + current.getMemberId());
			
			ArrayList<Boat> boats = current.getBoats();
			System.out.println("Number of boats: " + boats.size());
			System.out.println();
		}
		back();
	}

	public static void showVerboseList() {

		isMemberListEmpty("There is no members to show");

		for(int i = 0; i < memberList.size(); i++) {
			Member current = memberList.get(i);
			System.out.println("--- " + current.getFirstName() + " " + current.getLastName() + " ---");
			System.out.println("Personal ID: " + current.getPersonalId());
			System.out.println("Member ID: " + current.getMemberId());
			
			ArrayList<Boat> boats = current.getBoats();
			
			System.out.println("Boats: ");
			
			for(int j = 0; j < boats.size(); j++) {
				System.out.println(j+1 + ". Type: " +  model.Boat.getTypeAsString(boats.get(j).getType()) + ", Length: " + boats.get(j).getLength());
				}
			System.out.println();
			}
			back();
		}
	
	
	/* ------------- BOATS ---------------*/

	public static void addBoat() {
		isMemberListEmpty("Add a member first");

		startOfMethod("Who want's to add a new boat?");
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
				
		model.Member member = memberList.get(userInput-1); 
		
		System.out.println("What type of boat is it ?");
		System.out.println("1. " + model.Boat.getTypeAsString(1));
		System.out.println("2. " + model.Boat.getTypeAsString(2));
		System.out.println("3. " + model.Boat.getTypeAsString(3));
		System.out.println("4. " + model.Boat.getTypeAsString(4));

		int type = sc.nextInt();
		
		System.out.println("How long is the boat?(cm)");
		
		int length = 0;
		if(sc.hasNextInt()) {
		    length = sc.nextInt();
		} else {
			System.out.println("Please enter length as an integer");
			addBoat();
		}
			
		member.addBoat(type, length);
		
		back();
		sc.close();
	}
	
	public static void changeBoat() {
		isMemberListEmpty("Add a member first");

		startOfMethod("Who want's to change a boat?");
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		if(userInput > memberList.size()) {
			changeBoat();
		}
				
		model.Member member = memberList.get(userInput-1);
		
		ArrayList<Boat> boats = member.getBoats();
		
		if(boats.isEmpty()) {
			System.out.println("There is no boats to change");
			back();
		}

		System.out.println("which boat do you want to change?");
		for(int i = 0; i < boats.size(); i++) {
			System.out.println(i+1 + ". Type: " + model.Boat.getTypeAsString(boats.get(i).getType()) + ", Length: " + boats.get(i).getLength());
		}
		
		int boatToChange = sc.nextInt();
		if(boatToChange > boats.size()) {
			changeBoat();
		}

		System.out.println("What type of boat is it ?");
		System.out.println("1. " + model.Boat.getTypeAsString(1));
		System.out.println("2. " + model.Boat.getTypeAsString(2));
		System.out.println("3. " + model.Boat.getTypeAsString(3));
		System.out.println("4. " + model.Boat.getTypeAsString(4));

		int type = sc.nextInt();
		
		System.out.println("how long is it?(cm)");
		int length = 0;
		if(sc.hasNextInt()) {
		    length = sc.nextInt();
		} else {
			System.out.println("Please enter length as an integer");
			changeBoat();
		}		
		
		model.Member.changeBoat(member, boatToChange, type, length );
		back();
		sc.close();
		

	}
	
	public static void deleteBoat() {
		isMemberListEmpty("Add a member first");

		startOfMethod("Who want's to delete a boat?");
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
				
		if(userInput > memberList.size()) {
			deleteBoat();
		}
		model.Member member = memberList.get(userInput-1);
		
		ArrayList<Boat> boats = member.getBoats();
		
		if(boats.isEmpty()) {
			System.out.println("There is no boats to delete");
			back();
		}
		
		System.out.println("which boat do you want to delete?");
		for(int i = 0; i < boats.size(); i++) {
			System.out.println(i+1 + ". Type: " + model.Boat.getTypeAsString(boats.get(i).getType()) + ", Length: " + boats.get(i).getLength());
		}
		
		int boatToDelete = sc.nextInt();
		if(boatToDelete > boats.size()) {
			deleteBoat();
		}
		model.Member.deleteBoat(member, boatToDelete);
		back();
		sc.close();
		
			}
	
	/* ------------- FUNCTIONAL---------------*/
	public static void startOfMethod(String str) {
		System.out.println(str);
		cleanList();
	}
	
	public static boolean isMemberListEmpty(String str) {
		ArrayList<Member> memberList = model.MemberList.getMemberList();
		
		if(memberList.isEmpty()) {
			System.out.println(str);
			back();
		}
		return false;
	}
	
	public static void back() {
		System.out.println("-----------------------");
		System.out.println("Press 1 to return to main menu");
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		if(userInput == 1) {
			Console.start();
		}	else {
			back();
		}	
		sc.close();		
	}
	
}
