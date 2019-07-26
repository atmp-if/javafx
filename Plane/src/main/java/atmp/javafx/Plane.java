package atmp.javafx;

import javafx.scene.image.Image;

public abstract class Plane {
	String name;
	int speed, width;
	public Plane(String n, int s, int w) {
		name = n;
		speed = s;
		width = w;
	}
	
	abstract String carry ();
	abstract String getPhoto();
	Image getImage() {
		return new Image(getClass().getResourceAsStream(this.getPhoto()));
	}
}
