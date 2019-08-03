package atmp.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DiagramController {
	
	@FXML private BarChart<String, Integer> idBarChart;
	@FXML private CategoryAxis idCity;
	@FXML private NumberAxis idNasel;
	@FXML public void initialize() {
		ObservableList<String> mista = FXCollections.observableArrayList();
		idCity.setCategories(mista);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
			for (int i=0;i<Cities2Controller.count;i++) {
				mista.add(Cities2Controller.city[i]);
				series.getData().add(new XYChart.Data<>(mista.get(i), Cities2Controller.people[i]));				
			} 
			idBarChart.getData().add(series);  
	}
	
}
