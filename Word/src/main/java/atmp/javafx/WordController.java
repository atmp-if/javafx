package atmp.javafx;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WordController implements Initializable {

    public Label word;
    @FXML
    private TextField fileSearch;
    @FXML
    private ListView<String> samleText;


    File fileObject;

    private List<Data> words;



    ObservableList<String> rowList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.words = new ArrayList<Data>();
    }



    /**
     * Кнопка закрити
     */
    @FXML
    private void clickClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

//використовуємо FileChooser для додавання файлу
    @FXML
    private void addFile(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage primaryStage = (Stage) source.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter tXTFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(tXTFilter);
        fileChooser.getExtensionFilters().addAll(tXTFilter);
        fileChooser.setTitle("Вибір файлу");
        fileObject = fileChooser.showOpenDialog(primaryStage);
        try {
            fileSearch.setText(fileObject.getPath());
            App.filePath = fileObject.getPath();
        } catch (Exception e) {

        }
    }

    @FXML
    private void innFile(ActionEvent event) {
        try {

            this.words.clear();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileObject), "cp1251"));

            String line = reader.readLine();

            if(line == null && line.equals(""))
                return;

            while (line != null && !line.equals("")) {
                this.words.add(this.parseLine(line));
                this.rowList.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        samleText.setItems(rowList);

    }

    private Data parseLine(String line){

        String[] arr = line.split(" - ");

        return new Data(arr[0],arr[1]);
    }





    @FXML
    public void translateWord_Click(ActionEvent actionEvent) {
        try {

            this.rowList.clear();
            //описати лоадер
            FXMLLoader loader = new FXMLLoader(WordController.class.getResource("/Translate.fxml"));
            Parent root = loader.load();
            ((TranslateController)loader.getController()).setWords(this.words);
            Stage stage = new Stage();
            stage.initOwner(this.fileSearch.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("TranslateWord");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinHeight(150);
            stage.setMinWidth(600);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
