package v4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class StockV4 {

	// Help us connect to database
	private Connection con;
	// excute querys on table
	private Statement st;
	// hold all results achieved or returned by query
	private ResultSet rs;

	// constructor for class
	public StockV4() {
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
	public void getDataS() {

		try {
			// This will select the data from the table specified
			String query = "select * from stock_table";
			// result set, so returns the data from the stated query
			rs = st.executeQuery(query);

			System.out.println("Stock List");

			// this while loop stats that while there are records in the results
			// sect, (rs), it will do the action
			while (rs.next()) {

				// collects the data from the data base
				String ItemID = rs.getString("ItemID");
				String ItemName = rs.getString("ItemName");
				String ItemLocation= rs.getString("ItemLocation");
				String StockLevel = rs.getString("StockLevel");
					
				System.out.println(" Item ID: " + ItemID + " Item_Name: "+ ItemName + " Item Location: " + ItemLocation + " Stock Levels: " + StockLevel);
			}

			// creats error print out to screen
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// ---------------------------------------------------

}
