/*
 * Written by Alexa Adams
 */

public class SheepScheduler 
{
	private MinHeap<Sheep> waitingSheep;	//stores all sheep
	
	public SheepScheduler()
	{
		waitingSheep = new MinHeap<>();
	}
	
	public Sheep[] scheduleShearing(Sheep[] allSheep)
	{
		if(allSheep == null || allSheep.length == 0)
			return null;
		
		Sheep[] byArrival = new Sheep[allSheep.length];
		
		for(int i = 0; i < allSheep.length; i++)
			byArrival[i] = allSheep[i];
		
		for(int i = 0; i < byArrival.length - 1; i++)
		{
            int minIndex = i;
            for(int j = i + 1; j < byArrival.length; j++)
            {
                if(byArrival[j].getArrivalTime() < byArrival[minIndex].getArrivalTime())
                    minIndex = j;
            }
            
            if(minIndex != i)
            {
                Sheep temp = byArrival[i];
                byArrival[i] = byArrival[minIndex];
                byArrival[minIndex] = temp;
            }
		}
		
		Sheep[] result = new Sheep[allSheep.length];
        int resultIndex = 0;
        int nextArrivalIndex = 0;
        int currentTime = byArrival[0].getArrivalTime(); // start at earliest arrival
        
        //process arrivals and shearing until done
        while(nextArrivalIndex < byArrival.length || waitingSheep.getSize() > 0)	// Enqueue all sheep that have arrived at or before currentTime
        {
            while(nextArrivalIndex < byArrival.length && byArrival[nextArrivalIndex].getArrivalTime() <= currentTime) 
            {
                waitingSheep.add(byArrival[nextArrivalIndex]);
                nextArrivalIndex++;
            }

            if(waitingSheep.getSize() == 0) 
            {
                if(nextArrivalIndex < byArrival.length) 
                {
                    currentTime = byArrival[nextArrivalIndex].getArrivalTime();
                    continue;
                } 
                else 
                	break;
            }

            Sheep next = waitingSheep.remove();
            result[resultIndex++] = next;

            currentTime += next.getShearingTime();
        }
        
        //shrink result to actual size (resultIndex)
        Sheep[] finalResult = new Sheep[resultIndex];
        for(int i = 0; i < resultIndex; i++) 
        	finalResult[i] = result[i];
        
        return finalResult;
	}
}
