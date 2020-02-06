/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
public class Room extends Item
{
	private int roomCapacity;
	private Boolean hasComputer; //may or may not have computer
	
	public Room()
	{
		super(); //code reuse
		this.roomCapacity = 0;
		this.hasComputer = false;
	}
	
	public Room(String name, String availability, int roomCapacity, Boolean hasComputer)
	{
		super(name, availability); //code reuse
		setRoomCapacity(roomCapacity);
		setHasComputer(hasComputer);
	}

	public Room(String name, String availability, int barcode, int roomCapacity, Boolean hasComputer)
	{
		super(name, availability, barcode); //code reuse
		setRoomCapacity(roomCapacity);
		setHasComputer(hasComputer);
	}
	
	public void setRoomCapacity(int roomCapacity)
	{
		this.roomCapacity = roomCapacity;
	}
	
	public void setHasComputer(Boolean hasComputer)
	{
		this.hasComputer = hasComputer;
	}
	
	public int getRoomCapacity()
	{
		return roomCapacity;
	}
	
	public Boolean getHasComputer()
	{
		return hasComputer;
	}
	
	public boolean equals(Object other)
	{	
		  boolean sameSame = false;

	        if (other != null && other instanceof Room)
	        {
	            sameSame = (this.name.equals(((Room)other).name)
	            	&& this.availability.equals(((Room)other).availability)
					&& this.barcode == ((Room)other).barcode
					&& this.roomCapacity ==((Room)other).roomCapacity
					&& this.hasComputer == ((Room)other).hasComputer);	
	        }
	        return sameSame;
	}

	//overriding entire parent method because replacing "name" with "room number"
	public String toString()
	{
		return "Room Number: " + name + "\n"
				+ "Availability: " + availability + "\n"
				+ "Barcode: " + barcode + "\n"
				+ "Room Capacity: " + roomCapacity + "\n"
				+ "Has Computer: " + hasComputer;
	}
}
