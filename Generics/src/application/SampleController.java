package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SampleController {

	@FXML Button bt1;
	@FXML TextArea text1;
	@FXML Button bt2;
	@FXML TextArea text2;
	@FXML Button bt3;
	@FXML Button bt4;
	@FXML TextArea text4;
	@FXML TextArea text3;
	Unspecified<Integer> masInt=new Unspecified<>();
	Unspecified<Character> masChar=new Unspecified<>();
	
	@FXML public void generateInt() {
		text1.clear();
		Integer [] mas=new Integer[10];
		for (int i=0;i<10;i++) {
			Integer number = (int)(Math.random()*10);
			mas[i]=number;
		}
		masInt.set(mas);
		
		text1.appendText(masInt.printMas());
	}

	@FXML public void sortInt() {
		text2.clear();
		masInt.sort();
		text2.appendText(masInt.printMas());
	}

	@FXML public void generateChar() {
		text3.clear();
		Character [] mas=new Character[10];
		for (int i=0;i<10;i++) {
			Character number =(char)((int)(Math.random()*10)+100);
			mas[i]=number;
		}
		masChar.set(mas);
		text3.appendText(masChar.printMas());
	}

	@FXML public void sortChar() {
		text4.clear();
		masChar.sort();
		text4.appendText(masChar.printMas());
	}
	
}
