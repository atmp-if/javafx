package atmp.javafx;

import java.io.Serializable;

public class Owner implements Serializable{
	String name = "невідомий";
	public Owner(String name) {
		if (!name.equals("")) this.name = name;
	}
	
	@Override
	public String toString() {
		return "\n        Власник " + name;
	}
}
