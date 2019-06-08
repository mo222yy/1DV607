package model;

import java.util.ArrayList;

public class MemberList {

	static ArrayList<Member> memberList = new ArrayList<Member>();

	public MemberList() {
		
	}

	public void setMemberList(ArrayList<Member> memberList) {
		MemberList.memberList = memberList;
	}
	


	public static ArrayList<Member> getMemberList() {
		return memberList;
	}
	
	public static void addMember(Member m) {
		memberList.add(m);
		
	}
	
	public static void deleteMember(int index) {
		memberList.remove(index);
	}
	
	public static int getSize() {
		int size = 0;
		for(int i = 0; i < memberList.size(); i++) {
			size++;
		}
		return size;
	}

	
}
