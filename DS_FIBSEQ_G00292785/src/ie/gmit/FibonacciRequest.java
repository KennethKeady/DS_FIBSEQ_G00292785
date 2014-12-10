package ie.gmit;

import java.io.*;

public class FibonacciRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int jobID;
	private int length;
	
	public int getJobID() 
	{
		return jobID;
	}

	public void setJobID(int jobID) 
	{
		this.jobID = jobID;
	}

	public int getLength() 
	{
		return length;
	}

	public void setLength(int length) 
	{
		this.length = length;
	}

	public FibonacciRequest(int jobID, int length) 
	{
		super();
		this.jobID = jobID;
		this.length = length;
	}
}
