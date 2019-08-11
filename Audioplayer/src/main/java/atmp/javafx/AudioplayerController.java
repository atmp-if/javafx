package atmp.javafx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.MenuButton;
import javafx.scene.control .ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.MenuItem;

public class AudioplayerController {

	@FXML MenuBar menu;
	MediaView mediaView = new MediaView();
	static File f=null;
	static double totalTime;
	static double currentTime;
	static Media media; 
	static MediaPlayer mediaPlayer=null;
	static MediaPlayer mediaPlayer2;
	static ArrayList<Track> listTrack = new ArrayList<Track>();
	static File nameList;
	@FXML Label nameFile;
	@FXML Slider progressSlider;
	@FXML Label timeLabel;
	@FXML ToggleButton stopTgbtn;
	@FXML ToggleButton playTgbtn;
	@FXML ToggleButton pauseTgbtn;
	@FXML MenuButton addMenubtn;
	@FXML MenuButton deleteMenubtn;
	@FXML MenuButton sortMenubtn;
	@FXML ListView<Track> list;
	@FXML ToggleGroup tgGroup;
	@FXML Slider volumeSlider;  
	@FXML MenuItem addFiles;
	@FXML MenuItem addDir;
	@FXML MenuItem addList;
	@FXML MenuItem createList;
	@FXML MenuItem deleteTrack;
	@FXML MenuItem clearList;
	@FXML MenuItem deleteCloneTracks;
	@FXML MenuItem sortedToUp;
	@FXML MenuItem sortedToDown;
	
	
	//метод обробник вибору пункту меню "Додати пісні"
		@FXML public void addFilesOnAction() {
			FileChooser fc=new FileChooser(); 
			fc.getExtensionFilters().addAll(new ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
			List <File> fileList= fc.showOpenMultipleDialog(null);
			listTrack.addAll(Track.toTrackList(fileList));
			list.setItems(FXCollections.observableArrayList(listTrack));
		}
		//метод обробник вибору пункту меню "Додати папку"
		@FXML public void addDirOnAction() {
			DirectoryChooser dc = new DirectoryChooser();
			File dir = dc.showDialog(null).getAbsoluteFile();
			FilenameFilter filter = new FilenameFilter() {
		        public boolean accept(File directory, String fileName) {
		            return fileName.endsWith(".mp3")||fileName.endsWith(".wav")||
		            		fileName.endsWith(".MP3")||fileName.endsWith(".WAV");
		        }
			};
			File[] files= dir.listFiles(filter);
			ArrayList <File> fileList= new  ArrayList <File> (Arrays.asList(files));
			listTrack.addAll(Track.toTrackList(fileList));
			list.setItems(FXCollections.observableArrayList(listTrack));
		}
		//метод обробник вибору пункту меню "Створити мій список"
		@FXML public void createListOnAction() {
			File listsDir = new File("Lists");
			
			if (!listsDir.exists())listsDir.mkdirs(); 
			 TextInputDialog dialog = new TextInputDialog();
			 	
		        dialog.setTitle("Створити новий список");
		        dialog.setHeaderText("");
		        dialog.setContentText("Введіть назву списка");
		        Optional<String> result = dialog.showAndWait();
		        result.ifPresent(name -> {
		        	nameList = new File(name);
		        	try {
						FileOutputStream out = new FileOutputStream("Lists/"+name+".mylst");
						ObjectOutputStream objOut = new ObjectOutputStream(out);
						objOut.writeObject(listTrack);
						objOut.close();
								
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        });
		}
		//метод обробник вибору пункту меню "Додати мій список"
		@FXML public void openListOnAction() {
			FileChooser fc=new FileChooser();
			fc.setInitialDirectory(new File("Lists"));
			fc.getExtensionFilters().addAll(new ExtensionFilter("Мої списки", "*.mylst"));
			
			FileInputStream input;
			ObjectInputStream objInput;
			try {
				input = new FileInputStream(fc.showOpenDialog(null));
				objInput = new ObjectInputStream(input);
				listTrack = (ArrayList<Track>) objInput.readObject();
				input.close();

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			list.setItems(FXCollections.observableArrayList(listTrack));
		}
		//метод обробник вибору пункту меню "Видалити трек зі списку"
		@FXML public void deleteTrackOnAction() {
			int index=list.getSelectionModel().getSelectedIndex();
			list.getItems().remove(index);
			
		}
		//метод обробник вибору пункту меню "Очистити весь список"
		@FXML public void clearListOnAction() {
			listTrack.clear();
			list.getItems().clear();
		}
		//метод обробник вибору пункту меню "Видалити всі пісні що повторюються"
		@FXML public void deleteCloneTracksOnAction() {
			HashMap<String,Track> map=new HashMap<String,Track>();
			Iterator  <Track> it=listTrack.iterator();
			while(it.hasNext()) {
				Track track=it.next();
				map.put(track.name, track);
			}
			listTrack = new ArrayList<Track>(map.values());
			list.setItems(FXCollections.observableArrayList(listTrack));
		}
		//методи обробники вибору пунктів меню "Сортувати ..."
		@FXML public void sortedToUpOnAction() {
			listTrack.sort(new Comparator<Track>() {

				@Override
				public int compare(Track arg0, Track arg1) {
					String str0=arg0.name;
					String str1=arg1.name;
					return str0.compareTo(str1);
				}
			});
			list.getItems().clear();
			list.setItems(FXCollections.observableArrayList(listTrack));
		}
		@FXML public void sortedToDownOnAction() {
			listTrack.sort(new Comparator<Track>() {

				@Override
				public int compare(Track arg0, Track arg1) {
					String str0=arg0.name;
					String str1=arg1.name;
					return str1.compareTo(str0);
				}
			});
			list.getItems().clear();
			list.setItems(FXCollections.observableArrayList(listTrack));
		}
	
	public void initialize() {
		 //Встановлюємо початкове значення повзунка звука на половину
		 volumeSlider.setValue(50);
	 }
	//метод, який визначає поточний час звучання та показує його в плеєрі
	void putCurrentTime() {
  		//визначаємо поточний час звучання пісні
		currentTime=mediaPlayer.getCurrentTime().toSeconds();
  		// відображаємо в Label timeLabel поточний	та загальний час звучання
  		String strTime=timeFormater(currentTime)+ " / "+timeFormater(totalTime);
  		timeLabel.setText(strTime);
	}
	//метод, який повертає форматоване значення часу звучання
		String timeFormater(double timeSecond) {
			int minutes=(int)timeSecond/60;
			int secundes=(int)(timeSecond-minutes*60);
			String timeFormatting=minutes+"m "+secundes+"s";
			return timeFormatting;
	}
	//обробник групи кнопок ToggleButton 
	@FXML public void groupActions() {
		if(playTgbtn.isSelected()) {
			if (mediaPlayer!=null)
				if( mediaPlayer.equals(mediaPlayer2)) {
					mediaPlayer.play();
					progressSlider.setValue(currentTime);	
					putCurrentTime();
				}else {
					mediaPlayer.stop();
					//Встановлюємо повзунок progressSlider на початок 
					progressSlider.setValue(0);
					//метод setOnReady чекає поки mediaPlayer буде в стані Ready 
					mediaPlayer=mediaPlayer2;
					System.out.println(volumeSlider.getValue());
					mediaPlayer.setVolume(volumeSlider.getValue()/100);
					/*визначаємо загальний час звучання пісні і відповідно нього
			  		встановлюємо максимальне значення повзунка*/
			  		totalTime=mediaPlayer.getTotalDuration().toSeconds();
			  		progressSlider.setMax(totalTime);
			  		putCurrentTime();
					//об'єкту mediaView передаємо створений mediaPlayer
					mediaView.setMediaPlayer(mediaPlayer);
					mediaPlayer.play();
					
				}
			else {
				if(f!=null)	{
					mediaPlayer=mediaPlayer2;
				
					/*визначаємо загальний час звучання пісні і відповідно нього
			  		встановлюємо максимальне значення повзунка*/
			  		totalTime=mediaPlayer.getTotalDuration().toSeconds();
			  		progressSlider.setMax(totalTime);
			  		putCurrentTime();
					//об'єкту mediaView передаємо створений mediaPlayer
			  		mediaView.setMediaPlayer(mediaPlayer);
					mediaPlayer.play();
				}
			}
			
		}
		
		if(pauseTgbtn.isSelected()) {
			if (mediaPlayer!=null) {
				mediaPlayer.pause();
				
		  		progressSlider.setValue(currentTime);
			}
			
		}
		if(stopTgbtn.isSelected()) {
			if (mediaPlayer!=null) {
				mediaPlayer.stop();
				progressSlider.setValue(0);
			}
		}
	}
	@FXML public void onMousePressedListView() {
		if (list.getSelectionModel().getSelectedItem()!=null) {	
			//Змінній f присвоюємо значення вибраного зі списку файлу пісні 
			f=list.getSelectionModel().getSelectedItem().fileTrack;
			//створюємо новий об'єкт media за вибраниою піснею 
			media = new Media(f.toURI().toString());
			//створюємо новий медіаплеєр
	  		mediaPlayer2= new MediaPlayer(media);
	  		System.out.println(mediaPlayer2);
			//відображаємо назву пісні в Label nameFile 
	  		nameFile.setText(f.getName());
		}
	}
	//метод обробник події переміщення повзунка часу програвання пісні (прокрутка треку)
	@FXML public void dragSlider() {
		progressSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				mediaPlayer.seek(Duration.seconds((double) newValue));
				String strTime=timeFormater((double)newValue)+ " / "+timeFormater(totalTime);
				timeLabel.setText(strTime);
			}
		});
	}
	//метод обробник події переміщення повзунка гучності звуку
	@FXML public void dragVolume() {
		volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
			//	System.out.println(newValue);
				mediaPlayer.setVolume((double) newValue/100);
				
			}
	     });
	}
	
	
}
