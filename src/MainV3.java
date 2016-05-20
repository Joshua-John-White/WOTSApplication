import java.util.Scanner;
import javax.swing.*;
import java.awt.FlowLayout;

public class MainV3 {

	public static void main(String[] args) {

		Scanner user_input = new Scanner(System.in);

		String v;
		String w;

		System.out.println("Please enter User Name: ");
		v = user_input.next();
		System.out.println("Please enter Password:");
		w = user_input.next();

		user_input.close();

		
		if (v.equals("a") && w.equals("b")) {

									
			// creats an instance of the class DBConnect
			// Will try to load class

			OrdersV3 connect = new OrdersV3();

			connect.getDataO();

			//connect.giveDataO();

			//connect.getDataO();

			// ------------------------------------------------------------------------
			CustomersV3 connectcust = new CustomersV3();

			connectcust.getDataC();

			// ------------------------------------------------------------------------

			StockV3 connectstock = new StockV3();

			connectstock.getDataS();

			
			
		} else

			System.out.println("Wrong User Name or Password");

	}
		
}


