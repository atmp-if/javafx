package atmp.javafx;

public class Cat extends Animal{

	public Cat(String name, int age, String breed, int weight, Owner owner) {
		super(name, age, breed, weight, owner);
		
	}
	
	@Override
	public String toString() {
	
		return "Кішка - " + super.toString();
	}

}
