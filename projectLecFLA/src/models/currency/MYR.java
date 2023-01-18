package models.currency;

public class MYR {
	
	private double price;
	private String currency;

	public MYR(double price) {
		this.price = price;
		this.currency = "MYR";
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
