package atmp.javafx;

public class Dog implements Comparable{
	String name;
	int age;
	int weight;
	public Dog(String name,	int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((Dog)o).name);
	}
	
	@Override
	public String toString() {
		return name + " вік: " + age + "  вага: " + weight;
	}
}
