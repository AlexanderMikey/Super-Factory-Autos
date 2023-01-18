package factory;

import models.product.type.Car;
import models.product.type.Type;

public class CarFactory implements TypeFactory{
	
	public Type createType() {
		return new Car();
	}
}
