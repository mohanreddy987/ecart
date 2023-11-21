package com.ecart.pojo;

import java.util.Map;

public abstract class Product {

	private Long id;
	private String catalog;
	private String name;
	private double price;
	private int inStock;
	private String description;
	private String imageName;
	private Map<String, String> properties;
	
	
	
	public Product(Long id, String catalog, String name,double price, int inStock, String description, String imageName,
			Map<String, String> properties) {
		super();
		this.id = id;
		this.catalog = catalog;
		this.price = price;
		this.inStock = inStock;
		this.description = description;
		this.imageName = imageName;
		this.properties = properties;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Map<String, String> loadProperties(String metaInfo){
		// Implementation is present in the Child Classes.
		return null;
	}
}
