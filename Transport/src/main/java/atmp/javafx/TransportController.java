package atmp.javafx;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ListView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class TransportController {

	@FXML Label lb0;
	@FXML Label lb1;
	@FXML Label lb2;
	@FXML Label lb3;
	@FXML Label lb5;
	@FXML Label lb6;
	@FXML Button btnViewListVehicle;
	@FXML TextField tf0;
	@FXML TextField tf1;
	@FXML TextField tf2;
	@FXML RadioButton rb1;
	@FXML RadioButton rb2;
	@FXML TextField tf5;
	@FXML TextField tf6;
	@FXML ListView <Vehicle>lv;
	@FXML DatePicker dpBegin;
	@FXML DatePicker dpEnd;
	@FXML Button btnOrderVehicle;
	@FXML TextArea txtAr;
	@FXML ToggleGroup toggleGroup;
	static Vehicle vehicle[];
	
	//Обробник події натиснення конпки btnViewListVehicle
	@FXML public void createListView() {
		int numberOfPassengers= Integer.parseInt(tf5.getText());
		int maxiWeight=Integer.parseInt(tf6.getText());
		int j=0;
		//якщо ввімкнена rb1 формуємо один масив Vehicle з об'єктів Bus та Car
		if (rb1.isSelected()){
			vehicle=new Vehicle[8];
			for (int i=0;i<Bus.bus.length;i++) {
				if (Bus.bus[i].isWorking()&& Bus.bus[i].isFree()
					&&Bus.bus[i].numberOfPassengers>=numberOfPassengers){
					vehicle[j++]=Bus.bus[i];
				}
			}
			for (int i=0;i<Car.car.length;i++) {
				if (Car.car[i].isWorking()&& Car.car[i].isFree()
					&&Car.car[i].numberOfPassengers>=numberOfPassengers){
					vehicle[j++]=Car.car[i];
				}
			}
			//інакше інший масив Vehicle з об'єктів Truck
		}else {
			vehicle=new Vehicle[4];
			for (int i=0;i<Truck.truck.length;i++) {
				if (Truck.truck[i].isWorking() && Truck.truck[i].isFree()
					&&Truck.truck[i].maxiWeight>=maxiWeight){
					vehicle[j++]=Truck.truck[i];
				}
			}
		}
		//перезаписуємо масив vehicle без null - елементів
		Vehicle temp[]=vehicle;
		vehicle=new Vehicle[j];
		for (int i=0;i<j;i++) vehicle[i]=temp[i];
		//передаємо в ListView масив vehicle
		lv.setItems( FXCollections.observableArrayList(vehicle));
	}
	//Обробник події натиснення конпки btnOrderVehicle
	@FXML public void createOrder() {
		if(lv.getSelectionModel().getSelectedItem()!=null) {
			lv.getSelectionModel().getSelectedItem().route=new Route(tf0.getText(),tf1.getText(),dpBegin.getValue(),
					dpEnd.getValue(), Integer.parseInt(tf2.getText()));
			String str="Маршрут- "+ tf0.getText()+" - "+ tf1.getText()+"\n"+
				"Вартість - "+lv.getSelectionModel().getSelectedItem().getTransportationCost()+" грн."+"\n"+
				"ТЗ: "+ lv.getSelectionModel().getSelectedItem().toString()+"\n"+
				"відправлення - " + dpBegin.getValue().toString()+
				" р. : прибуття - "+ dpEnd.getValue().toString()+" р.";

			txtAr.setText(str);
		}else txtAr.clear();
	}
	//Обробник події групи toggleGroupe
	public void changedRb() {
		//При вмиканні rb1 робиться активним поле tf5 інакше tf6
		if (rb1.isSelected()){
			tf5.setDisable(false);
			tf6.setDisable(true);
		}
		else{
			tf5.setDisable(true);
			tf6.setDisable(false);
		}
	}
	
	public void initialize (){
		tf5.setDisable(false);
		tf6.setDisable(true);
		dpBegin.setValue(LocalDate.now());
		dpEnd.setValue(LocalDate.now());
	}
	
}
