package moneyRec;
import java.util.Scanner; // importing Scanner class

public class MoneyRecRun {
	public static Scanner input; // Scanner object instantiation
	private static String accName; // Variable for name
	
	
	
	
	// Main Method
	public static void main(String args[])
	{
		input = new Scanner(System.in); // Scanner**
		
		
		// Object**
		MoneyRecMoneyRecord acc = new MoneyRecMoneyRecord();
		
		
		
		
		//Log in 
		while(true) // Looping**
		{
			System.out.println("**/Welcome to MoneyRec/**");
			System.out.println("1. Log In\n2. Sign Up");
			int choice = input.nextInt();
			if(choice == 1)
			{
				System.out.println("Username");
				accName = input.next();
				acc.checkAccount(accName);
				acc.login();
				if(acc.getSc()==1)
				{
					break;
				}
				else continue;
			}
			else if(choice == 2)
			{
				System.out.println("Username");
				String accCre = input.next();
				acc.createAccount(accCre);
				continue;
			}
		}
		
		
		
		
		//Menu
		while(true)
		{
			System.out.println("***************************************");
			System.out.println("**/Welcome "+accName+"/**");
			System.out.println("1. New Transaction");
			System.out.println("2. Transaction Record");
			System.out.println("3. Statistic");
			System.out.println("4. Money Converter Dollar to Rupiah");
			System.out.println("5. About");
			System.out.println("6. Exit");
			int choice = input.nextInt();
			switch(choice)
			{
			case 1: 
				/* Kind of Transaction */
				System.out.println("What kind of transaction");
				System.out.println("1. Spending");
				System.out.println("2. Income");
				int transChoice = input.nextInt();
				acc.transaction(transChoice);
				
				/* Kind of Account */
				System.out.println("Category of Account");
				for(int i=0;i<acc.accoArray.length;i++) // This loop will generate the list from array
				{
					System.out.println((i+1)+". "+acc.accoArray[i]);
				}
				int accoChoice = input.nextInt();
				acc.account(accoChoice);
				
				/* Category of Transaction*/
				System.out.println("Category of transaction");
				for(int i=0;i<acc.catArray.length;i++) // This loop will generate the list from array
				{
					System.out.println((i+1)+". "+acc.catArray[i]);
				}
				int catChoice = input.nextInt();
				acc.category(catChoice);
				
				/* Calculating the money */
				System.out.println("do you buy one item or more than one item?");
				System.out.println("1. One item");
				System.out.println("2. More than one item");
				int itemAchoice = input.nextInt();
				if(itemAchoice==1)
				{
					System.out.println("The amount of money?");
					double moneyA = input.nextDouble();
					acc.moneyAmount(moneyA);
				}
				else
				{
					System.out.println("The amount of items");
					int amount = input.nextInt();
					System.out.println("The amount of money each item");
					double moneyA = input.nextDouble();
					acc.moneyAmount(moneyA, amount);
				}
				
				/* Content of Transaction*/
				System.out.println("Content of Transaction, *NO SPACE USING _ INSTEAD");
				String conSen = input.next();
				acc.content(conSen);
				
				/* Note of Transaction*/
				System.out.println("Note..., *NO SPACE USING _ INSTEAD");
				String noteSen = input.next();
				acc.note(noteSen);
				
				acc.insert(accName);
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				break;
				
			case 2:
				acc.viewRecord(accName);
				break;
				
			case 3:
				MoneyRecStatistic stat = new MoneyRecStatistic();
				stat.totalIncome(accName);
				stat.totalSpending(accName);
				stat.displayPresentage();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				break;
				
			case 4: 
				System.out.println("The Amount(Dollar)");
				double conAmount = input.nextDouble();
				MoneyRecMoneyConverter convert = new MoneyRecMoneyConverter(conAmount); // Constructor**
				convert.display();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				break;
				
			case 5:
				MoneyRecAboutMe aboutMe = new MoneyRecAboutMe();
				aboutMe.aboutMe();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			}
			
			System.out.println("Exit?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int exit = input.nextInt();
			if(exit==1) break;
			else continue;
		}
	}
}
