package model;

import java.util.ArrayList;


public class Member{
	
	private String m_firstName;
	private String m_lastName;
	private String m_personalId;
	private int m_memberId;
	private ArrayList<Boat> m_boats;
	
	
	public Member(String firstName, String lastName, String personalId, int memberId, ArrayList<Boat> boats ) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.m_personalId = personalId;
		this.m_memberId = memberId;
		this.m_boats = boats;
	}
	
	public String getFirstName() {
		return m_firstName;
	}

	public void setFirstName(String m_firstName) {
		this.m_firstName = m_firstName;
	}


	public String getLastName() {
		return m_lastName;
	}

	public void setLastName(String m_lastName) {
		this.m_lastName = m_lastName;
	}


	public String getPersonalId() {
		return m_personalId;
	}

	public void setPersonalId(String m_personalId) {
		this.m_personalId = m_personalId;
	}


	public int getMemberId() {
		return m_memberId;
	}

	public void setMemberId(int m_memberId) {
		this.m_memberId = m_memberId;
	}


	public ArrayList<Boat> getBoats() {
		return m_boats;
	}

	public void setBoats(ArrayList<Boat> m_boats) {
		this.m_boats = m_boats;
	}

	public static Member createMember(String firstName, String lastName, String personalId) {
		ArrayList<Boat> boats = new ArrayList<Boat>();
		int memberId;
		
		if(MemberList.memberList.size() == 0) {
			memberId = 1;
		} else {
			memberId = MemberList.memberList.get(MemberList.getSize()-1).getMemberId() + 1;
		}
		
		Member m = new Member(firstName, lastName, personalId, memberId, boats );
		MemberList.addMember(m);
		
		return m;
	}
	
	public static Member createMemberFromXML(String firstName, String lastName, String personalId, int memberId) {
		ArrayList<Boat> boats = new ArrayList<Boat>();
		
		Member m = new Member(firstName, lastName, personalId, memberId, boats );
		MemberList.addMember(m);
		
		return m;	}
	
	public static void changeMember(Member member, String firstName, String lastName, String personalId) {
		member.m_firstName = firstName;
		member.m_lastName = lastName;
		member.m_personalId = personalId;
	}
	
	
	public void addBoat(int type, int length) {
		Boat boat = new Boat(type, length);
		this.m_boats.add(boat);		
	}
	
	public static void deleteBoat(Member member, int index) {
		ArrayList<Boat> boats = member.getBoats();
		boats.remove(index-1);
	}
	
	public static void changeBoat(Member member,int boatToChange, int type, int length) {
		ArrayList<Boat> boats = member.getBoats();
		Boat boat = boats.get(boatToChange-1);
		boat.setType(type);
		boat.setLength(length);

	}

}
