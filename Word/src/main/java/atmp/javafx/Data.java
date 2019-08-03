package atmp.javafx;

public class Data {

    private String enWord ;
    private String uaWord ;

    public Data (String en, String ua){
        enWord = en;
        uaWord = ua;
    }

    public String getEn() {
        return this.enWord;
    }


    public String getUa() {
        return uaWord;
    }

}
