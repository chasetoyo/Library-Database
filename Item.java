/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.util.Random;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Item implements Serializable
{
	protected String name; //every item has name(title, room number, etc.)
	protected String availability; //checked out, checked in, lost
	protected int barcode; //every item has barcode(id)
	protected Student borrower; //every item is checkout-able, so every item should have someone
	//that borrows it too

	protected static final Random generator = new Random();
	
	public Item() //null constructor
	{
		this.name = "";
		this.availability = "";
		this.barcode = 100000 + generator.nextInt(900000);
		this.borrower = null;
	}

	public Item(String name, String availability)
	{
		setName(name);
		setAvailability(availability);
		setBarcode(100000 + generator.nextInt(900000)); //generates a random 6 digit number
		setBorrower(new Student()); //new items don't have a borrower until checked out
	}
	
	public Item(String name, String availability, int barcode)
	{
		setName(name);
		setAvailability(availability);
		setBarcode(barcode);
		setBorrower(new Student()); //new items don't have a borrower until checked out
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAvailability(String availability)
	{
		this.availability = availability;
	}
	
	public void setBarcode(int barcode)
	{
		this.barcode = barcode;
	}
	
	public void setBorrower(Student borrower)
	{
		this.borrower = borrower;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAvailability()
	{
		return availability;
	}
	
	public int getBarcode()
	{
		return barcode;
	}
	
	public String getBorrower()
	{
		return borrower.getName(); //could be name or id, i chose name because 
		//it makes more sense to see that in a library catalog
	}

	public void saveState(Item theItem)
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream("SavedCatalog.txt");
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(theItem);
		    objectOutputStream.close();
		    fileOutputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Non existent file");
		}
		catch(IOException e)
		{
			System.out.println("Bad input");
		}
	}

	public boolean equals(Object other)
	{	
		  boolean sameSame = false;

	        if (other != null && other instanceof Item)
	        {
	            sameSame = (this.name.equals(((Item)other).name)
	             && this.availability.equals(((Item)other).availability)
				&& this.barcode == ((Item)other).barcode);	
	        }
	        return sameSame;
	}
	
	public String toString()
	{
		return "Name: " + name + "\n"
			+ "Availability: " + availability + "\n"
			+ "Barcode: " + barcode + "\n";
	}
}
