package v4;

import java.util.Scanner;

public class MainV4 {

	public static void main(String[] args) {

		Scanner user_input = new Scanner(System.in);

		String v;
		String w;

		System.out.println("Please enter User Name: ");
		v = user_input.next();
		System.out.println("Please enter Password:");
		w = user_input.next();

		if (v.equals("a") && w.equals("a")) {

			String c;

			System.out
					.println("Please enter 'O' to view order table or 'S' to view stock table");
			c = user_input.next();

			

			if (c.equals("o") || c.equals("O")) {

				// creats an instance of the class DBConnect
				// Will try to load class

				OrdersV4 connect = new OrdersV4();

				connect.getDataO();

				String oup;
				
				System.out.println("Do you want to update an order status? If yes type 'Y', if no 'N'");
				oup = user_input.next();
				
				if (oup.equals("Y") || oup.equals("y")) {
				
				connect.giveDataO();

				connect.getDataO();
				}
				
				
				else {
				String v_o;
				
				
				System.out.println("Do you wish to view individual orders? If yes type 'Y' if no 'N'");
				v_o = user_input.next();
				user_input.close();
				if (v_o.equals("y") || v_o.equals("Y"))  {
								
				CustomersV4 connectcust = new CustomersV4();

				connectcust.getDataC();
				}
				
				else {
					
					System.out.println("You have not specified an option, please reload the system to make a selection");
					
				}
				
				
			}} else if (c.equals("s") || c.equals("S")) {

				// ------------------------------------------------------------------------

				StockV4 connectstock = new StockV4();

				connectstock.getDataS();

			}

			else

				System.out.println("Please enter O or S");

		} else

			System.out.println("Wrong User Name or Password");

	}

}
