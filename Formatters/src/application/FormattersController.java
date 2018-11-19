package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class FormattersController {

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
	public void translate() {
        Person Man=new Person();
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
            DS_ua.format("%.1f грн.", Sal);
            DSalary_ua.setText(String.valueOf(DS_ua));
            Formatter DS_lang= new Formatter();
            DS_lang.format("$%.2f", Sal_lang);
            DSalary_lang.setText(String.valueOf(DS_lang));
         /*****************************************************/
            Man.Surname = DSurname_ua.getText().trim();
            Man.Name=DName_ua.getText().trim();
            DSurname_lang.setText(Person.transliter(Man.Surname));
            DName_lang.setText(Person.transliter(Man.Name));
	}
}