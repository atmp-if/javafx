package atmp.javafx;

import javafx.scene.image.Image;

public enum Week {
	MONDAY(2, 0), TUESDAY(0, 3), 
	WEDNESDAY(2) {
		String occupation() {
			String zagolovok = name();
			String zagolovokUkr = this.toString();
			String sports = "\nСпорт - " + sport + "год";
			String res = zagolovok + "\n" + zagolovokUkr + "\n" + sports;
			return res;
		}

		Image setPic() {
			return new Image("/sport.jpg");
		}
	},
	THURSDAY(1, 1), FRIDAY(2, 2), 
	SATURDAY(3) {
		String occupation() {
			String zagolovok = name();
			String zagolovokUkr = this.toString();
			String sports = "\nСпорт - " + sport + "год";
			String res = zagolovok + "\n" + zagolovokUkr + "\n" + sports;
			return res;
		}

		Image setPic() {
			return new Image("/sport.jpg");
		}
	},
	SUNDAY {
		String occupation() {
			String zagolovok = name();
			String zagolovokUkr = this.toString();
			String res = zagolovok + "\n" + zagolovokUkr + "\n" + "\nУРА!!! Відпочинок!!!";

			return res;
		}

		Image setPic() {
			return new Image("/rest.jpg");
		}
	};/*
		 * оголошуються сім констант перерахування Week, 
		 * для середи, суботи і неділі
		 * метод occupation() перевизначений
		 */
	int mathematics;
	int physics;
	int sport;
	String day;

	Week() {
	}

	Week(int s) {
		this.sport = s;
	}

	Week(int m, int ph) {
		this.mathematics = m;
		this.physics = ph;
	}
	
	
	 @Override
	    public String toString() {
	        switch (this) {
	            case MONDAY:
	                return "ПОНЕДІЛОК";
	            case TUESDAY:
	                return "ВІВТОРОК";
	            case WEDNESDAY:
	                return "СЕРЕДА";
	            case THURSDAY:
	                return "ЧЕТВЕР";
	            case FRIDAY:
	                return "П'ЯТНИЦЯ";
	            case SATURDAY:
	                return "СУБОТА";
	        }
	        return "щось неможливе!";
	    }
	

	String occupation() {
		String zagolovok = name();
		String zagolovokUkr = this.toString();
		String matem = "\nМатематика - " + mathematics + "год";
		String phis = "\nФізика - " + physics + "год";

		String res = zagolovok + "\n" + zagolovokUkr + "\n" + matem + phis;
		return res;
	}

	Image setPic() {
		return null;
	}	

}
