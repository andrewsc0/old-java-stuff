import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Driver {

	public static void main(String[] args) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		String quit = "Q";
		ArrayList<Double> list = new ArrayList<Double>();
		int count = 0;
		System.out.println("This program formats phone numbers and social security numbers.\nTo "
				+ "format a phone number, enter 1. To format a social security number, enter 2. \nTo "
				+ "quit, enter 'Q'.");

		System.out.println("Enter 1 or 2, based on the instructions.");

		/*
		 * This reads in user input and stores it in a list, for processing
		 */
		list.add(kb.nextDouble());
		do {

			list.add(kb.nextDouble());

		} while (kb.hasNextDouble());
		/*
		 * this for loop takes the choices (1 or 2) and checks the next index of the
		 * list to see if the length of the input (SSN or PhoneNumber) is the correct
		 * amount of digits, then creates a Phone Number object or an SSN object and
		 * passes the Big Integer to the constructor, where the constructor calls a
		 * format function that formats the number. then simply the number is printed
		 * out.
		 */
		for (int i = 0; i < list.size(); i = i + 2) {

			if (list.get(i) == 1) {

				BigInteger bigIn = BigDecimal.valueOf(list.get(i + 1)).toBigInteger();
				// System.out.println(bigIn.toString().toCharArray().length);
				if (bigIn.toString().toCharArray().length == 10) {

					PhoneNumber num = new PhoneNumber(bigIn);
					System.out.println(num.getPhoneNumber());

				} else {

					System.out.println("Error! Phone numbers should " + "be 10 digits long.");

				}

			} else if (list.get(i) == 2) {

				BigInteger bigIn = BigDecimal.valueOf(list.get(i + 1)).toBigInteger();

				if (bigIn.toString().toCharArray().length == 9) {

					SSN num = new SSN(bigIn);
					System.out.println(num.getSSN());

				} else {

					System.out.println("Error! Social security numbers " + "shuold be 9 digits long.");

				}

			} else {

				System.out.println("Invalid selection, please choose a 1 or 2.");

			}
		}

	}
}