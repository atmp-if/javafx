package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private final SimpleStringProperty name;
	private final SimpleStringProperty phone;
	private final SimpleStringProperty address;

	Phone(String name, String phone, String address) {
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.address = new SimpleStringProperty(address);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getPhone() {
		return phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public boolean isValidName() {
		Pattern ptN = Pattern.compile("[A-Z]+");
		Matcher n = ptN.matcher(getName());
		boolean fn = n.matches();
		return fn;
	}

	public boolean isValidPhone() {
		Pattern ptP = Pattern.compile("[0-9]+");
		Matcher p = ptP.matcher(getPhone());
		boolean fp = p.matches();
		return fp;
	}

	public boolean isValidAddress() {
		Pattern ptA = Pattern.compile("[a-z0-9]{1,}@{1}([a-z0-9]{1,}\\.)+[a-z]{1,3}");
		Matcher a = ptA.matcher(getAddress());
		boolean fa = a.matches();
		return fa;
	}
}