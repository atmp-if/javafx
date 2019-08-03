package atmp.javafx;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class Cities2Controller {

	@FXML private TableView<City> idTable;
		
	static int[] people= {235355, 2937531, 726772,289544, 486255, 1000506, 
			       743113, 289399, 1011494, 113996,1443715, 918917, 406729, 264483,
			       277944, 265682, 371855, 266936, 291428, 268533, 
			       228630, 218653, 246574, 216505, 338319, 344853}; 
	int year[]= {1662, 482, 1256, 1641, 1789,1776, 
				1806, 1623, 1789, 892, 1654, 1869, 
				1882, 1780, 1795, 1488, 1640, 1444, 
				1778, 1566, 1784, 1548, 1492, 1432, 1784, 1783};  
	static String city[]= {"Івано-Франківськ","Київ", "Львів", "Полтава", "Миколаїв", "Дніпро","Запоріжжя", 
			"Чернігів","Одеса", "Ужгород", "Харків", "Донецьк", "Луганськ", "Суми",
			"Черкаси", "Чернівці", 	"Вінниця", "Житомир", "Херсон","Хмельницький",
			"Кропивницький", "Тернопіль", "Рівне", "Луцьк", "Сімферополь", "Севастополь"};
	String info[]= {"https://uk.wikipedia.org/wiki/Івано-Франківськ", "https://uk.wikipedia.org/wiki/Київ", 
			"https://uk.wikipedia.org/wiki/Львів","https://uk.wikipedia.org/wiki/Полтава",
			"https://uk.wikipedia.org/wiki/Миколаїв", "https://uk.wikipedia.org/wiki/Дніпро_(місто)",
			"https://uk.wikipedia.org/wiki/Запоріжжя", "https://uk.wikipedia.org/wiki/Чернігів",
			"https://uk.wikipedia.org/wiki/Одеса", "https://uk.wikipedia.org/wiki/Ужгород",
			"https://uk.wikipedia.org/wiki/Харків","https://uk.wikipedia.org/wiki/Донецьк",
			"https://uk.wikipedia.org/wiki/Луганськ", "https://uk.wikipedia.org/wiki/Суми", 
			"https://uk.wikipedia.org/wiki/Черкаси","https://uk.wikipedia.org/wiki/Чернівці",
			"https://uk.wikipedia.org/wiki/Вінниця","https://uk.wikipedia.org/wiki/Житормир",
			"https://uk.wikipedia.org/wiki/Херсон", "https://uk.wikipedia.org/wiki/Хмельницький",
			"https://uk.wikipedia.org/wiki/Кропивницький","https://uk.wikipedia.org/wiki/Тернопіль",
			"https://uk.wikipedia.org/wiki/Рівне", "https://uk.wikipedia.org/wiki/Луцьк",
			"https://uk.wikipedia.org/wiki/Сімферополь","https://uk.wikipedia.org/wiki/Севастополь"};
	
 static int count=26;
	@FXML TableColumn<City, String> idName;
	@FXML TableColumn<City, Integer> idAge;
	@FXML TableColumn<City, String> idInfo;
	
		
	public class City{
		private String city;
		private int year;
		private String info;
		
		City (String city, int year, String info){
			this.city=city;
			this.year=year;
			this.info=info;
			
		}
		 public String getCity() {
			 return city;
		 }
		 public int getYear() {
			 return year;
		 }
		 
		 public String getInfo() {
			 return info;
		 }
		 
	}
@FXML public void initialize() {
	idName.setCellValueFactory(new PropertyValueFactory<City,String>("city"));
	idAge.setCellValueFactory(new PropertyValueFactory<City,Integer>("year"));
	idInfo.setCellValueFactory(new PropertyValueFactory<City,String>("info"));
	
	ObservableList<City> langs = FXCollections.observableArrayList();
	
	for(int i=0;i<count;i++) {
		City nov=new City(city[i],year[i], info[i]);
		 langs.add(nov);
	 }
     idTable.setItems(langs);   
     }
@FXML Button idDiagram;
@FXML public void clickDiagram() throws IOException {
	      
	Parent root = FXMLLoader.load(getClass().getResource("/Diagram.fxml"));
       
       Scene secondScene = new Scene(root);
       Stage newWindow = new Stage();
       newWindow.setTitle("Населення");
       newWindow.setScene(secondScene);
       newWindow.show();
       	
	}

@FXML Button idRik;
@FXML Button idVazva;

@FXML public void clickRik() {}
@FXML public void clickNazva() {}
	
}
