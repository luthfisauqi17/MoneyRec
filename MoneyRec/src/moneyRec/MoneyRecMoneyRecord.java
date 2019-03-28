package moneyRec;
import java.sql.*;

public class MoneyRecMoneyRecord extends MoneyRecTrans {
	private Statement st;
	private ResultSet rs;
	private Connection con;
	
	
	
	
	// Viewing the record from the database
	public void viewRecord(String name)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moneyrec", "root", "");
			st = con.createStatement();
			String query = "SELECT * FROM "+name+";";
			rs = st.executeQuery(query);
			System.out.println("**/Record from database/**");
			while(rs.next())
			{
				int Id = rs.getInt("Id");
				String Transaction = rs.getString("Transaction");
				String Date = rs.getString("Date");
				double Amount = rs.getDouble("Amount");
				System.out.println(Id+" "+Transaction+" "+Date+" "+Amount);
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
		catch(Exception ex)
		{
			System.out.println("Record: "+ex);
		}
	}
}
