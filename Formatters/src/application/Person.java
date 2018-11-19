package application;

import java.time.LocalDate;
import java.lang.String;

public class Person {
	public String Surname;
	public String Name;
	public LocalDate Birtday;
	static Double Salary_ua;
	static Double Salary_lang;

	public static String transliter(String SN_ua) {
		String[] UK = { "a", "b", "v", "h", "g", "d", "e", "ie", "zh", "z", "y", "i", "yi", "y", "k", "l", "m", "n",
				"o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "", "yu", "ya" };
		String UA1 = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
		String SN_lg = "";
		SN_ua = SN_ua.toLowerCase();
		char[] chars = SN_ua.toCharArray();
		char[] charsUA = UA1.toCharArray();
		for (int i = 0; i <= (SN_ua.length() - 1); i++)
			for (int j = 0; j <= 32; j++)
				if (charsUA[j] == (chars[i])) {
					SN_lg = SN_lg + UK[j];
				}
		SN_lg = SN_lg.substring(0, 1).toUpperCase() + SN_lg.substring(1);

		return SN_lg;
	}
}
