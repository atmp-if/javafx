package application;

public class Unspecified <T extends Comparable<T>> {
	private T[] masT;
	
	public void set(T[] t){
		masT=t;
	}
	
	public void sort() {
		for(int k=0;k<masT.length-1;k++)
			for(int i=0;i<masT.length-1;i++) {
				if(masT[i].compareTo(masT[i+1])>0) {
					T buf=masT[i];
					masT[i]=masT[i+1];
					masT[i+1]=buf;
				}
			}
		}
	
	public String printMas() {
		String rez=new String("");
		for(int i=0;i<masT.length;i++) {
			rez=rez+masT[i].toString()+"\n";
		}
		return rez;
	}
}
