package atmp.javafx;

import java.util.Comparator;

public class ComA implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Dog)o1).age-((Dog)o2).age; 
	}

}
