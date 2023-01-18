package models.product;

public class ProductEvent {
	private int id;
	private ProductPrototype protoype;
	private int quantity;
	private String productionDate;
	
	public ProductEvent(ProductPrototype protoype, int quantity) {
		this.protoype = protoype;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public ProductPrototype getProtoype() {
		return protoype;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProtoype(ProductPrototype protoype) {
		this.protoype = protoype;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	
}
