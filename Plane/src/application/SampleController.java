package application;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class SampleController {

	@FXML ImageView image;
	@FXML ToggleGroup planeType;
	@FXML Label lInformation;
	@FXML RadioButton rbPas;
	@FXML RadioButton rbVant;
	@FXML RadioButton rbAll;
	@FXML public void btInformation() {
		Plane planeMas [] = {new PassengerPlane("Boeing 777", 62, 10, 125), new Airfreighter("AH-225", 6, 52, 65)};
		Plane plane = null;
		String text = "";
		if (rbPas.isSelected()) {
			for (Plane temp: planeMas)
				if (temp instanceof PassengerPlane) {
					plane = temp;
					text = text + plane.carry();
					image.setImage(plane.getImage());
				}
		} else {
			if (rbVant.isSelected()) {
				for (Plane temp: planeMas)
					if (temp instanceof Airfreighter) {
						plane = temp;
						text = text + plane.carry();
						image.setImage(plane.getImage());
					}
			}else {
				for (Plane temp: planeMas) {
					text = text + temp.carry();
					image.setVisible(false);
				}
			}
		}
		
		lInformation.setText(text);

		
	}
	
}
