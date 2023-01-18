package models.product;

import models.product.type.Type;

public class ProductPrototype {
	
	private int Id;
	private Type type;
	private String name;  
	private String color;
	private String body ;
	private String engine;
	private String wheel;
	private String compressor;
	private long price;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getEngine() {
		return engine;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public String getWheel() {
		return wheel;
	}
	
	public void setWheel(String wheel) {
		this.wheel = wheel;
	}
	
	public String getCompressor() {
		return compressor;
	}
	
	public void setCompressor(String compressor) {
		this.compressor = compressor;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
