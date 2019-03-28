package moneyRec;
import java.sql.*;
import java.text.DecimalFormat;

public class MoneyRecStatistic {
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	public double total = 0;
	public double totspen = 0;
	public double totinco = 0;
	
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	
	void createConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moneyrec", "root", "");
			st = con.createStatement();
		}
		catch (Exception ex) {
			System.out.println("Error connecting to database");
		}
	}
	
	public void totalIncome(String name)
	{
		try
		{
			createConnection();
			rs = st.executeQuery("SELECT * FROM "+name+" WHERE transaction = 'Income'");
			while(rs.next()) {
				double amount = rs.getDouble("Amount");
				totinco += amount;
				total += amount;
			}
			System.out.println("Total income: Rp."+totinco);
		}
		catch (Exception ex) {
			System.out.println("Error in displaying the total income");
		}
	}
	
	public void totalSpending(String name)
	{
		try
		{
			createConnection();
			rs = st.executeQuery("SELECT * FROM "+name+" WHERE transaction = 'Spending'");
			while(rs.next()) {
				double amount = rs.getDouble("Amount");
				totspen += amount;
				total += amount;
			}
			System.out.println("Total outcome: Rp."+totspen);
		}
		catch (Exception ex) {
			System.out.println("Error in displaying the total outcome");
		}
	}
	
	public double incomePresentage()
	{
		return (totinco/total)*100;
	}
	
	public double spenPresentage()
	{
		return (totspen/total)*100;
	}
	
	public void displayPresentage()
	{
		System.out.println("\n~~~Percentage~~~");
		System.out.println("Income presentage: "+numberFormat.format(incomePresentage())+"%");
		System.out.println("Spending presentage: "+numberFormat.format(spenPresentage())+"%");
	}
	
}
