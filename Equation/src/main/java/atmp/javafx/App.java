package atmp.javafx;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("/Equation.fxml"));
			Scene scene = new Scene(root,250,200);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Квадратне рівняння");
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
