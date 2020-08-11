package coder.bar;

public class Food {
	private String name;
	private int id,price;
	
	public Food(String name, int id, int price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}
	
	
}
