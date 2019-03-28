package moneyRec;
import java.sql.*; // this class is for establish connection, execute statement to Database

public class MoneyRecAccount {
	private Connection con; // this object is to connect java to the database
	private Statement st; // this object to process the database query
	private ResultSet rs; // this object is to representing a database result set
	private DatabaseMetaData dbm; // this object used for checking my local base
	private int sc; // checking whether the user name exist in the database
	
	
	
	
	// Making connection to my local database
	public void getConnection()
	{
		try
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/moneyrec";
			String user = "root";
			String password = "";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception ex)
		{
			System.out.println("Failed to connect to database");
		}
	}
	
	
	
	
	//Checking if the user name exist or not
	public void checkAccount(String accName)
	{
		try
		{
			getConnection();
			dbm = con.getMetaData();
			rs = dbm.getTables(null, null, accName, null);
			if(rs.next())
			{
				sc = 1;
			}
			else 
			{
				sc = 0;
			}
		}
		catch(Exception ex)
		{
			System.out.println("There something wrong in the database");
		}
	}
	
	public int getSc()
	{
		return sc;
	}
	
	
	
	
	//Create new user name 
	public void createAccount(String accCre)
	{
		try
		{
			getConnection();
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE "+accCre+" (Id INT NOT NULL AUTO_INCREMENT,Transaction VARCHAR(50),Date VARCHAR(50),Account VARCHAR(50),Category VARCHAR(50),Amount double,Content VARCHAR(50),Note VARCHAR(250),CONSTRAINT PKId PRIMARY KEY(Id));");
			System.out.println("Username created succesfully");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
		catch(Exception ex)
		{
			System.out.println("Failed to create new user");
		}
	}
	
	
	
	
	//Login success in case there is exist the user name
	public void login ()
	{
		if(sc == 1)
		{
			System.out.println("Login Success");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
		else 
		{
			System.out.println("Login failed, No such Username. Please Sign Up");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
	}
}
