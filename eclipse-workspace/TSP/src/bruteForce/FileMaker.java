package bruteForce;
import java.io.*;
import java.util.*;
public class FileMaker {

	FileWriter maker;
	StringBuilder builder;
	
	public FileMaker(String typeOfTour) throws IOException
	{
		builder = new StringBuilder();
		maker = new FileWriter(builder.append("output_").append(typeOfTour).append(".tour").toString());
	}
	
}
