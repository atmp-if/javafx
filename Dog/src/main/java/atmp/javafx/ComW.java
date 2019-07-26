package atmp.javafx;

import java.util.Comparator;

public class ComW implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
			return ((Dog)o1).weight-((Dog)o2).weight;
	}

}
