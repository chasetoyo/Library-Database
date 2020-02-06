/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class CatalogDriver implements Menu
{	
	public void printMenu() //writing what the method does from interface
	{
		System.out.println(Menu.MENU);
	}
	public void printItems()
	{
		System.out.println(Menu.ITEMS);
	}
	public static void main(String[] args) 
	{ 
		Scanner keyboard = new Scanner(System.in);
		Menu options = new CatalogDriver();
		int userChoice;
		

		while (true)
		{
			try
			{
				options.printMenu();
				userChoice = keyboard.nextInt();
				while (userChoice == userChoice)
				{
					switch(userChoice)
					{
					case 1: //add item
					//doesnt allow you to make any other object besides a book
					//i hardcoded other items to show that they all work
						keyboard.nextLine();
						System.out.println("What type of item would you like to create?");
						System.out.println("'1' for book, '2' for movie, '3' for room, '4' for a periodical");
						int itemType = keyboard.nextInt();
						keyboard.nextLine();
						switch(itemType)
						{
							case 1:
								Book userBook = new Book();

								System.out.println("Enter the title");
								String bookTitle = keyboard.nextLine();
								System.out.println("Available/Unavailable?");
								String av = keyboard.nextLine();
								System.out.println("Enter the author");
								String author = keyboard.nextLine();
								System.out.println("Enter the number of pages");
								int pg = keyboard.nextInt();

								userBook.setName(bookTitle);
								userBook.setAvailability(av);
								userBook.setAuthor(author);
								userBook.setPages(pg);

								Database.addItem(userBook);
								break;
							case 2:
								Movie userMovie = new Movie();

								System.out.println("Enter the title");
								String movieTitle = keyboard.nextLine();
								System.out.println("Available/Unavailable?");
								av = keyboard.nextLine();
								System.out.println("Enter the year created");
								int year = keyboard.nextInt();
								System.out.println("Enter the runtime");
								double runtime = keyboard.nextDouble();

								userMovie.setName(movieTitle);
								userMovie.setAvailability(av);
								userMovie.setYear(year);
								userMovie.setRuntime(runtime);

								Database.addItem(userMovie);
								break;
							case 3:
								Room userRoom = new Room();

								System.out.println("Enter room no.");
								String roomNum = keyboard.nextLine();
								System.out.println("Available/Unavailable?");
								av = keyboard.nextLine();
								System.out.println("Enter room capacity");
								int capacity = keyboard.nextInt();
								keyboard.nextLine();
								System.out.println("Does the room have a computer ('y'/'n')");
								String pcChoice = keyboard.nextLine();
								Boolean hasComputer;
								if (pcChoice == "y")
									hasComputer = true;
								else
									hasComputer = false;

								userRoom.setName(roomNum);
								userRoom.setAvailability(av);
								userRoom.setRoomCapacity(capacity);
								userRoom.setHasComputer(hasComputer);

								Database.addItem(userRoom);
								break;
							case 4:
								Periodical userPer = new Periodical();
								System.out.println("Enter the title");
								String perTitle = keyboard.nextLine();
								System.out.println("Available/Unavailable?");
								av = keyboard.nextLine();
								System.out.println("Enter month followed by day followed by year");
								String month = keyboard.nextLine();
								int day = keyboard.nextInt();
								year = keyboard.nextInt();

								userPer.setName(perTitle);
								userPer.setAvailability(av);
								userPer.setDate(month, day, year);

								Database.addItem(userPer);
								break;
						}
						break;
					case 2: //remove lost item
						keyboard.nextLine();
						System.out.println("Enter barcode of item you want to remove.");
						int barcode = keyboard.nextInt();
						Database.removeItem(barcode);
						break;
					case 3:  //add a student
						keyboard.nextLine();
						System.out.println("Enter student first name");
						String firstName = keyboard.nextLine();
						System.out.println("Enter student last name");
						String lastName = keyboard.nextLine();
						System.out.println("Enter student email");
						String email = keyboard.nextLine();
						System.out.println("Enter student phone number");
						String phoneNo = keyboard.nextLine();
						Student testStudent = new Student(firstName,lastName,email,phoneNo);
						Database.registerStudent(testStudent);
						break;
					case 4: //remove a student
						keyboard.nextLine();
						System.out.println("Enter ID of student you want to remove from database");
						int studentId = keyboard.nextInt();
						Database.unregisterStudent(studentId);
						break;
					case 5: //check status of item given name of item
						keyboard.nextLine();
						System.out.println("Enter name of item you want to search for");
						String itemName = keyboard.nextLine();
						Database.checkStatus(itemName);
						break;
					case 6: //check out item by barcode and student id
						keyboard.nextLine();
						System.out.println("Enter the barcode of the item you are checking out followed by your ID number");
						barcode = keyboard.nextInt();
						keyboard.nextLine();
						int id = keyboard.nextInt();
						Database.checkout(barcode,id);
						break;
					case 7:// returning item by barcode and student id
						keyboard.nextLine();
						System.out.println("Enter the barcode of the item you are returning followed by your ID number");
						barcode = keyboard.nextInt();
						keyboard.nextLine();
						id = keyboard.nextInt();
						Database.checkIn(barcode,id);
						break;
					case 8: //displays everything in library
						keyboard.nextLine();
						Database.displayContents();
						break;
					case 9: //displays everything in library of given type
						keyboard.nextLine();
						System.out.println("Enter type of item you want to list");
						options.printItems();
						String typeChoice = keyboard.nextLine();
						Database.displayContents(typeChoice);
						break;
					case 10://shows all students
						Database.studentDisplay();
						break;
					case 11: //save state
						Database.saveState();
						break;
					case 12: //exits the system
					    System.out.println("Thank you");			
						System.exit(0);
					default:
						System.out.println("Invalid Choice"); //if input a number not 1-10
						break;
					}
					options.printMenu();
					userChoice = keyboard.nextInt();
				}
			}
			catch(InputMismatchException e) //if user inputs anything not an int
			{
				keyboard.next(); //resets bad user input
				System.out.println("INVALID CHOICE.");
			}
		}
	}
}
