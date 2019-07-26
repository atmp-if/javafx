package atmp.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;

public class DogController {

	@FXML CheckBox chLaki;
	@FXML CheckBox chCnypi;
	@FXML CheckBox chAlf;
	@FXML CheckBox chBaddi;
	@FXML CheckBox chBars;
	@FXML CheckBox chBim;
	@FXML ToggleGroup tgGrSort;
	@FXML Button btInfo;
	@FXML ImageView fotoLacki;
	@FXML ImageView fotoBim;
	@FXML ImageView fotoSnupi;
	@FXML ImageView fotoAlf;
	@FXML ImageView fotoBaddi;
	@FXML ImageView fotoBars;
	@FXML RadioButton rbName;
	@FXML RadioButton rbWeight;
	@FXML RadioButton rbAge;
	@FXML Label labelInfo;

	@FXML public void btInfo() {
		Dog[] masDog = {new Dog("Лакі", 23, 14), new Dog("Снупі", 2, 5), new Dog("Альф", 2, 3),
				new Dog("Бадді", 10, 14), new Dog("Барс", 21, 4), new Dog("Бім", 2, 5)};
		Dog[] masDogVubir = new Dog[6];
		CheckBox mas[] = {chLaki, chCnypi, chAlf, chBaddi, chBars, chBim};
		
		int n = 0;
		for (int i=0; i<6; i++){
			if (mas[i].isSelected()){
				n++;
			}
		}
		masDogVubir = new Dog[n];
		n=0;
		for (int i=0; i<6; i++){
			if (mas[i].isSelected()){
				masDogVubir[n] = masDog[i];
				n++;
			}
		}
		
		if (rbName.isSelected())
			Arrays.sort(masDogVubir);
		else if (rbWeight.isSelected())
			Arrays.sort(masDogVubir, new ComA());
		else Arrays.sort(masDogVubir, new ComW());
		
		String tRez = "";
		for (Dog temp : masDogVubir){
			tRez+=temp.toString() + "\n";
		}
		
		labelInfo.setText(tRez);
	}
	@FXML public void check(ActionEvent event) {
		/*при генерації методу вибираємо метод з параметром, 
		обєкт event містить в собі інформацію про подію.
		getTarget() визначає обєкт, що спричинив подію,
		Через приведення типів приводимо його до необхідного класу
		Тепер цей метод буде зчитувати інформацію який з CheckBox було вибрано
		і визначати яку фотографію показувати
		*/
		CheckBox cb=(CheckBox)event.getTarget(); 
				
		ImageView im;
		switch (cb.getText()) {
			case "Лакі":
				im=fotoLacki;
				break;
			case "Снупі":
				im=fotoSnupi;
				break;
			case "Альф":
				im=fotoAlf;
				break;
			case "Бадді":
				im=fotoBaddi;
				break;
			case "Барс":
				im=fotoBars;
				break;
			case "Бім":
				im=fotoBim;
				break;
			default:
				im=fotoBim;
				break;
			}
		im.setVisible(cb.isSelected());
	}
}
