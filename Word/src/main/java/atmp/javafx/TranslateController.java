package atmp.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;


import java.time.LocalDate;
import java.util.*;

public class TranslateController implements Initializable {
    @FXML
    public Label rating;
    int k=0;
    @FXML
    private Label lbWord;
    @FXML
    private TextField tfResult;

    private List<Data> words;
    private Data currentWord;
    int size =0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     // створити файл результатів якщо він не існує

        File f = new File("result.txt");
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

// обробка події btnCheck
    @FXML
    private void btnCheck_Click(){

        if (currentWord == null)
            return;
    //якщо поточне українське слово об'єкту Data дорівнює введеному в текстове поле тоді викликаємо метод nextWord(); ,
        // очищуємо текстове поле та додаємо бал
        if(currentWord.getUa().equalsIgnoreCase(this.tfResult.getText())){

            this.nextWord();
            this.tfResult.setText("");
           k++;
        }
        // якщо відповідь неправильна викликаємо повідомлення класу Alert та віднімаємо бал
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Спробуйте ще...");
            a.showAndWait();
            k--;
        }
    }


// В методі nextWord ініціалізуємо поле currentWord нульовим елементом колкці words
    private void nextWord(){
        try {
            this.currentWord = this.words.get(0);
        }catch (IndexOutOfBoundsException e){
            this.lbWord.setText("Слова закінчилися");
            return;
        }

// записуємо англійське слово для формування завдання
        this.lbWord.setText(this.currentWord.getEn());
// видаляємо нульовий елемент колекції
        this.words.remove(0);
    }




//перестановка символів
    public void setWords(List<Data> _words) {
        this.words = new ArrayList<Data>();

        for (Data d: _words) {
            this.words.add(d);
        }
        Collections.shuffle(this.words);
        size=words.size();
        this.nextWord();
    }




    public void addResult(ActionEvent actionEvent) {
        try(FileWriter writer = new FileWriter("result.txt", true))
        {
            // записуємо в файл

            writer.write("Ваш результат - "+String.valueOf(k*100/size)+ " балів "+ LocalDate.now());

            this.rating.setText(String.valueOf(k*100/size)+" ");
            writer.append('\n');


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
