package srategy;

public class CardSrategy implements PaymentSrategy{

	private String name;
	private String cardNumber;
	private String CVV;
	private String dateOfExpiry;
	private double amount;
	
	public CardSrategy(String name, String cardNumber, String CVV, String dateOfExpiry, double amount) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.CVV = CVV;
		this.dateOfExpiry = dateOfExpiry;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCVV() {
		return CVV;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public double getAmount() {
		return amount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCVV(String CVV) {
		this.CVV = CVV;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public void pay() {
		System.out.printf("Pay %.2f with card\n", this.getAmount());
		
	}

}
