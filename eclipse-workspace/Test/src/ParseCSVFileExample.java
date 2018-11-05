import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ParseCSVFileExample {
    public static void main(String[] args) {
        try {
            BufferedReader input = new
            BufferedReader(new FileReader("src/CsvExample.csv"));
            String line = null;
 
            while (( line = input.readLine()) != null) {
                String[] fields = parseCSVLine(line);
                for ( int i = 0; i < fields.length; i++ ) {
                    System.out.println(fields[i]);
                }
            }
            input.close();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    public static String[] parseCSVLine(String line) {
        // Create a pattern to match breaks
        Pattern p =
            Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
        // Split input with the pattern
        String[] fields = p.split(line);
        for (int i = 0; i < fields.length; i++) {
            // Get rid of residual double quotes
            fields[i] = fields[i].replace("\"", "");
        }
        return fields;
    }
}