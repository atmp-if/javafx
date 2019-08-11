package atmp.javafx;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*	клас Track посиненн імплементувати інтерфейс Serializable,
	оскіль необхідно буде в подальшому записувати об'єкти класу
	у файл власного списку*/
public class Track implements Serializable{
	String name;
	File fileTrack;
	Track(File file){
		fileTrack = file;
		name = file.getName();
		
	}
	public String toString(){
		String str = name;
		return str;
	}
	static ArrayList <Track> toTrackList(List <File> list){
		ArrayList <Track> arr =new ArrayList<Track>();
		for (File x:list) {
			Track temp = new Track(x);
			arr.add(temp);
		}
	return arr;
	}
}
