package model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import view.Methods;

public class FileReader {
	
	public static ArrayList<Member> memberList = model.MemberList.getMemberList();
	
	
	@SuppressWarnings("static-access")
	public static void loadXML() throws Exception {
		
		File f = new File("./memberList.xml");
		if(f.exists() && !f.isDirectory()) { 
		
	
		File xmlFile = new File("./memberList.xml");
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFile);
		
		NodeList list = document.getElementsByTagName("member");
		
		for(int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				
				String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
				String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
				String personalId = element.getElementsByTagName("personalId").item(0).getTextContent();
				String memberIdStr = element.getElementsByTagName("memberId").item(0).getTextContent();
				int memberId = Integer.parseInt(memberIdStr);
				
				Member member = model.Member.createMemberFromXML(firstName, lastName, personalId, memberId);
			
				NodeList boatList = element.getElementsByTagName("boat");
				
				for(int j = 0; j < boatList.getLength(); j++) {
					Node boatNode = boatList.item(j);
					
					
					if (boatNode.getNodeType() == Node.ELEMENT_NODE) {
						Element boatElement = (Element) boatNode;
						
						String typeStr = boatElement.getElementsByTagName("boatType").item(0).getTextContent();
						String lengthStr = boatElement.getElementsByTagName("boatLength").item(0).getTextContent();
						
						int type = Integer.parseInt(typeStr);
						int length = Integer.parseInt(lengthStr);
						member.addBoat(type, length);
					}
				}
			}
		}
	} 
}


	public static void saveXML() throws Exception {
	
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document document = documentBuilder.newDocument();
		Element element = document.createElement("Members");
	
		document.appendChild(element);

	
			
		for(int i = 0; i < memberList.size(); i++) {
			
			Element member = document.createElement("member");
			element.appendChild(member);
			
			String firstName = memberList.get(i).getFirstName();	
			String lastName = memberList.get(i).getLastName();
			String personalId = memberList.get(i).getPersonalId();
			
			int memberIdInt = memberList.get(i).getMemberId();
			String memberId = Integer.toString(memberIdInt);

			
			Element memberIdElement = document.createElement("memberId");
			memberIdElement.appendChild(document.createTextNode(memberId));
			member.appendChild(memberIdElement);
			
			Element firstNameElement = document.createElement("firstName");
			firstNameElement.appendChild(document.createTextNode(firstName));
			member.appendChild(firstNameElement);
			
			Element lastNameElement = document.createElement("lastName");
			lastNameElement.appendChild(document.createTextNode(lastName));
			member.appendChild(lastNameElement);
			
			Element personalIdElement = document.createElement("personalId");
			personalIdElement.appendChild(document.createTextNode(personalId));
			member.appendChild(personalIdElement);
			
			Element boats = document.createElement("boats");
			member.appendChild(boats);
			
				ArrayList<Boat> boatList = memberList.get(i).getBoats();
		
				
				for(int j = 0; j < boatList.size(); j++) {
					Element boat = document.createElement("boat");
					boats.appendChild(boat);
					
					int boatTypeInt = boatList.get(j).getType();
					String boatType = Integer.toString(boatTypeInt);
					
					int boatLengthInt = boatList.get(j).getLength();
					String boatLength = Integer.toString(boatLengthInt);
					
					Element boatTypeElement = document.createElement("boatType");
					boatTypeElement.appendChild(document.createTextNode(boatType));
					boat.appendChild(boatTypeElement);
					
					Element boatLengthElement = document.createElement("boatLength");
					boatLengthElement.appendChild(document.createTextNode(boatLength));
					boat.appendChild(boatLengthElement);
				}
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult streamResult = new StreamResult(new File("./memberList.xml"));

		transformer.transform(source, streamResult);
		Methods.back();

	}
}
