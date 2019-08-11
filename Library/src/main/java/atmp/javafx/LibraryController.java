package atmp.javafx;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class LibraryController implements Initializable {
	static String driverName = "com.mysql.jdbc.Driver";
	private  final String url = "jdbc:mysql://127.0.0.1:3306/dblib";
	private  final String user = "root";
	private  final String password = "";
	private  Connection con;
	private  Statement stmt;
	private ObservableList<Book> booksData = FXCollections.observableArrayList();

     @FXML  private TextField btitle;
     @FXML  private TextField bautor;
     @FXML  private TextArea babout;
     @FXML  private TextField byear;
     @FXML  private TextField textfind;
     @FXML  private TableView<Book> tableBooks;
     @FXML  private TableColumn<Book, String> titleColumn;
     @FXML  private TableColumn<Book, String> autorColumn;
     @FXML  private TableColumn<Book, String> yearColumn;
     @FXML  private TableColumn<Book, String> aboutColumn;



    @FXML
    private void buttonAdd(ActionEvent event) {
    	insertRecord(btitle.getText(),bautor.getText(), byear.getText(), babout.getText());
    	btitle.setText("");bautor.setText("");byear.setText("");babout.setText("");
 }

    @FXML
    private void buttonFind(ActionEvent event) {
    	selectRecord();
    	titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
    	autorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("autor"));
    	yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
    	aboutColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("about"));
    	tableBooks.setItems(booksData);


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void insertRecord(String title,String autor, String year, String about){
		try {
		con=DriverManager.getConnection(url, user, password);
		stmt = con.createStatement();

			String query="INSERT INTO books (title,autor,year,about) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, autor);
			stmt.setString(3, year);
			stmt.setString(4, about);
			stmt.executeUpdate();
		stmt.close();
		con.close();
		} catch (Exception e) {
        e.printStackTrace();
		}
	}


 void selectRecord(){
	 
	 String tfind= textfind.getText();
	 
	 
	 
String selectQuery1="SELECT title, autor, year, about FROM books where (title like '%"+tfind+"%') or (autor like '%"+tfind+"%') or (year like '%"+tfind+"%') or (about like '%"+tfind+"%')";  
String selectQuery2="SELECT COUNT(*) FROM books";
try {
	con=DriverManager.getConnection(url, user, password);
	stmt = con.createStatement();
	ResultSet res=stmt.executeQuery(selectQuery1);
	booksData.clear();
	while (res.next()) {
		String title = res.getString(1);
		String autor = res.getString(2);
		String year = res.getString(3);
		String about = res.getString(4);
		Book t = new Book(title, autor, year, about);
		 booksData.add(t);



		 }
	//System.out.println(booksData);

	res = stmt.executeQuery(selectQuery2);
	res.next();
	int count = res.getInt(1);
	System.out.println("Кількість рядків в базі --"+count);

	stmt.close();
	con.close();
	} catch (Exception e) {
    e.printStackTrace();
	}
}



}
