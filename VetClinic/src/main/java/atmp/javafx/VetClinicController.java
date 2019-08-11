package atmp.javafx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StreamCorruptedException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;

public class VetClinicController {

	@FXML TextField idName;
	@FXML TextField idAge;
	@FXML TextField idBreed;
	@FXML TextField idWeight;
	@FXML Button btWriteToFile;
	@FXML Button btReadWithFile;
	@FXML Label labelInfo;
	File file = new File("file.txt");
	@FXML ComboBox idComboBox;
	ObservableList<String> listComboBox;
	@FXML public void initialize() {
		listComboBox = FXCollections.observableArrayList();
		listComboBox.add("Кішка");
		listComboBox.add("Собака");
		listComboBox.add("Тварина");
		idComboBox.setItems(listComboBox);
	}

	ArrayList<Animal> listAnimal = new ArrayList<Animal>();
	@FXML TextField idNameOwner;
	@FXML ListView idListView;
	@FXML public void btWrite() throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			if (file.exists()) {
				file.createNewFile(); 
			}
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			listAnimal = (ArrayList<Animal>) ois.readObject();
			ois.close();
		}catch (NullPointerException e) {
			labelInfo.setText("У файлі нічого немає");
		}catch(IOException e) {
			labelInfo.setText("У файлі нічогого немає");
		}
			
		FileOutputStream fos = new FileOutputStream (file);
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
	
		Animal an = null;
		Owner owner = new Owner( idNameOwner.getText());
		try{
//			an = new Animal(idName.getText(), Integer.parseInt(idAge.getText()),idBreed.getText(), 
//					Integer.parseInt(idWeight.getText()), owner);
			labelInfo.setText("");
			String name = idName.getText();
			int age = Integer.parseInt(idAge.getText());
			String breed = idBreed.getText();
			int weight = Integer.parseInt(idWeight.getText());
			if (idComboBox.getSelectionModel().isSelected(0)) {
				Cat c = new Cat(name, age, breed, weight, owner);
				listAnimal.add(c);
			} else 
			if (idComboBox.getSelectionModel().isSelected(1)) {
				Dog d = new Dog(name, age, breed, weight, owner);
				listAnimal.add(d);
			}else {
				an = new Animal(name, age, breed, weight, owner);
				listAnimal.add(an);
			}
			oos.writeObject(listAnimal);  
		}catch(NumberFormatException e) {
			labelInfo.setText("Введено некоректно дані");
		}
		clearEdit();
		oos.close();
	}
	
	@FXML public void btRead() throws IOException, ClassNotFoundException{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			listAnimal = (ArrayList<Animal>) ois.readObject();

			idListView.getItems().clear();
			for (Animal temp: listAnimal) {
				idListView.getItems().add(temp.toString());
			}
			labelInfo.setText("");
			ois.close();
		}catch (NullPointerException e) {
			labelInfo.setText("У файлі нічого немає");
			ois.close();
		}catch(IOException e) {	}
	}
	
	void clearEdit() {
		idName.clear();
		idAge.clear();
		idBreed.clear();
		idWeight.clear();
		idNameOwner.clear();
	}


	@FXML public void metodComboBox(ActionEvent event) {}


	
	

}
