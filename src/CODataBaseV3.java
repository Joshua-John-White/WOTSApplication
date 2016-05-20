import java.sql.*;


public class CODataBaseV3 {

	// Help us connect to database
	private Connection con;
	// excute querys on table
	private Statement st;
	// hold all results achieved or returned by query
	private ResultSet rs;

	// constructor for class
	public CODataBaseV3() {
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
	public void getDataCO() {

		try {
			// This will select the data from the table specified
			String query = "select * from customer_order";
			// result set, so returns the data from the stated query
			rs = st.executeQuery(query);

			System.out.println("Customer order information");

			// this while loop stats that while there are records in the results
			// sect, (rs), it will do the action
			while (rs.next()) {

				// collects the data from the data base
				String Order_ID = rs.getString("Order ID");
				String Status = rs.getString("Status");
				String Customer_ID = rs.getString("Customer ID");

				System.out.println(" Order ID: " + Order_ID + " Status: "
						+ Status + " Customer ID: " + Customer_ID);
			}

			// creats error print out to screen
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// ---------------------------------------------------

	public void giveDataCO() {

		try {

			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO customer_order " + "VALUES (2,'b',2)");
		}

		catch (Exception ex) {
			System.out.println("Error " + ex);

		}
	}
}
