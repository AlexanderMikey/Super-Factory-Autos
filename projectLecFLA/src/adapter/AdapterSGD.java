package adapter;

import models.currency.IDR;
import models.currency.SGD;

public class AdapterSGD extends IDR {
	
	private SGD sgd;

	public AdapterSGD(double price, SGD sgd) {
		super(price);
		this.sgd = sgd;
		this.sgd.setPrice((this.sgd.getPrice()/11000));
	}

	@Override
	public double getPrice() {
		return this.sgd.getPrice();
	}

	@Override
	public String getCurrency() {
		return this.sgd.getCurrency();
	}
	
}
