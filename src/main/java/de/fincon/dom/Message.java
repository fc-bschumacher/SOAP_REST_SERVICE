package de.fincon.dom;

/*
 *  PoJo to deserialize the JSON String given back from
 */
public class Message {
	
	private int ID;
	private String text;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
