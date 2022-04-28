package Models;

public class Comment {
	private String text;
	private String date;
	private String name;
	private String surname;
	
	public Comment() {}
	public Comment(String text, String date, String name, String surname) {
		this.setText(text);
		this.setDate(date);
		this.setName(name);
		this.setSurname(surname);
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}