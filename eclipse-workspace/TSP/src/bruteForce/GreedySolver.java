package bruteForce;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GreedySolver implements TSPSolver {
	
	String fileName;
	String data;
	String solution, intial;
	String bestTour;
	StringBuilder sb;
	ArrayList<String> perms, cities;
	ArrayList<String> list;
	ArrayList<Point> ps;
	Map<String, Double> scores;
	double distance;
	double bestScore = 0;
	File file;
	Scanner scanner;
	ArrayList<String> arr = new ArrayList<String>();
	ArrayList<String> fileInfo = new ArrayList<String>();
	ArrayList<ArrayList<City>> tours;
	String space = " ";
	ArrayList<City> cs = new ArrayList<City>();
	StringBuilder bestTourSoFar = null;
	StringBuilder tour = null;
	
	public GreedySolver(String fileName) throws FileNotFoundException
	{
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
	public String solve()  {
	  
		for(int j = 0; j < tours.size(); j++)
		{
			ArrayList<City> g =tours.get(j);
			//mark all as unvisited
			StringBuilder local = null;		
	//		City startCity = g.get(0);
			//	City currCity = null;
		//	startCity.unVisited = false;
			Double costOfBestTourSoFar = new Double(0);
			Double cost = new Double(0);
		
			for(int k = 0; k < g.size(); k++) {
				markAllUnvisited(g);
				City s = g.get(k);
				//		local.append(s.name + " ");
				s.unVisited = false;
				City currCity = s;
				while(hasUnvisited(g))
				{
					City c = getClosestUnvisited(g, currCity);
			//		tour.append(c.name + " ");
					cost += distanceTo(currCity, c);
					c.unVisited = false;
					currCity = c;
				}	
				cost += distanceTo(currCity, s);
			/*if(costOfBestTourSoFar > cost)
			{
				bestTourSoFar = tour;
				costOfBestTourSoFar = cost;
				bestScore = costOfBestTourSoFar;
				bestTour = tour.toString();
			}*/
				place(g.toString(), cost);
			}
		
			return g.toString();
		}
		return "";
		}
	
	public City getClosestUnvisited(ArrayList<City> list, City currCity)
	{		
		double cost, bestCost;
		cost = 0;
		bestCost = 0;
		City chosen = null;
		for(int i = 0; i < list.size(); i++)
		{
			City cur = list.get(i);
			if(cur.unVisited = true)
			{
				cost = distanceTo(currCity, list.get(i));
				if(cost < bestCost)
				{
					chosen = cur;
					bestCost = cost;
				}
			}
		}
		return chosen;
	}
	
	public Boolean hasUnvisited(ArrayList<City> list)
	{
		Boolean reply = false;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).unVisited == true)
			{
				reply = true;
				break;
			}
			else 
			{
				reply = false;
			}
		}
		return reply;
	}
	
	private void markAllUnvisited(ArrayList<City> list)
	{
		for(int i = 0; i < list.size(); i++)
			list.get(i).unVisited = true;
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
