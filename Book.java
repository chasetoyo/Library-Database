/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
public class Book extends Item
{
	private String author; //books have authors and pages on top of everything from item class
	private int pages;
	
	public Book()
	{
		super(); //code reuse
		this.author = "";
		this.pages = 0;
	}
	
	public Book(String name, String availability, String author, int pages)
	{
		super(name, availability); //code reuse
		setAuthor(author);
		setPages(pages);
	}

	public Book(String name, String availability, int barcode, String author, int pages)
	{
		super(name, availability, barcode); //code reuse
		setAuthor(author);
		setPages(pages);
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public int getPages()
	{
		return pages;
	}
	
	public String toString()
	{
		return super.toString() 
			+ "Author: " + author + "\n"
			+ "Number of pages: " + pages;	
	}

	public boolean equals(Object other)
	{
		boolean sameSame = false;

	        if (other != null && other instanceof Book)
	        {
	            sameSame = (this.name.equals(((Book)other).name)
	            	&& this.availability.equals(((Book)other).availability)
					&& this.barcode == ((Book)other).barcode
				    && this.pages == ((Book)other).pages 
					&& this.author.equals(((Book)other).author));	
	        }
	        return sameSame;
	}
}
