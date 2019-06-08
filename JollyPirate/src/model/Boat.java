package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Boat {

	private int m_type;
	private int m_length;
	
	
	public Boat() {
		
	}
	
	public Boat(int type, int length) {
		m_type = type;
		m_length = length;
	}
	
	public static Boat createBoat(int type, int length) {
		Boat b = new Boat(type, length);
		
		return b;
	}
	

	
	public static String getTypeAsString(int type) {
		if(type == 1) {
			return "Sailboat";
		} else if(type == 2) {
			return "MotorSailer";
		} else if(type == 3) {
			return "Kayak/Canoe";
		} else if(type == 4) {
			return "Other";
		}
		return "Boattype not found";
	}
	public int getType() {
		return m_type;
	}
	
	@XmlElement
	public void setType(int type) {
		this.m_type = type;
	}
	
	public int getLength() {
		return m_length;
	}

	@XmlElement
	public void setLength(int m_length) {
		this.m_length = m_length;
	}
	
}

