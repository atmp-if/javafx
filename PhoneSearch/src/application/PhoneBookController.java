package application;


import java.util.regex.Pattern;
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
    		new Phone("Іванов І.І.", "094794721", "jacob.smith@example.com"),
            new Phone("Петрова М.Н.", "0954847216", "isabella.johnson@example.com"),
            new Phone("Сидоров Ю.А.", "0673259833", "ethan.williams@example.com"),
            new Phone("Васильків П.Р.", "0504877732", "emma.jones@example.com"),
            new Phone("Герасименко Р.В.", "0963334532", "michael.brown@example.com")
    		);
    private final FilteredList<Phone> filteredData = new FilteredList<>(data, p -> true);
    
      @FXML public void initialize() {
		nameCol.setCellValueFactory(
			    new PropertyValueFactory<Phone,String>("name")
			);
		nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		nameCol.setOnEditCommit(
			    new EventHandler<CellEditEvent<Phone, String>>() {
			       @Override
			        public void handle(CellEditEvent<Phone, String> t) {
			        	Pattern ptNameColl = Pattern.compile("[A-Za-zА-Яа-яІі]+");
			         	Matcher n = ptNameColl.matcher(t.getNewValue());
			         	boolean fpn = n.matches();
			        	if (fpn) {
			            ((Phone) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                ).setName(t.getNewValue());
			           
			        	}
			        	//else 
			        	//{
			       // 		((Phone) t.getTableView().getItems().get(
					//                t.getTablePosition().getRow())
					//                ).setName(t.getOldValue());
			        
			        	//}
			        }
			    }
			);
		
		phoneCol.setCellValueFactory(
			    new PropertyValueFactory<Phone,String>("phone")
			);
		phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
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
			        }
			    }
			    
			   
			);
		
		addressCol.setCellValueFactory(
			    new PropertyValueFactory<Phone,String>("address")
			);
		addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
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
		}
	}
	
	
	@FXML public void filterPhones() {
		filteredData.setPredicate(e -> e.getName().contains(filterInput.getText()));
		
	}
		
}
