/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
public class Periodical extends Item
{
	private String month; //periodicals just have dates + things from item class
	private int day;
	private int year;
	private String date;
	
	public Periodical()
	{
		super(); //code reuse
		this.month = "";
		this.day = 0;
		this.year = 0;
	}

	public Periodical(String name, String availability, String month, int day, int year)
	{
		super(name, availability); //code reuse
		setDate(month, day, year);
	}
	
	public Periodical(String name, String availability, int barcode, String month, int day, int year)
	{
		super(name, availability, barcode); //code reuse
		setDate(month, day, year);
	}
	
	public void setDate(String month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public String getDate() //condensing date into one string 
	{
		date = month + " " + day + ", " + year;
		return date;
	}
	
	public boolean equals(Object other)
	{	
		  boolean sameSame = false;

	        if (other != null && other instanceof Periodical)
	        {
	            sameSame = (this.name.equals(((Periodical)other).name)
	            	&& this.availability.equals(((Periodical)other).availability)
					&& this.barcode == ((Periodical)other).barcode
					&& this.date == ((Periodical)other).date);	
	        }
	        return sameSame;
	}

	public String toString()
	{
		return super.toString() 
				+ "Date of Release: " + (month + " " + day + ", " + year);
	}
}
