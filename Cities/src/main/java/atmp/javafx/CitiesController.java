package atmp.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CitiesController {
	@FXML private Button idMax, idMin;
	@FXML private Label idLabel, idYear;
	@FXML private ImageView idGerb;
	@FXML private ComboBox<String> idAllCity;
		
	int year[]= {1662, 482, 1256, 1641, 1789,1776,
			1806, 1623, 1789,892, 1654, 1869, 1882,
			1780, 1795, 1488, 1640, 1444, 1778, 
			1566, 1784, 1548, 1492, 1432, 1784, 1783};  
	String city[]= {"Івано-Франківськ","Київ", "Львів", "Полтава", "Миколаїв", "Дніпро","Запоріжжя", 
			"Чернігів","Одеса", "Ужгород", "Харків", "Донецьк", "Луганськ", "Суми",
			"Черкаси", "Чернівці", 	"Вінниця", "Житомир", "Херсон","Хмельницький",
			"Кропивницький", "Тернопіль", "Рівне", "Луцьк", "Сімферополь", "Севастополь"};
	private Image []gerb= {new Image("/images/0.png"),
			new Image("/images/1.png"),	new Image("/images/2.png"),	new Image("/images/3.png"),	
			new Image("/images/4.png"),	new Image("/images/5.png"),	new Image("/images/6.png"),
			new Image("/images/7.png"),	new Image("/images/8.png"),	new Image("/images/9.png"),	
			new Image("/images/10.png"),new Image("/images/11.png"), new Image("/images/12.png"),
			new Image("/images/13.png"), new Image("/images/14.png"),new Image("/images/15.png"), 
			new Image("/images/16.png"),new Image("/images/17.png"), new Image("/images/18.png"),
			new Image("/images/19.png"), new Image("/images/20.png"),new Image("/images/21.png"), 
			new Image("/images/22.png"),new Image("/images/23.png"), new Image("/images/24.png"),
			new Image("/images/25.png")	};

	@FXML public void initialize() {
		ObservableList<String> langs = FXCollections.observableArrayList();
		 for(int i=0;i<city.length;i++) langs.add(city[i]);
	     idAllCity.setItems(langs);
	     idLabel.setText("");
	}
	
	@FXML private void showMax(){
		int max=year[0];
		int k=0;
		for (int i=0; i<year.length;i++) {
			if(year[i]<max) {
				max=year[i];
				k=i;
				}
			idLabel.setText(city[k]+" - найстаріший обласний центр України, засновано в "+ year[k]);
			idGerb.setImage(gerb[k]);
			idYear.setText("");
			idAllCity.setPromptText(city[k]);
		}
	}
	
	@FXML private void showMin(){
		int max=year[0];
		int k=0;
		for (int i=0; i<year.length;i++) {
			if(year[i]>max) {
				max=year[i];
				k=i;
				}
			idLabel.setText(city[k]+" - наймолодший обласний центр України, засновано в "+year[k]);
			idGerb.setImage(gerb[k]);      
			idYear.setText("");
			idAllCity.setPromptText(city[k]);
		}
	}
		 
	 @FXML	private void choiceCity() {	
		 	idLabel.setText("");
		 for (int i=0;i<city.length;i++)
		 if(idAllCity.getSelectionModel().isSelected(i)){
			 idYear.setText("рік заснування: "+year[i]);
			 idGerb.setImage(gerb[i]);
			 }
	 }
}


