package atmp.javafx;

import java.io.Serializable;

public class Animal implements Serializable{
	String name;
	int age;
	String breed;
	int weight;
	Owner owner;
	public Animal(String name, int age, String breed, int weight, Owner owner) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.weight = weight;
		this.owner = owner;
	}
	
	public String toString() {
		return  name + " порода " + breed + " " + age + " років, вага "  + weight + owner.toString();
	}
}
