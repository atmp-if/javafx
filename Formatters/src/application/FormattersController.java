package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class FormattersController {

    @FXML
    public ComboBox<?> country;

    @FXML
    public TextField DName_lang;

    @FXML
    public DatePicker DDate_ua;

    @FXML
    public TextField DName_ua;

    @FXML
    public TextField DSalary_ua;

    @FXML
    public TextField DSalary_lang;

    @FXML
    public Button translation;

    @FXML
    public TextField DSurname_ua;

    @FXML
    public TextField DSurname_lang;

    @FXML
    public TextField DBirthday_lang;

    @FXML
    void initialize() {
            Person Man=new Person();
            translation.setOnAction(event-> {
            Man.Birtday = DDate_ua.getValue();
            DateTimeFormatter ff=DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String BDay=Man.Birtday.format(ff);
            DBirthday_lang.setText(BDay);
            /************************************************/
                String StSum = DSalary_ua.getText().trim();
                Double Sal=null;
                try {
                     Sal = Double.valueOf(StSum);
                }
                catch (NumberFormatException ex) {
                   Alert alert=new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Повідомлення про помилку");
                   alert.setHeaderText(null);
                   alert.setContentText("Введіть правильно заробітну плату.");
                   alert.showAndWait();
                }
                Person.Salary_ua=Sal;
                Double Sal_lang=Sal/30;
                Person.Salary_lang=Sal_lang;
                Formatter DS_ua= new Formatter();
                Formatter format_ua = DS_ua.format("%.1f", Sal);
                DSalary_ua.setText(String.valueOf(DS_ua)+"  грн");
                Formatter DS_lang= new Formatter();
                Formatter format_lang = DS_lang.format("%.2f", Sal_lang);
                DSalary_lang.setText("$ "+String.valueOf(DS_lang));
             /*****************************************************/
                Man.Surname = DSurname_ua.getText().trim();
                Man.Name=DName_ua.getText().trim();
                DSurname_lang.setText(Person.transliter(Man.Surname));
                DName_lang.setText(Person.transliter(Man.Name));
                });
    }
}