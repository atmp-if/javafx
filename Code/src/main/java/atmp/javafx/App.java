package atmp.javafx;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/Code.fxml"));
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Шифрування повідомлення");
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
