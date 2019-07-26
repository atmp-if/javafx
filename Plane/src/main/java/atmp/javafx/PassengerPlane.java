package atmp.javafx;

public class PassengerPlane extends Plane{
	int maxPassengers;
	public PassengerPlane(String n, int s, int w, int mP) {
		super(n, s, w);
		maxPassengers = mP;
	}
	@Override
	String carry() {
		System.out.println(super.name + " Перевозить пасажирів, максимальна кількість " + maxPassengers);
		return super.name + " Перевозить пасажирів, \n максимальна кількість " + maxPassengers + "\n";
	}
	
	@Override
	String getPhoto() {
		return "/Ukr_pas.jpg";
	}
}
