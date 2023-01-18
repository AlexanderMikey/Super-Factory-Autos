package models.product;

import prototype.Clone;

public class Product implements Clone {
	
	private int productID;
	private ProductPrototype detail;
	private String status;
	
	
	public Product(ProductPrototype detail, String status) {
		this.detail = detail;
		this.status = status;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public ProductPrototype getDetail() {
		return detail;
	}

	public void setDetail(ProductPrototype detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Clone makeClone() {
		Product product = null;
		
		try {
			product = (Product) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return product;
	}

}
