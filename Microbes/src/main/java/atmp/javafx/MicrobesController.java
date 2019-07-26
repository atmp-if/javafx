package atmp.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MicrobesController {

	@FXML Button bt1;
	@FXML Button bt2;
	@FXML GridPane grid1;
	@FXML GridPane grid2; 
	
	int [][] microbes = new int[9][9];
	int [][] microLife = new int [9][9];
	
	@FXML public void generate() {
		// Очистка масиву перед новою генерацією мікробів
				grid1.getChildren().clear();
			    for (int i=0;i<microbes.length;i++) {
			    	for (int j=0;j<microbes[i].length;j++) {
			    		microbes[i][j]=0;
			    	}
			    }
			    grid1.getChildren().clear();
			    
			    int countMicrobes=100;
			    for(int c=0;c<countMicrobes;c++){
			    	int i=(int)(9*Math.random());
			    	int j=(int)(9*Math.random());
			    	if (i!=0&&i!=8&&j!=0&&j!=8) {
			        microbes[i][j]=1;
			    	}
			    }
			    
			    
			    for(int i=0;i<microbes.length;i++){
			      for(int j=0;j<microbes[i].length;j++){
			        Label lb=new Label();
			        lb.setFont(Font.font("Cambria", 44)); 
			         if (microbes[i][j]==1){
			             lb.setText("☻");
			             lb.setTextFill(Color.web("#ff0000"));
			  
			         } else {
			             lb.setText("☼");
			             lb.setTextFill(Color.web("#00ffaa"));
			         }
			        grid1.add(lb, i, j);
			      }
			}
			
	}
	@FXML public void life() {
		int sum=0;
		 for(int i=1;i<microbes.length-1;i++){
		      for(int j=1;j<microbes[i].length-1;j++){
		    	if (microbes[i][j]==1) {
		    		sum=microbes[i-1][j]+microbes[i][j-1]+microbes[i+1][j]+microbes[i][j+1];
		    		microLife[i][j]=sum;
		    	}
		    	else {
		    		microLife[i][j]=0;
		    	}
		      }
		 }
		 grid2.getChildren().clear();
		 for(int i=0;i<microLife.length;i++) {
			 for(int j=0;j<microLife[i].length;j++) {
		    	Label lb=new Label();
		    	lb.setFont(Font.font("Cambria", 44));
		    	switch (microLife[i][j]) {
		    	case 1:lb.setText("♥");lb.setTextFill(Color.web("#ff0000"));break;
		    	case 2:lb.setText("☺");lb.setTextFill(Color.web("#00ff00"));break;
		    	case 3:lb.setText("♪");lb.setTextFill(Color.web("#0000ff"));break;
		    	case 4:lb.setText("◘");lb.setTextFill(Color.web("#000000"));break;
		    	default : lb.setText("☼");lb.setTextFill(Color.web("#00ffaa"));
		    	}
		    	grid2.add(lb, i, j);  
		    	  
		      }
		 }
		
	}
	
}
