package ie.gmit;

import java.util.*;

public class FibonacciService 
{
	
	Timer systemTimer;
	
	private LinkedList<FibonacciRequest> inQueue = new LinkedList<FibonacciRequest>();
	private Map<Integer , String> outQueue = new HashMap<Integer , String>();
	
	public int add(int length)
	{
		Random rand = new Random();
		int random = (int)(rand.nextInt(Integer.MAX_VALUE) + 1);
		inQueue.add(new FibonacciRequest(random, length));
		return random;
	}
		
	public String getResponse(int jobID)
	{
		if (outQueue.containsKey(jobID)) 
		{
			String result = outQueue.get(jobID);
			outQueue.remove(jobID);
			return result;
		}
		
		else
		{
			return null;
		}
	}
	
	public void put(int jobID,String fibonacciNum)
	{
		outQueue.put(jobID, fibonacciNum);
	}
	
}
