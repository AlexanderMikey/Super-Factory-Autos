package adapter;

import models.currency.IDR;
import models.currency.MYR;

public class AdapterMYR extends IDR {
	
	private MYR myr;

	public AdapterMYR(double price, MYR myr) {
		super(price);
		this.myr = myr;
		this.myr.setPrice(this.myr.getPrice()/3500);
	}

	@Override
	public double getPrice() {
		return this.myr.getPrice();
	}

	@Override
	public String getCurrency() {
		return this.myr.getCurrency();
	}
	
}
