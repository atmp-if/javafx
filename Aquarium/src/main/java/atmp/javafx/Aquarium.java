package atmp.javafx;

class Aquarium {
	double width;
	double height;
	double depth;

	// конструктор
	Aquarium(double pWidth, double pHeight, double pDepth) {
		width = pWidth;
		height = pHeight;
		depth = pDepth;
	}

	// метод для обчислення об'єму акваріума
	double getVolume() {
		return width * height * depth * 0.001;
	}
}
