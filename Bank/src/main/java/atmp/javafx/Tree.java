package atmp.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tree {
    @FXML
    private TextField NumberPeriod;
    @FXML
    private TextField FinalSum;
    @FXML
    public Button ButtonReturn;
    @FXML
    public Button ButtonCalc;
    @FXML
    public TextField StartSum;
    @FXML
    void initialize() {
        ButtonReturn.setOnAction(event -> {
            ButtonReturn.getScene().getWindow().hide();
         });
        ButtonCalc.setOnAction(event-> {
            String StSum = StartSum.getText().trim();
            Double SS = null;
            try {
                   SS = Double.valueOf(StSum);
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Повідомлення про помилку");
                alert.setHeaderText(null);
                alert.setContentText("Введіть правильно початкову суму");
                alert.showAndWait();
            }
            String NumPeriod = NumberPeriod.getText().trim();
            Integer NP=null;
            try {
                NP = Integer.parseInt(NumPeriod);
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Повідомлення про помилку");
                alert.setHeaderText(null);
                alert.setContentText("Введіть правильно кількість періодів - ціле число");
                alert.showAndWait();
            }
            for (int i = 1; i <= NP; i++) {
                SS = SS + 0.1 * SS;
            }
            FinalSum.setText(String.valueOf(SS)+" uah");
        });
    }
}