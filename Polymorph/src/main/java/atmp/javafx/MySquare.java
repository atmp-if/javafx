package atmp.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MySquare extends MyShape{
	double a;
	MySquare(double x, double y, double a) {
		super(x, y);
		this.a=a;
	}
	@Override
	void draw(GraphicsContext gc) {
	gc.setFill(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
        gc.fillRect(x, y, a, a);
    }
}
