import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordChecker {

	
	protected Scanner reader;
	protected String password;

	/**
	 * CONSTRUCTOR
	 */
	public PasswordChecker() { 
	}

	public PasswordChecker(String password) { 
		this.password = password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * FIND MATCH
	 * @param word
	 * @return
	 */
	public boolean findMatch() {
		String compare; // hold each line to compare

		try {
			reader = new Scanner(new FileInputStream("10-million-password-list-top-1000000.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		while(reader.hasNextLine()) {
			compare = reader.nextLine();

			if (password.equalsIgnoreCase(compare)) {
				reader.close();// closing stream
				return true;
			} // if

		} // while

		return false; // if didn't find match
	}

}
