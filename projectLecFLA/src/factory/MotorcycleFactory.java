package factory;

import models.product.type.Motorcycle;
import models.product.type.Type;

public class MotorcycleFactory implements TypeFactory{
	
	public Type createType() {
		return new Motorcycle();
	}
}
