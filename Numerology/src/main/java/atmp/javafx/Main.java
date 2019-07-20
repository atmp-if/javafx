package atmp.javafx;

public class Main {

	public static void main(String[] args) {
		int day = 15, month = 10, year = 2003;
		int sDay = day / 10 + day % 10;
		int sMonth = month / 10 + month % 10;
		int sYear = year / 1000 + year % 1000 /100 + year % 100 /10 + year % 10;
		int happyCh = sDay + sMonth + sYear;
		System.out.println(happyCh);
	}

}
