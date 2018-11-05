package bruteForce;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DynamicSolver implements TSPSolver {

  String fileName, bestTour;
  Scanner scanner;
  File file;
  double bestScore;
  ArrayList<String> readIn, list, points;
  ArrayList<ArrayList<City>> tours = new ArrayList<ArrayList<City>>();
  Map<String, Double> scores;
  ArrayList<City> cs = new ArrayList<City>();
  ArrayList<String> fileInfo = new ArrayList<String>();

  public DynamicSolver(String fileName) throws FileNotFoundException {
    this.fileName = fileName;
    list = new ArrayList<String>();
	file = new File(fileName);
      String data = fileName.toString();
      try {
        scanner = new Scanner(file);
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    while(scanner.hasNext())
    {
   	 fileInfo.add(scanner.nextLine());
    }
    
    for(int i = 8; i < fileInfo.size(); i++)
    {
    	String[] arr = fileInfo.get(i).split(" ");
   	 	StringBuilder b = new StringBuilder();
   	 	for(int j = 0; j < arr.length; j++)
   	 	{
   	 		String s = arr[j];
   	 		b.append(s + " ");
   	 		list.add(s + " ");
   	 	}
    }
    tours = Permute(cs);
  }

  @Override
  public String solve() {
 
    int i = 0;
    while (i < list.size() - 2) {
      String city = list.get(i);
      Double x = Double.parseDouble(list.get(i + 1));
      Double y = Double.parseDouble(list.get(i + 2));
      cs.add(new City(city, x, y));
      i = i + 3;
    }
//    tours = Permute(cs);
    double[][] adjMat = new double[cs.size() + 1][cs.size() + 1];
    i = 1;
    for (i = 1; i <= cs.size(); i++) {
      for (int j = 1; j <= cs.size(); j++) {
        if (i == j) {
          adjMat[i][j] = 0;
        } else {
          adjMat[i][j] = distanceTo(cs.get(i - 1), cs.get(j - 1));
        }
      }
    }

    for (int j = 0; j < tours.size(); j++) {
      Double tourScore = new Double(0);
      ArrayList<Integer> currTour = null;
      for(int p = 0; i < tours.get(j).size(); p++)
      {
    	  currTour.add(Integer.parseInt(tours.get(j).get(p)));
      }
     
      for (int k = 0; k < currTour.size()-1; k++) {
        tourScore += adjMat[currTour.get(k) + 1][currTour.get(k + 1) + 1];
      }
    }

    
    return"";
  }

  public double distanceTo(Point point1, Point point2) {
    return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
  }

  public double distanceTo(City c1, City c2) {
    return Math
        .sqrt(Math.pow((c1.point.getX() - c2.point.getX()), 2) + Math.pow((c1.point.getY() - c2.point.getY()), 2));
  }

	public static ArrayList<ArrayList<City>> Permute(ArrayList<City> readIn) {
		
	    ArrayList<ArrayList<City>> result = new ArrayList<ArrayList<City>>();
	    result.add(new ArrayList<City>());
	 
	    for (int i = 0; i < readIn.size(); i++) {
	        ArrayList<ArrayList<City>> current = new ArrayList<ArrayList<City>>();
	        for (ArrayList<City> l : result) {
	            for (int j = 0; j < l.size()+1; j++) {
	                l.add(j, readIn.get(i));
	                ArrayList<City> temp = new ArrayList<City>(l);
	                current.add(temp);
	                l.remove(j);
	            }
	        }
	        result = new ArrayList<ArrayList<City>>(current);
	    }
	    return result;
	}

  /*
   * public double distanceTo(Point2D.Double point1, Point2D.Double point2) {
   * return Math.sqrt( Math.pow((point1.getX() - point2.getX()), 2) +
   * Math.pow((point1.getY() - point2.getY()), 2) ); }
   * 
   * public static ArrayList<ArrayList<String>> Permute(ArrayList<String> readIn)
   * { ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
   * 
   * //start from an empty list result.add(new ArrayList<String>());
   * 
   * for (int i = 0; i < readIn.size(); i++) { //list of list in current iteration
   * of the array num ArrayList<ArrayList<String>> current = new
   * ArrayList<ArrayList<String>>();
   * 
   * for (ArrayList<String> l : result) { // # of locations to insert is largest
   * index + 1 for (int j = 0; j < l.size()+1; j++) { // + add num[i] to different
   * locations l.add(j, readIn.get(i));
   * 
   * ArrayList<String> temp = new ArrayList<String>(l); current.add(temp);
   * 
   * //System.out.println(temp);
   * 
   * // - remove num[i] add l.remove(j); } }
   * 
   * result = new ArrayList<ArrayList<String>>(current); }
   * 
   * return result; }
   */
  public void place(String tour, double score) {
    if (scores.isEmpty()) {
      bestTour = tour;
      bestScore = score;
      scores.put(bestTour, bestScore);
    } else if (score < bestScore) {
      bestScore = score;
      bestTour = tour;
      scores.put(bestTour, bestScore);
    } else {
      scores.put(tour, score);
    }
  }

  @Override
  public void getData() {
	  System.out.println();;
		
		for(int i = 0; i < fileInfo.size(); i++)
		{
			System.out.println(i + " " + fileInfo.get(i));
		}
		
		System.out.println();;
		System.out.println("Best Tour: " + bestTour + " " + bestScore);
		
		System.out.println();
		System.out.println();;
	  
  }
  
}
