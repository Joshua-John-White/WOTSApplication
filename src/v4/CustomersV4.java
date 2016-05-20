package v4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class CustomersV4 {

	// Help us connect to database
	private Connection con;
	// excute querys on table
	private Statement st;
	// hold all results achieved or returned by query
	private ResultSet rs;

	// constructor for class
	public CustomersV4() {
		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// make our connection
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/name of our database","user name",
			// "password");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/wotsapp", "root", "root");
			// creat a statement
			st = con.createStatement();

			// catchs error and displays to the user
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	// this will print the data from the data base
	public void getDataC() {

		try {
			// This will select the data from the table specified
			//String query = "select * from customer_order_list";
			// result set, so returns the data from the stated query
			//rs = st.executeQuery(query);

			//
			Scanner user_input = new Scanner(System.in);

			String custid;
		

			System.out.println("Please enter the order ID: ");
		
			custid = user_input.next();
		
			
			
			 String queryid = "SELECT * FROM wotsapp.customer_order_list WHERE OrderID = ' " + custid + " ' ";
	            rs = st.executeQuery(queryid);
			
			/**
			
			System.out.println(" Order ID: " + OrderID + " Status: " + Status + " Customer ID: " + CustomerID);
			String update = "UPDATE wotsapp.order_list SET Status = ' " + u_s + " ' WHERE OrderID = ' " + o_n	+ " ' ";
			st.executeUpdate(update);
			
			
			
			*/
			
			System.out.println("Customer Order");

			System.out.println("Line ID: " + " Order ID: " + " Item ID: " + " Pourous Ware: " + " Quantity: ");
			
			
			
			user_input.close();
			
			// this while loop stats that while there are records in the results
			// sect, (rs), it will do the action
			while (rs.next()) {

				// collects the data from the data base
				String LineID = rs.getString("LineID");
				String OrderID = rs.getString("OrderID");
				String ItemID = rs.getString("ItemID");
				String Pourousware = rs.getString("Pourousware");
				String Quantity = rs.getString("Quantity");
				
				
				
				System.out.println("     " + LineID + "         " + OrderID + "          " + ItemID + "          " + Pourousware + "           " + Quantity);
			}

			// creats error print out to screen
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}

	
