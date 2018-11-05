import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDReader {

	Map logger;
	List personList;
	Person[] arr;

	// in this case, the String maps to a list of Person objects which have the same
	// name.
	// if there is no need to keep a record of the IDs, then an Integer would do

	public IDReader() {

		personList = new ArrayList<Person>();
		logger = new HashMap<String, ArrayList<Person>>();

	}

	/*
	 * The enterName method creates a person object, then checks the map to see if
	 * any of its keys have the same name. If it does, then then it adds it to the
	 * key of that value, which is a list. If it doesn't contain the name of the new
	 * person object, then it puts the new name in the map, and creates a new list
	 * for the value of that key.
	 */
	public String enterName(String name) {

		Person pers = new Person(name);
		if (logger.containsKey(name)) {

			personList = (ArrayList) logger.get(name);
			pers.concat(name, personList.size() + 1);
			((ArrayList) logger.get(name)).add(pers);

		} else {

			logger.put(name, new ArrayList<Person>());
			pers.concat(name, 1);
			((ArrayList) logger.get(name)).add(pers);

		}

		return pers.getID();

	}

}
