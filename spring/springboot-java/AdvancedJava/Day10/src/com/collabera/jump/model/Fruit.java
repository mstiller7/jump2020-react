package com.collabera.jump.model;

public class Fruit {

	public Fruit(TASTE taste) {
		this.taste = taste;
	}
	
	private String color;
	
	private boolean hasSeeds;
	
	private int calories;
	
	private TASTE taste;

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isHasSeeds() {
		return hasSeeds;
	}

	public void setHasSeeds(boolean hasSeeds) {
		this.hasSeeds = hasSeeds;
	}

	public TASTE getTaste() {
		return taste;
	}

	
}
