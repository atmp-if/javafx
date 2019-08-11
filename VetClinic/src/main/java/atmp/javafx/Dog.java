package atmp.javafx;

public class Dog extends Animal{

	public Dog(String name, int age, String breed, int weight, Owner owner) {
		super(name, age, breed, weight, owner);
		
	}
	@Override
	public String toString() {
	
		return "Собака - " + super.toString();
	}

}
