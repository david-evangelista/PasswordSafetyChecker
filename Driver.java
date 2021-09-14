
import java.util.Scanner;


public class Driver {

	/*
	 * Validates yesno string, to ensure either contains Y or N (case insensitive)
	 */
	public static boolean validateYesNo(String yesno) { // returns true if valid
		if (yesno.equalsIgnoreCase("Y"))
			return true;
		if (yesno.equalsIgnoreCase("N"))
			return true;
		else return false; // if invalid	
	}


	public static void main(String[] args) {


		// INITIALIZATION
		boolean done = false; // this boolean will ensure program loops until
		String yesno = ""; // this will hold a value, either Y or N that determines whether to loop the program until done
		PasswordChecker pwChecker = new PasswordChecker(); // creates new PasswordChecker object. default constructor for now. will use setter later
		// this ensure looping and not redundantly creating object

		// STREAMS
		Scanner keyboard = new Scanner(System.in); // will get input from keyboard


		// WELCOME
		System.out.println("Welcome to the Password Safety Checker\n\n"
				+ "\nThis program cross-references possible passwords with a database containing "
				+ "the most often used current unsafe passwords.");

		while (!done) {

			//USER INPUT
			System.out.println("\nPlease enter a possible password to check for safety.\n");
			String password = keyboard.nextLine(); // getting user input

			//CROSS CHECKING
			pwChecker.setPassword(password); // sets password in PasswordChecker object


			if (pwChecker.findMatch())
				System.out.println("The password \""+password+"\" is not safe");
			else  System.out.println("The password is safe");

			do  { // prompts for Y/N until valid
				System.out.println("\nWould you like to try a new password? Please enter Y/N");
				yesno = keyboard.nextLine();
				if (!validateYesNo(yesno))
					System.out.println("\nError. Invalid input. Please try again");
			}	while (!validateYesNo(yesno));

			if (yesno.equalsIgnoreCase("N")) // if user wishes to end program
				done = true; // set done to true to avoid looping	

		} // while !done

		// CLOSING
		System.out.println("\nThank you for using the program!"); // goodbye
		keyboard.close(); // closing streams


	}

}
