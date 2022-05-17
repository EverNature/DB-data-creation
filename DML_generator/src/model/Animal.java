package model;

public class Animal {

	int id;
	String name;
	boolean isInvasor;

	public Animal(int id, String name, boolean isInvasor) {
		this.id = id;
		this.name = name;
		this.isInvasor = isInvasor;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isInvasor() {
		return isInvasor;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", isInvasor=" + isInvasor +"]";
	}

}
