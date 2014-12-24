package domain;

import java.io.Serializable;

public class Car implements Serializable {

	private String brand;
	private int maxspeed;
	private String color;
	
	public Car(){}
	public Car(String brand, int maxspeed, String color) {
		super();
		this.brand = brand;
		this.maxspeed = maxspeed;
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
