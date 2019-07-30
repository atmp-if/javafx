package atmp.javafx;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Zno.fxml"));
			Scene scene = new Scene(root,500,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Підготовка до ЗНО");
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
