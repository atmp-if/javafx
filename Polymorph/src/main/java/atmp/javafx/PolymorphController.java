package atmp.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class PolymorphController implements Initializable {
    int size =500;
    @FXML   private Label label;
    @FXML   private Canvas canva;
    @FXML
    private void drawCircle(ActionEvent event) {
        label.setText("Коло!");
        MyShape sh = new MyCircle(rnd(),rnd(),rnd());
        sh.draw(canva.getGraphicsContext2D());
    }

    @FXML
    private void drawTriangle(ActionEvent event) {
        label.setText("Трикутник!");
        MyShape sh = new MyTriangle(rnd(),rnd(),rnd(),rnd(),rnd(),rnd());
        sh.draw(canva.getGraphicsContext2D());
    }

    @FXML
    private void drawSquaer(ActionEvent event) {
        label.setText("Квадрат!");
        MyShape sh = new MySquare(rnd()/2,rnd()/2,rnd());
        sh.draw(canva.getGraphicsContext2D());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    int rnd(){ return (int)(Math.random()*size);
    }

}
