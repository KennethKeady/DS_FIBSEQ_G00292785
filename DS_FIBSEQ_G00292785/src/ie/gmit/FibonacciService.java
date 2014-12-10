package ie.gmit;

import java.util.*;

public class FibonacciService 
{
	private LinkedList<FibonacciRequest> inQueue = new LinkedList<FibonacciRequest>();
	private Map<Integer , String> outQueue = new HashMap<Integer , String>();
	
	public int add(int length)
	{
		int randNum = (int)(Math.random() * length + System.currentTimeMillis());
		inQueue.add(new FibonacciRequest(randNum, length));
		return randNum;
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
}