package main;

import java.util.Vector;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PantryManagement {
	public static void main(String[] args)
	{
		Vector <KitchenItem> database = new Vector<KitchenItem>(0);
		Scanner sc = new Scanner(System.in);
		mainMenu(database,sc);
		sc.close();
	}
	public static void mainMenu(Vector<KitchenItem> dbs, Scanner sc)
	{
		System.out.println(
				   "1.Display item list   "
				+"\n2.Add item to list    "
				+"\n3.Add to item stock   "
				+"\n4.Decrease item stock "
				+"\n5 Delete an item      "
				+"\n0.Exit program"
				);
		execMenuChoice(dbs,sc);
	}
	public static void execMenuChoice(Vector<KitchenItem> dbs, Scanner sc)
	{
		int menuChoice = selectMenu(sc);
		
		switch(menuChoice)
		{
			case 0:
				System.out.println("Exiting program");
				break;
			case 1:
				displayInventory(dbs);
				mainMenu(dbs,sc);
				break;
			case 2:
				System.out.println("Entering add item menu...");
				typeMenu();
				int typeChoice = selectType(sc);
				execAddType(typeChoice,dbs,sc);
				mainMenu(dbs,sc);
				break;
			case 3:
				displayInventory(dbs);
				addStock(dbs,sc);
				mainMenu(dbs,sc);
				break;
			case 4:
				displayInventory(dbs);
				reduceStock(dbs,sc);
				mainMenu(dbs,sc);
				break;
			case 5:
				displayInventory(dbs);
				deleteItem(dbs,sc);
				mainMenu(dbs,sc);
				break;
			default:
				System.out.println("ERROR");
		}
	}
	
	public static void typeMenu() {
        System.out.print(
        		"1.Utensil"
        		+ "\n2.Food"
        		+ "\n3.Other"
        		+ "\n4.Return\n");
    }
	public static int selectMenu(Scanner sc)
	{
		int selectMenuNumber= -1;
		for(;;) {
			try {
		System.out.print("Enter number selection: ");
		selectMenuNumber = sc.nextInt();
		
		if(selectMenuNumber >=0 && selectMenuNumber <=5) {
			return selectMenuNumber;
		}else {
			System.out.println("Number is invalid");
		}
			}
			catch(Exception e)
			{
				System.out.println("Number is inavlid");
				sc.nextLine();
			}
		}
	}
	public static int selectType(Scanner scanner) {
        int number;
        do {
            System.out.print("Please enter number: ");
            while (!scanner.hasNextInt()) {
                final String input = scanner.next();
                System.out.printf("\"%s\" is not valid.\n", input);
            }
            number = scanner.nextInt();
        } while (number < 1 || number >4);
        return number;
    }
	public static void displayInventory(Vector<KitchenItem> database){
		
		System.out.println("=========================================================");
		if (database.size() == 0)
			System.out.println("Inventory is empty");
		else {
			for(KitchenItem item : database) {
				System.out.println(item.toString());
			}
	    }
		System.out.println("=========================================================");
    }
      public static void deleteItem(Vector<KitchenItem> database,Scanner sc) {
    	  
    	  int itemID = -1;
    	  while(itemID <0)
			{
				try
				{
					System.out.print("Choose the item ID : ");
					itemID = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					sc.nextLine();
				}
				if(itemID<0)
				{
					System.out.println("Enter a positive integer");
				}
			}

          for (int i = 0 ; i <(database.size());i++) {
              if(database.elementAt(i).getID() == itemID) 
                      database.removeElementAt(i);

          }//for loop


      }//delete item method


		
      public static void execAddType(int typeChoice , Vector<KitchenItem> database , Scanner sc) {

          switch(typeChoice) {

              case 1:
                  addUtensil(database , sc);
                  break;
              case 2:
                  addFood(database , sc);		
                  break;
              case 3:
                  addItem(database , sc);	
                  break;
              default:
                  break;
          }

      }//execAddType

	public static void addItem(Vector<KitchenItem> dbs,Scanner sc)
	{
		System.out.println("Entering a new kitchen item to the list ");
		int tempID =-1;
		String tempName = "";
		int tempQty = -1;
		
		while(tempID<0)
		{
			try
			{
				System.out.print("Enter item ID : ");
				tempID = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempID<0)
			{
				System.out.println("Enter a positive integer");
			}
		}
		sc.nextLine();
		
		System.out.print("Enter item name : ");
		tempName = sc.nextLine();
		
		while(tempQty<0)
		{
			try
			{
				System.out.print("Enter the item quantity : ");
				tempQty = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempQty<0)
			{
				System.out.println("Enter a positive integer");
			}
		}
		sc.nextLine();
		
		dbs.add(new KitchenItem(tempID,tempName,tempQty));
	}
	
	public static void addUtensil(Vector <KitchenItem> dbs,Scanner sc)
	{
		System.out.println("Entering a new Utensil to the list ");
		int tempID =-1;
		String tempName = "";
		int tempQty = -1;
		String tempType = "";
		String tempMat = "";
		double tempSize = 0;
		
		while(tempID<0)
		{
			try
			{
				System.out.print("Enter item ID : ");
				tempID = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempID<0)
			{
				System.out.println("Enter a positive integer");
			}
		}
		sc.nextLine();
		
		System.out.print("Enter item name : ");
		tempName = sc.nextLine();
		
		while(tempQty<0)
		{
			try
			{
				System.out.print("Enter the item quantity : ");
				tempQty = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempQty<0)
			{
				System.out.println("Enter a positive integer");
			}
		}
		sc.nextLine();
		
		System.out.print("Enter the utensil type : ");
		tempType = sc.nextLine();
		
		System.out.print("Enter the utensil material : ");
		tempMat = sc.nextLine();
		
		while(tempSize<=0)
		{
			try
			{
				System.out.print("Enter the utensil size : ");
				tempSize = sc.nextDouble();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempSize<=0)
				
			{
				System.out.println("Enter a positive real number");
			}
		}	
		sc.nextLine();
		
		dbs.add(new Utensil(tempID,tempName,tempQty,tempType,tempMat,tempSize));
	}
	
	public static void addFood(Vector<KitchenItem> dbs, Scanner sc)
	{
		System.out.println("Entering a new food item to the list ");
		int tempID =-1;
		String tempName = "";
		int tempQty = -1;
		String tempType = "";
		double tempWeight = 0;
		char tempPrsble = 'n';
		char tempPrsv = 'n';
		
		while(tempID<0)
		{
			try
			{
				System.out.print("Enter item ID : ");
				tempID = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempID<0)
			{
				System.out.println("Enter a positive integer");
			}
		}
		sc.nextLine();
		
		System.out.print("Enter item name : ");
		tempName = sc.nextLine();
		
		while(tempQty<0)
		{
			try
			{
				System.out.print("Enter the item quantity : ");
				tempQty = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempQty<0)
			{
				System.out.println("Enter a positive integer");
			}
		}
		sc.nextLine();
		
		System.out.print("Enter the item type : ");
		tempType = sc.nextLine();
		
		while(tempWeight<=0)
		{
			try
			{
				System.out.print("Enter the weight : ");
				tempWeight = sc.nextDouble();
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
			}
			if(tempWeight<=0)
				
			{
				System.out.println("Enter a positive real number");
			}
		}	
		sc.nextLine();
			
		System.out.print("Is the food persihable ? (Enter y for yes) : ");
		tempPrsble = sc.next().charAt(0);
		boolean ansPrsble = (tempPrsble=='y')?true:false;
		
		System.out.print("Does the food contain preservatives? (Enter y for yes) : ");
		tempPrsv = sc.next().charAt(0);
		boolean ansPrsv = (tempPrsv=='y')?true:false;
		
		dbs.add(new Food(tempID,tempName,tempQty,tempWeight,tempType,ansPrsble,ansPrsv));
	}
	public static void addStock(Vector<KitchenItem> dbs,Scanner sc)
	{
		if(dbs.size()>0)
		{
			int tempID = -1;
			int nextQty = -1;
			while (tempID<0)
			{
				try
				{
					System.out.println("Enter the item ID : ");
					tempID = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					sc.nextLine();
				}
				if(tempID<0)
				{
					System.out.println("Enter a positive integer");
				}
			}
			sc.nextLine();
			
			while (nextQty<0)
			{
				try
				{
					System.out.println("Enter the amount to add : ");
					nextQty = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					sc.nextLine();
				}
				if(nextQty<0)
				{
					System.out.println("Enter a positive integer");
				}
			}
			for (KitchenItem item:dbs)
			{
				if(item.getID()==tempID)
				{
					item.increaseQuantity(nextQty);
				}
			}
		}
	}
	public static void reduceStock(Vector<KitchenItem> dbs,Scanner sc)
	{
		if(dbs.size()>0)
		{
			int tempID = -1;
			int nextQty = -1;
			while (tempID<0)
			{
				try
				{
					System.out.println("Enter the item ID : ");
					tempID = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					sc.nextLine();
				}
				if(tempID<0)
				{
					System.out.println("Enter a positive integer");
				}
			}
			sc.nextLine();
			
			while (nextQty<0)
			{
				try
				{
					System.out.println("Enter the amount to reduce : ");
					nextQty = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					sc.nextLine();
				}
				if(nextQty<0)
				{
					System.out.println("Enter a positive integer");
				}
			}
			for (KitchenItem item:dbs)
			{
				if(item.getID()==tempID)
				{
					item.decreaseQuantity(nextQty);
				}
			}
		}
	}	
}