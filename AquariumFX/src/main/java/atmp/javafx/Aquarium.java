package atmp.javafx;

public class Aquarium {
	// властивості акваріума
	double width;
	double height;
	double depth;

	// конструктор
	Aquarium(double pWidth, double pHeight, double pDepth) {
		width = pWidth;
		height = pHeight;
		depth = pDepth;
	}

	// обчислюємо об'єм акваріума
	double getVolume(Aquarium aquarium) {
		return (aquarium.width * aquarium.height * aquarium.depth * 0.001);
	}

}
