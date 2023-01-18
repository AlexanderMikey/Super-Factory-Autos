package models.currency;

public class IDR {
	
	private double price;
	private String currency;

	public IDR(double price) {
		this.price = price;
		this.currency = "IDR";
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
