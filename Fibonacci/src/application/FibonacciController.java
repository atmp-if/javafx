package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class FibonacciController {

	@FXML
	TextField input;
	@FXML
	Label result;
	@FXML
	TableView<FibonacciTask> resultTable;
	@FXML
	TableColumn<FibonacciTask, Long> resultCol;
	@FXML
	TableColumn<FibonacciTask, String> titleCol;
	@FXML
	TableColumn<FibonacciTask, String> statusCol;

	@FXML
	public void initialize() {
		resultCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, Long>("value"));
		titleCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, String>("title"));
		statusCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, String>("message"));
	}

	@FXML
	public void calculate() {
		long n = Long.parseLong(input.getText());
		FibonacciTask task = new FibonacciTask(n);
		resultTable.getItems().add(task);
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}

	@FXML
	public void next() {
		long n = Long.parseLong(input.getText());
		n++;
		input.setText(Long.toString(n));
		calculate();
	}

}
