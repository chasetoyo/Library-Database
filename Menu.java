/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
public interface Menu 
{
	public final String MENU =
		"-----------------------------------------------------------\n" +
		"ENTER THE NUMBER CORRESPONDING TO WHAT ACTION YOU WANT DONE\n" +
		"1: ADD A NEW ITEM TO THE CATALOG\n" +
		"2: REMOVE A LOST ITEM FROM THE CATALOG\n" +
		"3: REGISTER A NEW STUDENT\n" +
		"4: UNREGISTER AN OLD STUDENT\n" +
		"5: CHECK STATUS OF ITEM\n" +
		"6: CHECKOUT ITEM\n" +
		"7: RETURN ITEM\n" +
		"8: GET LISTING OF ITEMS\n" +
		"9: GET LISTING OF ITEMS BY TYPE\n" +
		"10: GET LISTING OF STUDENTS\n" +
		"11: SAVE STATE\n" +
		"12: EXIT\n" +
		"-----------------------------------------------------------";

	public final String ITEMS =
		"---------\n" +
		"BOOK\n" + "MOVIE\n" + "PERIODICAL\n" + "ROOM\n" +
		"---------";
	public void printMenu();
	public void printItems();
}
