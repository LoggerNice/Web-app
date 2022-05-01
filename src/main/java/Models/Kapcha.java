package Models;

public class Kapcha {
	
	private int a;
	private int b;
	
	public Kapcha() {
		a = (int) (Math.random() * 6) + 2;
		b = (int) (Math.random() * 6) + 2;
	}
	
	public String getMath() {
		return a + " + " + b;
	}
	
	public int getResult() {
		return a + b;
	}
}