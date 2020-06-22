package models;

public abstract class Person {

	private String name;
	
	protected Person(String name) {
		this.name = name;
	}
	
	public final String getName() {
		return this.name;
	}
	
}
