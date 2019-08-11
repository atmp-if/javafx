package atmp.javafx;

public class Book {
	 private String title;
	 private String autor;
	 private String year;
	 private String about;

	    public Book(String title, String autor, String year, String about) {
	        this.title = title;
	        this.autor = autor;
	        this.year = year;
	        this.about = about;
	    }
	    
	    public String toString(){
	    	return title+" "+autor+" "+year+" "+about;   
	    }

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}
	    


}
