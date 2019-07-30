package atmp.javafx;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ZnoController {
	private LocalDate ld;
	private String dayWeek;

	@FXML DatePicker tDate;
	@FXML Text tText;
	@FXML Button buttonOk;
	@FXML ImageView image;

	@FXML public void onDate() {
		ld = tDate.getValue();
		dayWeek = ld.getDayOfWeek().toString();
		Week t = Week.valueOf(dayWeek);
		tText.setText(t.occupation());
		image.setImage(t.setPic());
	}

}
