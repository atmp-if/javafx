package atmp.javafx;

public class Airfreighter extends Plane{
	int maxCargo;
	public Airfreighter (String n, int s, int w, int mC) {
		super(n, s, w);
		maxCargo = mC;
	}
	@Override
	String carry() {
		System.out.println(super.name + " Перевозить вантажі, максимальна вага " + maxCargo);
		return super.name + " Перевозить вантажі, \n максимальна вага " + maxCargo + "\n";
	}

	@Override
	String getPhoto() {
		return "/AH-225.jpg";
	}
}
