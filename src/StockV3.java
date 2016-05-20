import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class StockV3 extends JFrame{

	// Help us connect to database
	private Connection con;
	// excute querys on table
	private Statement st;
	// hold all results achieved or returned by query
	private ResultSet rs;

	// constructor for class
	public StockV3() {
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
				String Item_ID = rs.getString("Item ID");
				String Item_Name = rs.getString("Item Name");
				String Item_Location= rs.getString("Item Location");
				String Stock_Level = rs.getString("Stock Level");
				
				JLabel jblStockList = new JLabel(" Item ID: " + Item_ID + " Item_Name: "
						+ Item_Name + " Item Location: " + Item_Location + " Stock Levels: " + Stock_Level);
				
				add(jblStockList);
				
				this.setSize(600,600);
				
				setVisible(true);
				
				//System.out.println(" Item ID: " + Item_ID + " Item_Name: "
						//+ Item_Name + " Item Location: " + Item_Location + " Stock Levels: " + Stock_Level);
			}

			// creats error print out to screen
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// ---------------------------------------------------

}
