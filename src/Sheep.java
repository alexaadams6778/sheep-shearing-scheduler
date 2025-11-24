/*
 * Written by Alexa Adams
 */

public class Sheep implements Comparable<Sheep>
{
	private String name;
	private int shearingTime;
	private int arrivalTime;
	
	public Sheep()		//initialized to default values
	{
		name = "none";
		shearingTime = 0;
		arrivalTime = 0;
	}
	
	public Sheep(String aName, int time, int arrival)	//constructor
	{
		if(aName != null)
			name = aName;
		else
			name = "none";
		
		if(time >= 0)
			shearingTime = time;
		else
			shearingTime = 0;
		
		if(arrival >= 0)
			arrivalTime = arrival;
		else
			arrivalTime = 0;
	}
	
	public String getName()		//accessors
	{
		return name;
	}
	
	public int getShearingTime()
	{
		return shearingTime;
	}
	
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	public String toString()	//toString override
	{
		return "Name: " + name + ", Shear Time: " + shearingTime + ", Arrival Time: " + arrivalTime;
	}
	
	public int compareTo(Sheep aSheep)		//shorter shearing times = higher priority
	{
		if(aSheep == null)
			return -1;
		
		if(shearingTime < aSheep.getShearingTime())
			return -1;
		else if(shearingTime > aSheep.getShearingTime())
			return 1;
		else
			return name.compareTo(aSheep.getName());
	}
}
