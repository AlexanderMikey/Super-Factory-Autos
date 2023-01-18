package prototype;

import models.product.Product;

public class CloneFactory {
	public Clone getClone(Product product) {
		return product.makeClone();
	}
}
