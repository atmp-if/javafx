package application;
import java.io.File;

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
		File file = new File(this.getPhoto());
		return new Image(file.toURI().toString());
	}
}
