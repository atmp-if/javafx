package atmp.javafx;


import javafx.scene.canvas.GraphicsContext;

public abstract class MyShape {
	double x,y;
	abstract void draw(GraphicsContext gc);
	MyShape(double x,double y){
		this.x=x;
		this.y=y;
	}
}
