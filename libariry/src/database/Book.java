package database;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	String id;
	String name;
	String author;
	String brand;
	String press;
	String time;
	double price;
	String local;
	int freuency=0;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		
	
	}
	public Book(String id, String name, String author, String brand, String press, String time, double  price,
			String local) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.brand = brand;
		this.press = press;
		this.time = time;
		this.price = price;
		this.local = local;
	}
	
	public Book(String id, String name, String author, String brand, String press, String time, double price,
			String local, int freuency) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.brand = brand;
		this.press = press;
		this.time = time;
		this.price = price;
		this.local = local;
		this.freuency = freuency;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getFreuency() {
		return freuency;
	}
	public void setFreuency(int freuency) {
		this.freuency = freuency;
	}
	

}
