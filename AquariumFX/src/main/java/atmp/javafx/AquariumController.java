package atmp.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class AquariumController {

	@FXML TextField tWidth;
	@FXML TextField tDepth;
	@FXML TextField tHeight;
	@FXML Label resLabel;
	@FXML Button buttonVolume;

	@FXML public void click() {
		double w, h, d;

		w = Double.parseDouble(tWidth.getText());
		h = Double.parseDouble(tDepth.getText());
		d = Double.parseDouble(tHeight.getText());

		Aquarium aqua = new Aquarium(w, h, d);
		double v = aqua.getVolume(aqua);
		resLabel.setText("Об'єм акваріума " + v + " л");
	}

}
