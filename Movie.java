/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
public class Movie extends Item
{
	private int year; //movies have year and runtime on top of everything from item class
	private double runtime; //runtime in minutes, double because could have seconds
	
	public Movie()
	{
		super(); //code reuse
		this.year = 0;
		this.runtime = 0;
	}
	
	public Movie(String name, String availability, int year, double runtime)
	{
		super(name, availability); //code reuse 
		setYear(year);
		setRuntime(runtime);
	}
	
	public Movie(String name, String availability, int barcode, int year, double runtime)
	{
		super(name, availability, barcode); //code reuse 
		setYear(year);
		setRuntime(runtime);
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public void setRuntime(double runtime)
	{
		this.runtime = runtime;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public double getRuntime()
	{
		return runtime;
	}

	public boolean equals(Object other)
	{	
		  boolean sameSame = false;

	        if (other != null && other instanceof Movie)
	        {
	            sameSame = (this.name.equals(((Movie)other).name)
	            	&& this.availability.equals(((Movie)other).availability)
					&& this.barcode == ((Movie)other).barcode
					&& this.year == ((Movie)other).year
					&& this.runtime == ((Movie)other).runtime);	
	        }
	        return sameSame;
	}
	
	public String toString()
	{
		return super.toString() 
				+ "Year of Release: " + year + "\n"
				+ "Runtime in minutes:" + runtime;
	}
}
