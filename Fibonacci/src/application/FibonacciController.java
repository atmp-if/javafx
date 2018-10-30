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
		FibonacciTask task = new FibonacciTask(n);
		task.setOnSucceeded((succeededEvent) -> {
			result.setText(task.getValue().toString());
		});
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
	}

}
