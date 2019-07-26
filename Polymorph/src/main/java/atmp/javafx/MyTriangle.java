package atmp.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyTriangle extends MyShape{
	double x2,y2,x3,y3;
	MyTriangle(double x, double y,double x2,double y2,double x3,double y3) {
		super(x, y);
		this.x2=x2;this.y2=y2;this.x3=x3; this.y3=y3;
	}
	@Override
	void draw(GraphicsContext gc) {
            gc.setFill(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255))); // генеруємо випадковий колір
            gc.fillPolygon(
                new double[]{x, x2, x3},
                new double[]{y, y2, y3},
                3
        );

 	}
}
