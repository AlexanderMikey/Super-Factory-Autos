package facade;

import java.util.ArrayList;
import java.util.Scanner;

import adapter.AdapterMYR;
import adapter.AdapterSGD;
import builders.VehicleBuilder;
import factory.CarFactory;
import factory.MotorcycleFactory;
import factory.TruckFactory;
import factory.TypeFactory;
import iterator.FIFO;
import iterator.Iterator;
import models.currency.IDR;
import models.currency.MYR;
import models.currency.SGD;
import models.order.Customer;
import models.order.Transaction;
import models.product.Product;
import models.product.type.Type;
import models.product.ProductEvent;
import models.product.ProductPrototype;
import prototype.CloneFactory;
import singleton.Database;
import srategy.CardSrategy;
import srategy.CashSrategy;
import srategy.PaymentSrategy;

public class Facade {

	private static Scanner sc = new Scanner(System.in);
	private static Database db =  Database.getInstance();
	private static ArrayList<String> menus;
	private static Iterator<String> menu;

	public static void mainMenu() {
		menus = new ArrayList<>();
		menus.add("Vehicle");
		menus.add("Order");
		menus.add("Exit");

		menu = new FIFO<>(menus);

		System.out.println();
		System.out.println("Welcome to Super Factory Autos");
		System.out.println("==============================");
		int counter = 1;
		while(menu.hasNext()) {
			System.out.println(counter + ". " + menu.getNext());
			counter++;
		}
		System.out.print(">> ");
	}

	public static void vehicleMenu() {
		menus = new ArrayList<>();
		menus.add("Make a Prototype");
		menus.add("Make Product");
		menus.add("Show Vehicle List");
		menus.add("History Production");
		menus.add("Back");

		menu = new FIFO<>(menus);

		System.out.println();
		System.out.println("Super Factory Autos");
		System.out.println("==============================");
		int counter = 1;
		while(menu.hasNext()) {
			System.out.println(counter + ". " + menu.getNext());
			counter++;
		}
		System.out.print(">> ");
	}

	public static void transactionMenu() {
		menus = new ArrayList<>();
		menus.add("Make an Order");
		menus.add("Show Order History");
		menus.add("Back");

		menu = new FIFO<>(menus);

		System.out.println();
		System.out.println("Super Factory Autos");
		System.out.println("==============================");

		int counter = 1;
		while(menu.hasNext()) {
			System.out.println(counter + ". " + menu.getNext());
			counter++;
		}
		System.out.print(">> ");
	}

	public static void makePrototype() {
		String t;
		String vehicleName;
		String color;
		String body ;
		String engine;
		String wheel;
		String compressor;
		long price = 0;
		TypeFactory factory = null;
		Type type = null;
		ProductPrototype prototype = null;

		System.out.println();
		do {
			System.out.print("Input vehicle type [Motorcycle | Car | Truck]: ");
			t = sc.nextLine();
		} while (!t.equalsIgnoreCase("Motorcycle") && !t.equalsIgnoreCase("Car") && !t.equalsIgnoreCase("Truck"));

		if(t.equalsIgnoreCase("Motorcycle")) {
			factory = new MotorcycleFactory();
			type = factory.createType();
		}

		else if(t.equalsIgnoreCase("Car")) {
			factory = new CarFactory();
			type = factory.createType();
		}

		else if(t.equalsIgnoreCase("Truck")) {
			factory = new TruckFactory();
			type = factory.createType();
		}

		do {
			System.out.print("Input vehicle name: ");
			vehicleName = sc.nextLine();
		} while (vehicleName.length() < 1);

		do {
			System.out.print("Input vehicle color: ");
			color = sc.nextLine();
		} while (color.length() < 1);

		do {
			System.out.print("Input vehicle body: ");
			body = sc.nextLine();
		} while (body.length() < 1);

		do {
			System.out.print("Input vehicle engine: ");
			engine = sc.nextLine();
		} while (engine.length() < 1);

		do {
			System.out.print("Input vehicle wheel: ");
			wheel = sc.nextLine();
		} while (wheel.length() < 1);

		System.out.print("Input vehicle compressor: ");
		compressor = sc.nextLine();

		do {
			System.out.print("Input vehicle Price [>=1000000]: ");
			try {
				price = sc.nextLong();
			} catch (Exception e) {
				price = -1;
			}
			sc.nextLine();
		} while (price < 1000000);

		if(compressor.equalsIgnoreCase(null)) {
			prototype = new VehicleBuilder().addType(type).addVehicleName(vehicleName).addColor(color)
					.addBody(body).addEngine(engine).addWheel(wheel).addPrice(price).build();
		}
		else {
			prototype = new VehicleBuilder().addType(type).addVehicleName(vehicleName).addColor(color)
					.addBody(body).addEngine(engine).addWheel(wheel).addCompressor(compressor).addPrice(price).build();
		}
		db.addPrototypeList(prototype);
	}

	public static void makeProduct() {
		int index = -1;
		int quantity = -1;
		System.out.println();
		db.showPrototypeList();

		if(db.getPrototypeList().size() == 0) {
			System.out.println("Press enter to continue...");
			sc.nextLine();
			return;
		}

		do {
			System.out.print("Choose prototype: ");
			try {
				index = sc.nextInt();
			} catch (Exception e) {
				index = -1;
			}
			sc.nextLine();

		} while (index > db.getPrototypeList().size() || index < 1);

		do {
			System.out.print("How many vehicle wan't to make: ");
			try {
				quantity = sc.nextInt();
			} catch (Exception e) {
				quantity = -1;
			}
			sc.nextLine();

		} while (quantity <= 0);

		Product product = new Product(db.getPrototypeList().get(index - 1), "Available");

		ProductEvent history = new ProductEvent(db.getPrototypeList().get(index - 1), quantity);
		db.addProductionEvent(history);

		for (int i = 0; i < quantity; i++) {
			CloneFactory cloneProduct = new CloneFactory();
			db.addProductList((Product)cloneProduct.getClone(product));
		}

		System.out.println();
		System.out.println(quantity + " vehicle has been made");
		System.out.println("Press enter to continue...");
		sc.nextLine();

	}
	
	public static void showVehicleList() {
		System.out.println();
		db.showProductList();
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}

	public static void historyProduction() {
		System.out.println();
		db.showHistoryProductions();
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}

	public static void makeOrder() {
		String id;
		String name = "";
		String address = "";
		String paymentMethod = "";
		Customer customer = null;
		IDR cash = null;
		PaymentSrategy payment = null; 

		System.out.println();
		ArrayList<Product> temp = db.showProductAvailable();
		int available = temp.size();
		int index = -1;

		if(available > 0) {
			do {
				System.out.print("Which vehicle you wan't buy: ");
				try {
					index = sc.nextInt();
				} catch (Exception e) {
					index = -1;
				}
				sc.nextLine();

			} while (index > temp.size() || index < 1);
			db.changeStatus(temp.get(index - 1).getProductID());

			do {
				System.out.print("Input customer id: ");
				id = sc.nextLine();
			} while (id.length() < 1);

			int indexCustomer = db.checkCustomerId(id);
			
			if (indexCustomer == -1) {
				do {
					System.out.print("Input customer name: ");
					name = sc.nextLine();
				} while (name.length() < 1);
				do {
					System.out.print("Input customer address: ");
					address = sc.nextLine();
				} while (address.length() < 1);
				
				customer = new Customer(id, name, address);
				db.addCustomer(customer);
			} 

			else {
				customer = db.getCustomerList().get(indexCustomer);
			}
			
			do {
				System.out.print("Input payment method [Cash | Card]: ");
				paymentMethod = sc.nextLine();
			} while (!paymentMethod.equalsIgnoreCase("Cash") && !paymentMethod.equalsIgnoreCase("Card"));

			
			if (paymentMethod.equalsIgnoreCase("Cash")) {
				String currency;
				do {
					System.out.print("Input payment method [IDR | SGD | MYR]: ");
					currency = sc.nextLine();
				} while (!currency.equalsIgnoreCase("IDR") && !currency.equalsIgnoreCase("SGD") && !currency.equalsIgnoreCase("MYR"));
				
				if(currency.equalsIgnoreCase("IDR")) {
					cash = new IDR(db.getProductList().get(index - 1).getDetail().getPrice());
					payment = new CashSrategy(id, cash);
				}
				
				else if(currency.equalsIgnoreCase("SGD")) {
					SGD sgd = new SGD(db.getProductList().get(index - 1).getDetail().getPrice());
					cash = new AdapterSGD(sgd.getPrice(), sgd);
					payment = new CashSrategy(id, cash);
				}
				
				else if(currency.equalsIgnoreCase("MYR")) {
					MYR sgd = new MYR(db.getProductList().get(index - 1).getDetail().getPrice());
					cash = new AdapterMYR(sgd.getPrice(), sgd);
					payment = new CashSrategy(id, cash);
				}

			}

			else if (paymentMethod.equalsIgnoreCase("Card")) {
				String cardNumber;
				String CVV;
				String dateOfExpiry;
				int month;
				int year;

				do {
					System.out.print("Input card number: ");
					cardNumber = sc.nextLine();
				} while (cardNumber.length() < 1 || !hasNumber(cardNumber));

				do {
					System.out.print("Input CVV [3 digit]: ");
					CVV = sc.nextLine();
				} while (CVV.length() < 3 || CVV.length() > 3);

				do {
					System.out.print("Input month expiry [1-12]: ");
					try {
						month = sc.nextInt();
					} catch (Exception e) {
						month = -1;
					}
					sc.nextLine();
				} while (month < 1 || month > 12);

				do {
					System.out.print("Input year expiry [>=23]: ");
					try {
						year = sc.nextInt();
					} catch (Exception e) {
						year = -1;
					}
					sc.nextLine();
				} while (year < 23);

				dateOfExpiry = String.format("%d/%d", month, year);

				payment = new CardSrategy(name, cardNumber, CVV, dateOfExpiry, db.getProductList().get(index - 1).getDetail().getPrice());
			}
			
			Transaction transaction = new Transaction(customer, db.getProductList().get(index - 1), payment);
			db.addTransaction(transaction);
			payment.pay();
		}
		
		System.out.println();
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}

	public static void historyTransaction() {
		System.out.println();
		db.showTransaction();
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}
	
	public static boolean hasNumber(String id) {
		for (int i = 0; i < id.length(); i++) {
			if(Character.isDigit(id.charAt(i))) {
				return true;
			}
		}
		return false;
	}

}
