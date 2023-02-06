package main;

public class Utensil extends KitchenItem{
	
	private String material;
	private String type;
	private double size;
	
	Utensil()
	{
		super();
		this.material="DefaultMaterial";
		this.type = "DefaultUtensilType";
		this.size =0;
	}
	Utensil(int newID,String newName, int qty,String newType,String newMat,double newSize)
	{
		super(newID,newName,qty);
		this.type = newType;
		this.material = newMat;
		this.size = newSize;
	}
	//to string
	public String toString()
	{
		return(
				   "ID       : "+ this.getID()
				+"\nName     : "+ this.getName()
				+"\nQuantity : "+ this.getQuantity()
				+"\nType     : "+ this.getType()
				+"\nMaterial : "+ this.getMaterial()
				+"\nSize     : "+ this.getSize()
				);
	}
	//getters
	public String getMaterial()
	{
		return(this.material);
	}
	public String getType()
	{
		return(this.type);
	}
	public double getSize()
	{
		return(this.size);
	}
	//setters
	public void setMaterial(String newMat)
	{
		this.material =newMat;
	}
	public void setType(String newType)
	{
		this.type =newType;
	}
	public void setSize(double newSize)
	{
		this.size = newSize;
	}
}
