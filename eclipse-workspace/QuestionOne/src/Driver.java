import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		IDReader reader = new IDReader();
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Enter the names that you need IDs for, \nwhen you are done entering the names,"
				+ "type 'q' or 'Q'.");

		/*
		 * Reads in the keyboard input and stores it in a list so that it can later be
		 * worked with
		 */
		do {

			String str = keyboard.next();
			if (str.equalsIgnoreCase("q"))
				break;
			else
				list.add(str);

		} while (keyboard.hasNext());
		keyboard.close();

		/*
		 * trim names is a static class method of class Person that trims each name down
		 * to 3 characters
		 */
		list = Person.trimNames(list);
		/*
		 * Each iteration calls the IDReader's class object 'reader' method 'enterName'
		 * with each object in the list, and then sets it back into the same index in
		 * the list.
		 */
		for (int j = 0; j < list.size(); j++) {

			String newN = reader.enterName(list.get(j));
			list.set(j, newN);

		}

		for (String string : list) {

			System.out.println(string);

		}

		/*
		 * String str = read.enterName("Jen"); String str2 = read.enterName("Jen");
		 * String str3 = read.enterName("Tom"); String str4 = read.enterName("Vito");
		 * String str5 = read.enterName("Jennifer"); String str6 =
		 * read.enterName("Jennifer"); String str7 = read.enterName("Jennifer");
		 * 
		 * System.out.println(str); System.out.println(str2); System.out.println(str3);
		 * System.out.println(str4); System.out.println(str5); System.out.println(str6);
		 * System.out.println(str7);
		 */
	}

}
