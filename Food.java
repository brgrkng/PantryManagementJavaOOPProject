package main;


public class Food extends KitchenItem{
	
	private double weight;
	private String type;
	private boolean isPerishable;
	private boolean hasPreservative;
	
	Food()
	{
		super();
		this.weight =0;
		this.type ="DefaultFoodType";
		this.isPerishable = false;
		this.hasPreservative = false;
	}
	Food(int newID, String newName, int qty, double newWeight, String newType,boolean newPerish,boolean newPrsv)
	{
		super(newID,newName,qty);
		this.weight = newWeight;
		this.type = newType;
		this.isPerishable = newPerish;
		this.hasPreservative = newPrsv;
	}
	//to string
	public String toString()
	{
		return(
				   "ID                    : "+ this.getID()
				+"\nName                  : "+ this.getName()
				+"\nQuantity              : "+ this.getQuantity()
				+"\nWeight                : "+ this.getWeight()
				+"\nType                  : "+ this.getType()
				+"\nNeeds refrigeration?  : " + (getPerishable()?"Yes":"No")
				+"\nHas preservatives?    : " + (getHasPreservative()?"Yes":"No")
				);
	}
	//bool switchers
	public void switchPerishable()
	{
		this.isPerishable = !this.isPerishable;
	}
	public void switchHasPreservatives()
	{
		this.hasPreservative= !this.hasPreservative;
	}
	//getters
	public double getWeight()
	{
		return(this.weight);
	}
	public String getType()
	{
		return(this.type);
	}
	public boolean getPerishable()
	{
		return(this.isPerishable);
	}
	public boolean getHasPreservative()
	{
		return(this.hasPreservative);
	}
	//setters
	public void setWeight(double newWeight)
	{
		this.weight = newWeight;
	}
	public void setType(String newType)
	{
		this.type = newType;
	}
	public void setPerishable(boolean newPerish)
	{
		this.isPerishable = newPerish;
	}
	public void setHasPreservative(boolean newPrsv)
	{
		this.hasPreservative= newPrsv;
	}
}
