import java.math.BigInteger;

public class PhoneNumber {

	String PhoneNum;
	
	/*
	 * Creates a PhoneNumber Object with paramter inp,
	 * which is a BigInteger. The Constructor calls
	 * the format function which places parentheses
	 * and dashes within the number to put the
	 * PhoneNumber in the correct format
	 */
	PhoneNumber(BigInteger inp) {

		this.PhoneNum = format(inp);

	}
	/*
	 * Takes in a BigInteger. Turns it into a String,
	 * then makes a StringBuilder object. It creates substrings.
	 * After it creates the substrings then it uses the 
	 * StringBuilder to append them in the correct order,
	 * including the parentheses and dash
	 */
	private String format(BigInteger inp) {

		String str = inp.toString();
		StringBuilder build = new StringBuilder();
		String p1, p2, p3;
		p1 = str.substring(0, 3);
		p2 = str.substring(3, 6);
		p3 = str.substring(6, 10);
		build.append("(").append(p1).append(")").append(p2).append("-").append(p3);
		return build.toString();

	}
	/*
	 * Basic getter method that returns the number
	 */
	public String getPhoneNumber() {

		return PhoneNum;

	}
}
