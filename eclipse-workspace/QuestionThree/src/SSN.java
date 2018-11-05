import java.math.BigInteger;

public class SSN {

	String SSNum;
	
	/*
	 * Creates a SSN Object with paramter inp,
	 * which is a BigInteger. The Constructor calls
	 * the format function which places the
	 * dashes within the number to put the
	 * SSN in the correct format
	 */
	SSN(BigInteger inp) {

		this.SSNum = format(inp);

	}
	
	/*
	 * Takes in a BigInteger. Turns it into a String,
	 * then makes a StringBuilder object. It creates substrings.
	 * After it creates the substrings then it uses the 
	 * StringBuilder to append them in the correct order,
	 * including the dashes
	 */
	private String format(BigInteger inp) {

		String str = inp.toString();
		StringBuilder build = new StringBuilder();
		String p1, p2, p3;
		p1 = str.substring(0, 3);
		p2 = str.substring(3, 5);
		p3 = str.substring(5, 9);
		build.append(p1).append("-").append(p2).append("-").append(p3);
		return build.toString();

	}

	/*
	 * Simple getter method which returns the SSN
	 */
	public String getSSN() {

		return SSNum;

	}

}
