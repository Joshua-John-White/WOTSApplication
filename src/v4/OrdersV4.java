package v4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OrdersV4 {

	// Help us connect to database
	private Connection con;
	// excute querys on table
	private Statement st;
	// hold all results achieved or returned by query
	private ResultSet rs;

	// constructor for class
	public OrdersV4() {
		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// make our connection remebering the file location, username and password
			con = DriverManager.getConnection(	"jdbc:mysql://localhost:3306/wotsapp", "root", "root");
			
			// creat a statement
			st = con.createStatement();
					// catchs error and displays to the user
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	// this will print the data from the data base
	public void getDataO() {

		try {
			// This will select the data from the table specified
			String query = "select * from order_list";
			// result set, so returns the data from the stated query
			rs = st.executeQuery(query);

			System.out.println("List of Order's");

			// this while loop will grab the all of data and keep on displaying 
			while (rs.next()) {

				// collects the data from the data base
				String OrderID = rs.getString("OrderID");
				String Status = rs.getString("Status");
				String CustomerID = rs.getString("CustomerID");

				System.out.println(" Order ID: " + OrderID + " Status: " + Status + " Customer ID: " + CustomerID);
			}

			// creats error print out to screen
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// ---------------------------------------------------

	public void giveDataO() {

		try {

			Scanner user_input = new Scanner(System.in);

			String o_n;
			String u_s;

			System.out.println("Please enter the order number for the order you wish to update: ");
			o_n = user_input.next();
			System.out.println("Please enter the new order status: ");
			u_s = user_input.next();
			
			user_input.close();
						
			Statement st = con.createStatement();

			String update = "UPDATE wotsapp.customer_order_list SET Status = ' " + u_s + " ' WHERE OrderID = ' " + o_n	+ " ' ";
			st.executeUpdate(update);
		
		} catch (Exception ex) {
			
			System.out.println("Error " + ex);

		}
	}
}
