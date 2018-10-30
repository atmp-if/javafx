package application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ProgressBarTableCell;
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
	TableColumn<FibonacciTask, Double> progressCol;
	
	ExecutorService executor = Executors.newFixedThreadPool(2);

	@FXML
	public void initialize() {
		resultCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, Long>("value"));
		titleCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, String>("title"));
		statusCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, String>("message"));
		progressCol.setCellValueFactory(new PropertyValueFactory<FibonacciTask, Double>("progress"));
		progressCol.setCellFactory(ProgressBarTableCell.<FibonacciTask>forTableColumn());
	}

	@FXML
	public void calculate() {
		long n = Long.parseLong(input.getText());
		FibonacciTask task = new FibonacciTask(n);
		resultTable.getItems().add(task);
		executor.execute(task);
	}

	@FXML
	public void next() {
		long n = Long.parseLong(input.getText());
		n++;
		input.setText(Long.toString(n));
		calculate();
	}

}
