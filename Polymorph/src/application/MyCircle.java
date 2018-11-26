package application;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MyCircle extends MyShape{
	int r;
	MyCircle(int x, int y,int r) {
		super(x, y);
		this.r=r;
	}
	@Override
	void draw(GraphicsContext gc) {
            gc.setFill(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255))); 
            gc.fillOval(x, y, r, r); 
	
   }
}
