package atmp.javafx;

public class Main {

	public static void main(String[] args) {
		double width1 = 50, height1 = 20, depth1 = 40;
		Aquarium aquarium1 = new Aquarium(width1, height1, depth1);
		Aquarium aquarium2 = new Aquarium(55.0, 35.0, 28.0);
		Aquarium aquarium3 = new Aquarium(57.0, 38.4, 35.0);
		Aquarium aquarium4 = new Aquarium(64.0, 40.0, 36.0);
		printAquariumVolume(aquarium1, 1);
		printAquariumVolume(aquarium2, 2);
		printAquariumVolume(aquarium3, 3);
		printAquariumVolume(aquarium4, 4);
	}

	/* метод для виводу об'єму акваріуму, оскільки до нього звертаємося з метода main, то
	він має бути static, aquarium – акваріум, number - номер акваріуму*/
	static void printAquariumVolume(Aquarium aquarium, int number) {
		System.out.println("Об'єм " + number + "-го акваріуму = " + aquarium.getVolume());
	}

}
