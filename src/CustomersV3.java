import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CustomersV3 {

	// Help us connect to database
	private Connection con;
	// excute querys on table
	private Statement st;
	// hold all results achieved or returned by query
	private ResultSet rs;

	// constructor for class
	public CustomersV3() {
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
			String query = "select * from customer_order_list";
			// result set, so returns the data from the stated query
			rs = st.executeQuery(query);

			System.out.println("Customer Order");

			// this while loop stats that while there are records in the results
			// sect, (rs), it will do the action
			while (rs.next()) {

				// collects the data from the data base
				String Line_ID = rs.getString("Line ID");
				String Order_ID = rs.getString("Order ID");
				String Item_ID = rs.getString("Item ID");
				String Pourous_ware = rs.getString("Pourous ware");
				String Quantity = rs.getString("Quantity");
				
				System.out.println("Line ID: " + Line_ID + "Order ID: " + Order_ID + " Item ID: "
						+ Item_ID + " Pourous Ware: " + Pourous_ware + "Quantity: " + Quantity);
			}

			// creats error print out to screen
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}

	
