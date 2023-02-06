package main;

public class KitchenItem {
	private int itemID;
	private String name;
	private int quantity;
	
	KitchenItem()
	{
		this.itemID = 0;
		this.name = "DefaultItem";
		this.quantity = 0;
	}
	KitchenItem(int newID, String newName, int newQty)
	{
		this.itemID= newID;
		this.name = newName;
		this.quantity = newQty;
	}
	
	public void increaseQuantity(int nextQty)
	{
		this.quantity+=nextQty;
	}
	public void decreaseQuantity(int nextQty)
	{
		if (this.quantity<=nextQty)
		{
			System.out.println("Cannot decrease stock below 0");
		}
		else
		{
			this.quantity-=nextQty;
		}
	}
	
	//to string
	public String toString()
	{
		return(
				   "ID       : "+ this.getID()
				+"\nName     : "+ this.getName()
				+"\nQuantity : "+ this.getQuantity()
				);
	}
	//getters
	public int getID()
	{
		return(this.itemID);
	}
	public String getName()
	{
		return(this.name);
	}
	public int getQuantity()
	{
		return(this.quantity);
	}
	//setters
	
	public void setID(int newID)
	{
		this.itemID = newID;
	}
	public void setName(String newName)
	{
		this.name =newName;
	}
	public void setQuantity(int newQuantity)
	{
		this.quantity = newQuantity;
	}
}
