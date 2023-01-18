package srategy;

import models.currency.IDR;

public class CashSrategy implements PaymentSrategy{

	private String id;
	private IDR idr;
	
	public CashSrategy(String id, IDR idr) {
		this.id = id;
		this.idr = idr;
	}

	public String getId() {
		return id;
	}

	public IDR getIDR() {
		return idr;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIDR(IDR idr) {
		this.idr = idr;
	}

	@Override
	public void pay() {
		System.out.printf("Pay %.2f %s with cash\n", this.idr.getPrice(), this.idr.getCurrency());
		
	}

}
