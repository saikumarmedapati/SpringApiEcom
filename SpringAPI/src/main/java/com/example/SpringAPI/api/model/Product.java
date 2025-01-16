package com.example.SpringAPI.api.model;

public class Product {
	
	private int id;
	private String name;
	private String category;
	private String brand;
	private int price;
	private int box;
	private int Quantity;
	private double total;
	private double discount;
	
	//constructor using fields
	public Product(int id, String name, String category, String brand, int price, int box, int quantity, double total,
			double discount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.box = box;
		Quantity = quantity;
		this.total = total;
		this.discount = discount;
	}
	
	public Product(int id, String name, String category, String brand, int price, int box) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.box = box;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBox() {
		return box;
	}

	public void setBox(int box) {
		this.box = box;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
