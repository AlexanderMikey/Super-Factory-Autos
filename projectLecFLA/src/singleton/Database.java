package singleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import iterator.FIFO;
import iterator.Iterator;
import models.order.Customer;
import models.order.Transaction;
import models.product.Product;
import models.product.ProductEvent;
import models.product.ProductPrototype;

public class Database {

	private static volatile Database instance = null;
	private ArrayList<Customer> customerList;
	private ArrayList<ProductPrototype> prototypeList;
	private ArrayList<Product> productList;
	private ArrayList<Transaction> transactionList;
	private ArrayList<ProductEvent> historyProductions;

	private Database() {
		this.customerList = new ArrayList<>();
		this.prototypeList = new ArrayList<>();
		this.productList = new ArrayList<>();
		this.transactionList = new ArrayList<>();
		this.historyProductions = new ArrayList<>();
	}

	public static synchronized Database getInstance() {
		return instance = (instance == null) ? new Database() : instance;
	}

	public void addPrototypeList(ProductPrototype prototype) {
		prototype.setId(this.getPrototypeList().size() + 1);
		prototypeList.add(prototype);
	}

	public void addProductList(Product product) {
		product.setProductID(this.getProductList().size() + 1);
		productList.add(product);
	}

	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
	}

	public void addTransaction(Transaction transaction) {
		transaction.setDate(dateNow());
		this.transactionList.add(transaction);
	}

	public void addProductionEvent(ProductEvent history) {
		history.setId(this.getHistoryProductions().size() + 1);
		history.setProductionDate(dateNow());
		this.historyProductions.add(history);
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public ArrayList<ProductPrototype> getPrototypeList() {
		return prototypeList;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public ArrayList<ProductEvent> getHistoryProductions() {
		return historyProductions;
	}

	public String dateNow() {
		Date d = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("d-M-Y");
		return formatDate.format(d);
	}

	public void showPrototypeList() {
		if(this.getPrototypeList().isEmpty()) {
			System.out.println("No prototype available");
		}

		else {
			System.out.println("================================================================================================================================================================");
			System.out.println("| No. | Prototype ID | Product Name         | Type         | Color         | Body         | Enginee              | Wheel         | Compressor   | Price        |");
			System.out.println("================================================================================================================================================================");
			int i = 1;
			Iterator<ProductPrototype> list = new FIFO<>(this.getPrototypeList());

			while(list.hasNext()) {
				ProductPrototype prototype = list.getNext();
				System.out.printf("| %-3d | %-12s | %-20s | %-12s | %-13s | %-12s | %-20s | %-13s | %-12s | %-12d |\n", i, prototype.getId(), prototype.getName(), prototype.getType().getname(), prototype.getColor(), prototype.getBody(), prototype.getEngine(), prototype.getWheel(), prototype.getCompressor(), prototype.getPrice());
				i++;
			}
			System.out.println("================================================================================================================================================================");
		}
	}

	public void showProductList() {
		if(this.getProductList().isEmpty()) {
			System.out.println("No product available");
		}

		else {
			System.out.println("=========================================================================");
			System.out.println("| No. | Product ID | Product Name         | Price        | Status       |");
			System.out.println("=========================================================================");
			int i = 1;
			Iterator<Product> list = new FIFO<>(this.getProductList());

			while(list.hasNext()) {
				Product product = list.getNext();
				System.out.printf("| %-3d | %-10d | %-20s | %-12d | %-12s |\n", i, product.getProductID(), product.getDetail().getName(), product.getDetail().getPrice(),product.getStatus());
				i++;
			}
			System.out.println("=========================================================================");
		}
		System.out.println();
	}

	public ArrayList<Product> showProductAvailable() {
		ArrayList<Product> temp = new ArrayList<>();
		Iterator<Product> list;
		
		if(this.getProductList().isEmpty()) {
			System.out.println("No product available");
		}

		else {
			list = new FIFO<>(this.getProductList());
			while(list.hasNext()) {
				Product product = list.getNext();
				if(product.getStatus().equalsIgnoreCase("Available")) {
					temp.add(product);
				}
			}
			if(temp.size() > 0) {
				list = new FIFO<>(this.getProductList());
				System.out.println("==========================================================");
				System.out.println("| No. | Product ID | Product Name         | Price        |");
				System.out.println("==========================================================");
				int i = 1;
				
				while(list.hasNext()) {
					Product product = list.getNext();
					if(product.getStatus().equalsIgnoreCase("Available")) {
						System.out.printf("| %-3d | %-10d | %-20s | %-12d |\n", i, product.getProductID(), product.getDetail().getName(), product.getDetail().getPrice());
						i++;
					}
				}
				System.out.println("==========================================================");
			}
			else if(temp.size() <= 0) {
				System.out.println("No product available");
			}
			System.out.println();
		}
		return temp;
	}

	public void showTransaction() {
		if(this.getTransactionList().isEmpty()) {
			System.out.println("No transaction has been made");
		}
		else {
			System.out.println("============================================================================");
			System.out.println("| No. | Customer ID   | Customer Name    | Product Name | Transaction Date |");
			System.out.println("============================================================================");
			int i = 1;
			Iterator<Transaction> list = new FIFO<>(this.getTransactionList());

			while(list.hasNext()) {
				Transaction transaction = list.getNext();
				System.out.printf("| %-3d | %-13s | %-16s | %-12s | %-16s |\n", i, transaction.getCustomer().getId(), transaction.getCustomer().getName(), transaction.getProduct().getDetail().getName(), transaction.getDate());
				i++;
			}
			System.out.println("============================================================================");
		}
		System.out.println();
	}

	public void showHistoryProductions() {
		if(this.getHistoryProductions().isEmpty()) {
			System.out.println("No production has been made");
		}

		else {
			System.out.println("========================================================");
			System.out.println("| No. | Prototype ID   | Quantity    | Production Date |");
			System.out.println("========================================================");
			int i = 1;
			Iterator<ProductEvent> list = new FIFO<>(this.getHistoryProductions());

			while(list.hasNext()) {
				ProductEvent event = list.getNext();
				System.out.printf("| %-3d | %-14d | %-11s | %-15s |\n", i, event.getProtoype().getId(), event.getQuantity(), event.getProductionDate());
				i++;
			}
			System.out.println("========================================================");
		}
		System.out.println();
	}

	public int checkCustomerId(String id) {
		int counter = 0;
		Iterator<Customer> list = new FIFO<>(this.getCustomerList());
		while(list.hasNext()) {
			Customer customer = list.getNext();
			if(customer.getId().equalsIgnoreCase(id)) {
				return counter;
			}
			counter++;
		}

		return -1;
	}
	
	public void changeStatus(int id){
		Iterator<Product> list = new FIFO<>(this.getProductList());
		while(list.hasNext()) {
			Product product = list.getNext();
			if(product.getProductID() == id) {
				product.setStatus("Unavailable");
			}
		}
		
	}

}


