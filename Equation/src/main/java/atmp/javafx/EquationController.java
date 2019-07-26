package atmp.javafx;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class EquationController {

	@FXML TextField aInput;
	@FXML TextField bInput;
	@FXML TextField cInput;
	@FXML Label output_1;
	@FXML Label output_2;
	@FXML Button clearData;

	@FXML public void rez() {
		try {
		double a,b,d,c,x1,x2;
		a=Double.parseDouble(aInput.getText());
		b=Double.parseDouble(bInput.getText());
		c=Double.parseDouble(cInput.getText());
		d=Math.pow(b, 2)-4*a*c;
		if (d>0) {
		x1=Math.round((-b+Math.sqrt(d))/(2*a)*100000d)/100000d;
		x2=Math.round((-b-Math.sqrt(d))/(2*a)*100000d)/100000d;
	
		output_1.setText("x1=" + Double.toString(x1));
		output_2.setText("x2=" + Double.toString(x2));
		}
		else {
			output_1.setText("Рівняння розв'язку");
			output_2.setText("немає");
		}
		}catch (Exception e) {
			output_1.setText("Помилка");
			output_2.setText("Помилка");
		}
	}

	@FXML public void clearData() {
		aInput.clear();
		bInput.clear();
		cInput.clear();
		output_1.setText("");
		output_2.setText("");
		
	}
	
}
