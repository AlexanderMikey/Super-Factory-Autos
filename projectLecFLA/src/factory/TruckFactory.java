package factory;

import models.product.type.Truck;
import models.product.type.Type;

public class TruckFactory implements TypeFactory{
	
	public Type createType() {
		return new Truck();
	}
}
