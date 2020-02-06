/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.util.ArrayList;

public class Database 
{
	private static ArrayList<Item> database = new ArrayList<Item>(); //list of all items using parent class as 
	//array parameter
	private static ArrayList<Student> students = new ArrayList<Student>(); //list of all students(or users)
	
	private static boolean containsItem = false;
	private static boolean containsStudent = false;

	public static void addItem(Item theItem)
	{
		if (database.contains(theItem)) //problem said add "new" item, so checking for uniqueness
		{
			System.out.println("Already exists, cannot add same item to database.");
		}
		else
		{
			System.out.println(theItem.getName() + " added");
			database.add(theItem); //adds item to array
		}
	}

	public static Book makeBook(String name, String availability, int barcode, String author, int pages)
	{
		Book x = new Book(name, availability, barcode, author, pages);
		return x;
	}

	public static void removeItem(int barcode)
	{
		for (int i = 0; i<database.size(); i++) //not enhanced for loop to avoid ConcurrentModificationException
		{
			Item theItem = database.get(i);
			if (theItem.getBarcode() == barcode)
			{
				containsItem = true;
				if (theItem.getAvailability().equals("Lost")) //problem said remove "lost" item
				{
					database.remove(theItem);
					System.out.println("Item: '" + theItem.getName() + "' successfully removed from database.");
				}
				else
				{
					System.out.println("Item: '" + theItem.getName() + "' is not lost, cannot be removed from database.");
				}
			}
		}
		if(containsItem == false)
		{
			System.out.println("Item: " + barcode + " does not exist.");
		}
		containsItem = false;
	}
	
	public static void displayContents()
	{
		System.out.printf("%-15s %-15s %-20s %-15s\n", "Type", "Barcode", "Name", "Availability");
		for (Item i : database) //lists all items, provides: type, name, availability
		{
			System.out.printf("%-15s %-15s %-20s %-15s\n", i.getClass().getSimpleName(), i.getBarcode(), i.getName(), i.getAvailability());	
		}
	}
	
	public static void displayContents(String itemType)//overloading method
	{
		System.out.printf("%-15s %-15s %-20s %-15s\n", "Type", "Barcode", "Name", "Availability");
		for (Item i : database)
		{
			if(i.getClass().getSimpleName().equalsIgnoreCase(itemType)) //compares current i's class name to input
			{
				containsItem = true; //set true if found
				System.out.printf("%-15s %-15s %-20s %-15s\n", i.getClass().getSimpleName(), i.getBarcode(), i.getName(), i.getAvailability());
			}
		}
		if (containsItem == false) //if there are no items of inputted type, then displays following message
		{
			System.out.println("Items of type '" + itemType + "' do not exist in our system.");
		}
		containsItem = false;
	}
	
	public static void registerStudent(Student theStudent)
	{	
		if (students.contains(theStudent)) //checks for uniqueness because student must have unique email and id 
		{
			System.out.println("contains student already");
		}
		else if (!students.contains(theStudent))
		{
			students.add(theStudent);
			System.out.println(theStudent.getName() +"'s ID no. is: " + theStudent.getId());
		}
	}

	public static void studentDisplay()
	{
		for (Student s : students)
		{
			System.out.println(s.getName() + " | " + s.getId());	
		}
	}
	
	public static void unregisterStudent(int studentId)
	{
		for (int i = 0; i<students.size(); i++) //not enhanced for loop to avoid ConcurrentModificationException
		{
			Student theStudent = students.get(i);
			if (theStudent.getId() == studentId)
			{
				if (theStudent.getHasItem() == true) //checks if student has an item
				//cannot unregister if student has item
				{
					System.out.println("Cannot unregister " + theStudent.getName() + ", student has item.");
				}
				
				else if (theStudent.getHasItem() == false)
				{
					students.remove(theStudent); //removes student from the arraylist of students
					System.out.println(theStudent.getName() + " was successfully removed.");
				}	
			}
		}
	}
	
	public static void checkStatus(String itemName)
	{
		for (Item theItem : database)
		{
			if (theItem.getName().equals(itemName)) //checking all items to match input
			{
				containsItem = true;
				System.out.println("'" + theItem.getName() + "'" + " Status: "+ theItem.getAvailability() + "."); //prints out name of item and status
				if (theItem.getAvailability().equals("Unavailable")) //shows who checked out if item is unavailable
				{
					System.out.println("Borrowed by: " + theItem.getBorrower());
				}
			}
		}
		if (containsItem == false)
		{
			System.out.println("No results found");
		}
		containsItem = false;
	}

	public static void checkout(int barcode, int id)
	{
		for (Item theItem : database) //checks all items
		{
			theItem.getBarcode();
			if (theItem.getBarcode() == barcode) //compares input barcode to all barcodes in system
			{
				containsItem = true;
				for (Student theStudent : students)  //checks all students
				{
					theStudent.getId();
					if(theStudent.getId() == id) //compares input id to data and checks if it matches
					{
						containsStudent = true;
						if (theStudent.getItemsNo() == 0) //if student doesnt have any items checked out
						{
							if (theItem.getAvailability().equals("Available")) //if the item isnt checked out
							{
								theStudent.setHasItem(true); //student now has an item
								theItem.setBorrower(theStudent); //item now has a borrower
								theStudent.addItemsNo(); //increases no. of items by 1
								System.out.println("Item: " + "'" + theItem.getName() + "'" + "\n"
										+ "checked out to: " + theStudent.getName());
								theItem.setAvailability("Unavailable");
							}
							else if (theItem.getAvailability().equals("Unavailable"))
							{
								System.out.println("Cannot checkout " + "'" + theItem.getName() + "'" + ", item is unavailable.");
							}
							else if (theItem.getAvailability().equals("Lost"))
							{
								System.out.println("Cannot checkout " + "'" + theItem.getName() + "'" + ", item is lost.");
							}
							else if (theItem.getAvailability().equals(""))
							{
								System.out.println("'" + theItem.getName() + "'" + " does not exist in our system.");
							}	
						}
						else if(theStudent.getItemsNo() == 1)//if student already has 1 item checked out, cant check out more
						{
							System.out.println("Cannot checkout " + "'" + theItem.getName() + "'" + ", exceeds max items allowed to checkout.");
						}
					}
				}
			}
		}
		if(containsItem== false || containsStudent == false)
		{
			System.out.println("An error occured. Could not checkout.");
		}
		containsItem= false;
		containsStudent = false;
	}

	public static void checkIn(int barcode, int id)
	{
		for (Item theItem : database) //checks all items
		{
			theItem.getBarcode();
			if (theItem.getBarcode() == barcode) //compares input barcode to all barcodes in system
			{
				containsItem = true;
				for (Student theStudent : students)  //checks all students
				{
					theStudent.getId();
					if(theStudent.getId() == id) //compares input id to data and checks if it matches
					{
						containsStudent = true;
						if (theStudent.getItemsNo() == 1) //if user ACTUALLY has an item
						{
							if (theItem.getAvailability().equals("Unavailable") || theItem.getAvailability().equals("Lost") ) //if item is ACTUALLY checked out
							{
								theStudent.setHasItem(false); //removes item from student
								theItem.setBorrower(null); //removes borrower from item
								theStudent.subtractItemsNo(); //sets no. of items back to 0
								System.out.println("Item: " + "'" + theItem.getName() + "'" + "\n"
										+ "returned by: " + theStudent.getName());
								theItem.setAvailability("Available");
							}
							else if (theItem.getAvailability().equals("Available"))
							{
								System.out.println("Cannot return, " + "'" + theItem.getName() + "'" + " is already in system.");
							}
							else if (theItem.getAvailability().equals(""))
							{
								System.out.println("This item does not exist in our system.");
							}
						}
						else if(theStudent.getItemsNo() == 0) //if user doesnt have items checked out
						{
							System.out.println("Cannot return " + "'" + theItem.getName() + "'" + ", you don't have items to return.");
						}
					}
				}
			}
		}
		if(containsItem== false || containsStudent == false)
		{
			System.out.println("An error occured. Could not checkout.");
		}
		containsItem= false;
		containsStudent = false;
	}

	public static void saveState()
	{
		for (Item s : database)
		{
			s.saveState(s);
		}
		System.out.println("Saved!");
	}
}
						