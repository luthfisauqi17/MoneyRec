package moneyRec;

public class MoneyRecMessage { // Polymorphism**
	void message()
	{
		System.out.println("Please wait...");
	}
}

class Success extends MoneyRecMessage { 
	void message()
	{
		System.out.println("Data stored successfully...");
	}
}

class Fail extends MoneyRecMessage {
	void message()
	{
		System.out.println("Fail to insert data to database");
	}
}