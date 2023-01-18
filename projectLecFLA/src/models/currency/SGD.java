package models.currency;

public class SGD {
	
	private double price;
	private String currency;

	public SGD(double price) {
		this.price = price;
		this.currency = "SGD";
	}

	public double getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
