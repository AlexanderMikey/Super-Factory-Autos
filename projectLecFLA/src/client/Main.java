package client;
import java.util.Scanner;

import facade.Facade;

public class Main {
	

	public Main() {
		int input = 0;
		int menu1 = 0;
		int menu2 = 0;
		Scanner sc = new Scanner(System.in);

		do {
			Facade.mainMenu();
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				input = -1;
			}
			sc.nextLine();

			if(input == 1) {
				do {
					Facade.vehicleMenu();
					try {
						menu1 = sc.nextInt();
					} catch (Exception e) {
						menu1 = -1;
					}
					sc.nextLine();

					if(menu1 == 1) {
						Facade.makePrototype();
					}

					else if(menu1 == 2) {
						Facade.makeProduct();
					}
					
					else if(menu1 == 3) {
						Facade.showVehicleList();
					}

					else if(menu1 == 4) {
						Facade.historyProduction();
					}

				} while (menu1 != 5);
			}

			else if(input == 2) {
				do {
					Facade.transactionMenu();
					try {
						menu2 = sc.nextInt();
					} catch (Exception e) {
						menu2 = -1;
					}
					sc.nextLine();

					if(menu2 == 1) {
						Facade.makeOrder();
					}

					else if(menu2 == 2) {
						Facade.historyTransaction();
					}

				} while (menu2 != 3);
			}

		} while (input != 3);
	}

	public static void main(String[] args) {
		new Main();
	}

}
