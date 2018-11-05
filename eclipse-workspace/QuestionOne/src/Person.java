import java.lang.StringBuilder;
import java.util.ArrayList;

public class Person {

	String name;
	String finalName;
	String ID;

	public Person(String name) {

		this.name = name;

	}

	/*
	 * creates an ID based on string input and howMany which is based on how many
	 * people of the same name are inside the IDlogger.. this method calls a private
	 * function 'multipleOfFive' which creates the second part of the ID
	 */
	public String concat(String name, int howMany) {

		// String idName;
		StringBuilder finalStr = new StringBuilder();
		// idName = idName(name);
		String num = multipleOfFive(howMany);
		name = name.toUpperCase();
		ID = finalStr.append(name).append(num).toString();
		return ID;

	}

	/*
	 * creates the second part of the ID, which is a multiple of 5.. returns the
	 * second part of the string for the final ID
	 */

	private String multipleOfFive(int num) {

		Integer by5 = num;
		Integer idNum = by5 * 5;
		StringBuilder str;

		if (by5 < 2) {

			str = new StringBuilder("00");
			str.append(idNum);

		} else if (by5 >= 2 && by5 < 20) {

			str = new StringBuilder("0");
			str.append(idNum);

		} else {

			str = new StringBuilder(idNum);

		}

		return str.toString();

	}

	/*
	 * Trims names of the list that is input, and returns the same list
	 */
	public static ArrayList<String> trimNames(ArrayList<String> list) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > 2) {
				String str = list.get(i).substring(0, 3).toUpperCase();
				list.set(i, str);
			} else {
				String str = list.get(i).substring(0).toUpperCase();
				list.set(i, str);
			}

		}
		return list;

	}

	public String getID() {

		return ID;

	}

	public String getName() {

		return name;

	}

}
