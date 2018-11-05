package bruteForce;
import java.util.*;
import java.io.File;
import java.awt.*;
import java.awt.List;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BruteForceSolver implements TSPSolver 
	{

	String filename;
	String data;
	String solution, intial;
	String bestTour;
	StringBuilder sb;
	ArrayList<String> perms, cities;
	ArrayList<String> list;
	ArrayList<Point> ps;
	Map<String, Double> scores;
	double distance, bestScore;
	File file;
	Scanner scanner;
	ArrayList<String> arr = new ArrayList<String>();
	ArrayList<String> readIn = new ArrayList<String>();
	ArrayList<ArrayList<City>> tours;
	String space = " ";
	ArrayList<City> cs = new ArrayList<City>();
	ArrayList<String> fileInfo = new ArrayList<String>();
	
	public BruteForceSolver(String filename) throws FileNotFoundException 
	{		
		this.filename = filename;
		file = new File(filename);
	      data = filename.toString();
	      try {
	        scanner = new Scanner(file);
	      } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      
	      list = new ArrayList<String>();
	      sb = new StringBuilder();
	      perms = new ArrayList<String>();
	      cities = new ArrayList<String>();
	      scores = new HashMap<String, Double>();
	      ps = new ArrayList<Point>();
	  
	      /*    while(scanner.hasNext())
	      {
	    	  fileInfo.add(scanner.next());
	   	  }
	          for(int k = 19; k < fileInfo.size(); k++)
	      {
	    	  list.add(fileInfo.get(k));
	      }
	*/
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
	}
	
	public String getFileName()
	{
		return filename;
	}
	
	
	
	public String solve()
	{ 
      int i = 0;
      while(i < list.size() - 2)
      {
          String city = list.get(i);
          Double x = Double.parseDouble(list.get(i+1));
          Double y = Double.parseDouble(list.get(i+2));
          cs.add(new City(city, x, y));
          i = i + 3;
      }
      
      tours = Permute(cs);
  
		for(int m = 0; m < tours.size(); m++)
		{
			score(tours.get(m));
		}
		
	//	FileMaker m = new FileMaker(list, "BruteForce", filename, bestTour, bestScore);
		
	//	return m.getFileName();
		return "";
	}

	/*
	 * cost = City.distance
	 */
	private void getBest()
	{
		System.out.println();
		System.out.println();
		System.out.println(bestTour + " " + bestScore);
	}
	
	public double score(ArrayList<City> cs)
	{
		for(int i = 0; i < cs.size()-1; i++)
		{
			City c1 = cs.get(i);
			City c2 = cs.get(i+1);
			distance = distance + distanceTo(c1, c2);
		}
		// back to home
		City c1 = cs.get(cs.size()-1);
		City c2 = cs.get(0);
		distance = distance + distanceTo(c1, c2);
		place( getTourNames(cs), distance);
		return distance;
	}
	
	public String getCityString(ArrayList<City> ls)
	{
		StringBuilder b = new StringBuilder();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < ls.size(); i++)
		{
			list.add(ls.get(i).getName());
		}
		list.add(ls.get(0).getName());		
		return list.toString();
	}
	
	public double distanceTo(Point point1, Point point2)
	{	
		return 		Math.sqrt(
					Math.pow((point1.getX() - point2.getX()), 2) +
					Math.pow((point1.getY() - point2.getY()), 2)
						);
	}
	
	public double distanceTo(City c1, City c2)
	{
		return Math.sqrt(
						Math.pow((c1.point.getX() - c2.point.getX()), 2) +
						Math.pow((c1.point.getY() - c2.point.getY()), 2)
						);
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
	
	public void place(String tour, double score)
	{
		if(scores.isEmpty())
		{
			bestTour = tour;
			bestScore = score;
			scores.put(bestTour, bestScore);
		} 
		else if(score < bestScore)
		{
			bestScore = score;
			bestTour = tour;
			scores.put(bestTour, bestScore);
		} 
		else
		{
			scores.put(tour, score);
		}
	}
	
	public String getTourNames(ArrayList<City> list)
	{
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < list.size(); i++)
		{
			b.append(list.get(i).name + " ");
		}
		return b.toString();
	}
	
	public void getData()
	{

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
