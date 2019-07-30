package atmp.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class CodeController  {

    @FXML
    public CheckBox delSpace;
    @FXML
    public CheckBox reverseOn;
    @FXML
    public CheckBox UpperCase;
    @FXML
    public CheckBox numberOfCharacters;
    @FXML
    public Label test;
    @FXML
    public CheckBox СЃaesarCode;
    @FXML
    private TextArea textAreaIn;
    @FXML
    private TextArea textAreaOut;

    String textArea;


    public void apply(ActionEvent actionEvent) {

        textArea=textAreaIn.getText();
        textAreaOut.setText(textAreaIn.getText());


        if(delSpace.isSelected()){

            textAreaOut.setText(textAreaOut.getText().replace(" ", ""));
        }


     // розвернути рядок
        if(reverseOn.isSelected()){

            StringBuilder sb = new StringBuilder(textAreaOut.getText());
            textAreaOut.setText(String.valueOf(sb.reverse()));

        }

     // зробити усі літери великі

        if(UpperCase.isSelected()){

            textAreaOut.setText(textAreaOut.getText().toUpperCase());
        }

      //відображення кількості символів
        if(numberOfCharacters.isSelected()){
            test.setText(String.valueOf(textAreaOut.getText().length()));

        }

      //застосувати код Цезаря
        if(СЃaesarCode.isSelected()) {
            String enc = textAreaOut.getText();
            int offset = 3;
            offset = offset % 26 + 26;
            StringBuilder encoded = new StringBuilder();
            for (char i : enc.toCharArray()) {
                if (Character.isLetter(i)) {
                    if (Character.isUpperCase(i)) {
                        encoded.append((char) ('A' + (i - 'A' + offset) % 26));
                    } else {
                        encoded.append((char) ('a' + (i - 'a' + offset) % 26));
                    }
                } else {
                    encoded.append(i);
                }
            }


            textAreaOut.setText(String.valueOf(encoded));
        }

    }



}
