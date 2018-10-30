package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class FibonacciController {

	@FXML
	TextField input;
	@FXML
	Label result;

	@FXML
	public void calculate() {
		long n = Long.parseLong(input.getText());
		long a = 0, b = 0, c = 1;
		for (int i = 0; i < n; i++) {
			a = b;
			b = c;
			c = a + b;
			for (long j=0;j<100000000;j++);
		}
		result.setText(Long.toString(c));
	}

}
