package moneyRec;
import java.sql.*;
import java.util.Date;

public class MoneyRecTrans extends MoneyRecAccount{ // Inheritance**
	// Encapsulation**
	private String trans; // Variable for transaction**
	private String cat; // Variable for category**
	private String acco; // Variable for account**
	private String cont; // Variable for content**
	private String note; // Variable for note**
	private double monA; // Variable for the amount of the money**
	private static Connection con;
	private static Statement st;
	
	String catArray[] = {"food","Social Life","Self-development","Transportation","Culture","Household","Apparel","Beauty","Health","Education","Gift","Other"}; // Array for category
	String accoArray[] = {"Cash","Accounts","Card"}; // Array for account**
	
	
	// Message object instantiation
	MoneyRecMessage fl = new Fail();
	MoneyRecMessage scs = new Success();
	
	
	// Date object instantiation
	Date d = new Date(); 
	
	
	
	
	// Transaction 
	public void transaction(int choice)
	{
		if(choice==1) this.trans = "Spending"; // Conditional**
		else this.trans = "Income";
	}
	
	public String getTrans()
	{
		return trans;
	}
	
	
	
	
	// Category
	public void category(int choice)
	{
		if(choice==1) this.cat = catArray[0];
		else if(choice==2) this.cat = catArray[1];
		else if(choice==3) this.cat = catArray[2];
		else if(choice==4) this.cat = catArray[3];
		else if(choice==5) this.cat = catArray[4];
		else if(choice==6) this.cat = catArray[5];
		else if(choice==7) this.cat = catArray[6];
		else if(choice==8) this.cat = catArray[7];
		else if(choice==9) this.cat = catArray[8];
		else if(choice==10) this.cat = catArray[9];
		else if(choice==11) this.cat = catArray[10];
		else this.cat = catArray[11];
	}
	
	public String getCat()
	{
		return cat;
	}
	
	
	
	
	// Account
	public void account(int choice)
	{
		if(choice==1) this.acco = accoArray[0];
		else if(choice==2) this.acco = accoArray[1];
		else this.acco = accoArray[2]; 
	}
	
	public String getAcco()
	{
		return acco;
	}
	
	
	
	
	// Content
	public void content(String input)
	{
		this.cont = input;
	}
	
	public String getCon()
	{
		return cont;
	}
	
	
	
	
	// The Amount of Money
	public void moneyAmount(double monA)
	{
		this.monA = monA;
	}
	
	public void moneyAmount(double monA, int conA)
	{
		double totA = monA * conA;
		this.monA = totA;
	}
	
	public double getAmount()
	{
		return monA;
	}
	
	
	
	
	// Note
	public void note(String note)
	{
		this.note = note;
	}
	
	public String getNote()
	{
		return note;
	}
	
	
	
	
	// Insert all the values into my local database
	public void insert(String name)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moneyrec", "root", "");
			st = con.createStatement();
			st.executeUpdate("INSERT INTO "+name+"(Transaction, Date, Account, Category, Amount, Content, Note) VALUES ('"+getTrans()+"','"+d+"','"+getAcco()+"','"+getCat()+"','"+getAmount()+"','"+getCon()+"','"+getNote()+"');");
			scs.message();
		}
		catch(Exception ex)
		{
			fl.message();
		}
	}
}
