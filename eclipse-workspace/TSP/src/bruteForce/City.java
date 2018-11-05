package bruteForce;

import java.awt.geom.Point2D;

public class City {

	String name;
	Point2D.Double point;
	Double distance;
	Boolean unVisited;
	
	public City(String name, Double x, Double y)
	{
		this.name = name;
		point = new Point2D.Double(x, y);
	}
	
	public Point2D.Double getPoint()
	{
		return point;
	}
	
	public String getName()
	{
		return name;
	}
	
}
