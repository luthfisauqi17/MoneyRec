package moneyRec;

public class MoneyRecMoneyConverter {
	private double amount; // Variable for amount of money that inputed by the user
	
	
	
	
	// Getting the amount from the user and assign it to 'amount' variable
	public MoneyRecMoneyConverter(double amount)
	{
		this.amount = amount;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	
	
	
	// Convert dollar to Rupiah
	public double dollarTorp()
	{
		return getAmount() * 14251.25;
	}
	
	
	
	
	// Displaying the result of the converter
	public void display()
	{
		System.out.println("Dollar: $"+getAmount());
		System.out.println("Rupiah: Rp."+dollarTorp());
	}
	
}
