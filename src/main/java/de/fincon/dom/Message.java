package de.fincon.dom;

/*
 *  PoJo um den zurückgelieferten JSON String zu deserialisieren
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
