package atmp.javafx;

import java.util.regex.Pattern;
import java.awt.Color;
import java.util.regex.Matcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class PhoneBookController {
	
    private final ObservableList<Phone> data = FXCollections.observableArrayList(
    		new Phone("Іванов І.І.", "094794721", "ivan.ivanov@ukr.net"),
            new Phone("Петрова М.Н.", "0954847216", "isabella@example.com"),
            new Phone("Сидоров Ю.А.", "0673259833", "ethan.man@gmail.com"),
            new Phone("Васильків П.Р.", "0504877732", "freeman@yahoo.com"),
            new Phone("Герасименко Р.В.", "0963334532", "michael@mail.com")
    		);
   
    
      @FXML public void initialize() {
		nameCol.setCellValueFactory(
			    new PropertyValueFactory<Phone,String>("name")
			);
		nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		phoneCol.setCellValueFactory(
			    new PropertyValueFactory<Phone,String>("phone")
			);
		phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		addressCol.setCellValueFactory(
			    new PropertyValueFactory<Phone,String>("address")
			);
		addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		nameCol.setOnEditCommit(
			    new EventHandler<CellEditEvent<Phone, String>>() {
			       @Override
			        public void handle(CellEditEvent<Phone, String> t) {
			        	Pattern ptNameColl = Pattern.compile("[A-ZА-ЯІ]{1}[a-zа-яі]+\\s[A-ZА-ЯІ]{1}\\.[A-ZА-ЯІ]{1}\\.");
			         	Matcher n = ptNameColl.matcher(t.getNewValue());
			         	boolean fpn = n.matches();
			        	if (fpn) {
			            ((Phone) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                ).setName(t.getNewValue());
			           
			            	}
			        	phoneList.refresh();
			        	}
			       }
			);
		
		phoneCol.setOnEditCommit(
			    new EventHandler<CellEditEvent<Phone, String>>() {
			    	
			        @Override
			        public void handle(CellEditEvent<Phone, String> t) {
			        	Pattern ptPhoneColl = Pattern.compile("[0-9]+");
			         	Matcher p = ptPhoneColl.matcher(t.getNewValue());
			         	boolean fpp = p.matches();
			        	if (fpp) {
			            ((Phone) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                ).setPhone(t.getNewValue());
			        	}
			        	phoneList.refresh();
			        }
			    }
			    
			   
			);
		
		addressCol.setOnEditCommit(
			    new EventHandler<CellEditEvent<Phone, String>>() {
			        @Override
			        public void handle(CellEditEvent<Phone, String> t) {
			        	Pattern ptAddressColl = Pattern.compile("[a-z0-9]{1,}@{1}([a-z0-9]{1,}\\.)+[a-z]{1,3}");
			         	Matcher a = ptAddressColl.matcher(t.getNewValue());
			         	boolean fpa = a.matches();
			        	if (fpa) {
			            ((Phone) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                ).setAddress(t.getNewValue());
			        	}
			        	phoneList.refresh();
			        }
			    }
			);
		
		phoneList.setItems(filteredData);
		
    }

	@FXML TableView<Phone> phoneList;
	@FXML TableColumn<Phone, String> nameCol;
	@FXML TableColumn<Phone, String> phoneCol;
	@FXML TableColumn<Phone, String> addressCol;
	@FXML TextField nameInput;
	@FXML TextField phoneInput;
	@FXML TextField addressInput;
	@FXML TextField filterInput;
	
	@FXML public void addPhone() {
		Phone p = new Phone(nameInput.getText(), phoneInput.getText(), addressInput.getText());
		if ((p.isValidName())&&(p.isValidPhone())&&(p.isValidAddress())) {
			data.add(p);
			nameInput.clear();
			phoneInput.clear();
			addressInput.clear();
		}
		if (p.isValidName()==false){
			nameInput.setStyle("-fx-text-fill: red");
		}else {
			nameInput.setStyle("-fx-text-fill: black");
		}
		
		if (p.isValidPhone()==false){
			phoneInput.setStyle("-fx-text-fill: red");
		}else {
			phoneInput.setStyle("-fx-text-fill: black");
		}
		
		if (p.isValidAddress()==false){
			addressInput.setStyle("-fx-text-fill: red");
		}else {
			addressInput.setStyle("-fx-text-fill: black");
		}
	}
		 
	@FXML public void filterPhones() {
		filteredData.setPredicate(e -> e.getName().contains(filterInput.getText()));
		}
	private final FilteredList<Phone> filteredData = new FilteredList<>(data, p -> true);
}
