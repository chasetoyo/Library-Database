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

public class Student implements Serializable
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private boolean hasItem; //used for checking if student has item before unregistering
	private int itemsNo; //used to count amt of items user has since there is a limit of 1 item
	private static final Random generator = new Random();

	public Student()
	{
		this.id = 0;
		this.firstName = "----";
		this.lastName = "----";
		this.email = "";
		this.phoneNo = "";
		this.hasItem = false;
		itemsNo = 0;
	}

	public Student(String firstName, String lastName, String email, String phoneNo)
	{
		setID(1000000 + generator.nextInt(9000000)); //generates a random 7 digit number
		setName(firstName, lastName);
		setEmail(email);
		setPhoneNo(phoneNo);
		hasItem = false; //new student shouldn't have anything checked out
		itemsNo = 0; //same reason as above
	}
	
	public Student(int id, String firstName, String lastName, String email, String phoneNo)
	{
		setID(id);
		setName(firstName, lastName);
		setEmail(email);
		setPhoneNo(phoneNo);
		hasItem = false; //new student shouldn't have anything checked out
		itemsNo = 0; //same reason as above
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public void setName(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	
	public void setHasItem(boolean hasItem)
	{
		this.hasItem = hasItem;
	}
	
	public void addItemsNo() //increases items, called when user checks out
	{
		itemsNo += 1;
	}
	
	public void subtractItemsNo() //decreases items, called when user returns item
	{
		itemsNo -= 1;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public boolean getHasItem()
	{
		return hasItem;
	}
	
	public int getItemsNo()
	{
		return itemsNo;
	}
	
	//normal tostring override
	public String toString()
	{
		return "ID: " + id + "\n" +
					"Name: " + firstName + " " + lastName + "\n" + 
					"Email: " + email + "\n" +
					"Phone No: " + phoneNo + "\n" +
					"Has item checked out: " + hasItem;
	}
	
	//from stackoverflow, compares to an object 
	//checks to see ifs null, then if it is a student
	//then compares id and email
	public boolean equals(Object other)
	{
	        boolean sameSame = false;

	        if (other != null && other instanceof Student)
	        {
	            sameSame = (this.id == ((Student) other).id || this.email.equals(((Student) other).email));
	        }
	        return sameSame;
	}
	
//this equals seemed to work but when I was doing the "contains(x)" it wasn't doing what i needed it to.
//using || instead of && because looking for if any of them are equal. 
//	public boolean equals(Object other)
//	{
//		return (this.firstName.equals(other.firstName) || this.email.equals(other.email));
//	}
}
