package builders;

import models.product.ProductPrototype;
import models.product.type.Type;

public class VehicleBuilder {
	private ProductPrototype prototype;
	
	public VehicleBuilder() {
		this.prototype = new ProductPrototype();
	}

	public VehicleBuilder addType(Type type) {
		this.prototype.setType(type);
		return this;
	}
	
	public VehicleBuilder addVehicleName(String name) {
		this.prototype.setName(name);
		return this;
	}

	public VehicleBuilder addColor(String color) {
		this.prototype.setColor(color);
		return this;
	}
	
	public VehicleBuilder addBody(String body) {
		this.prototype.setBody(body);
		return this;
	}
	
	public VehicleBuilder addEngine(String engine) {
		this.prototype.setEngine(engine);
		return this;
	}

	public VehicleBuilder addWheel(String wheel) {
		this.prototype.setWheel(wheel);
		return this;
	}

	public VehicleBuilder addCompressor(String compressor) {
		this.prototype.setCompressor(compressor);
		return this;
	}

	public VehicleBuilder addPrice(long price) {
		this.prototype.setPrice(price);
		return this;
	}

	public ProductPrototype build() {
		return this.prototype;
	}
}



