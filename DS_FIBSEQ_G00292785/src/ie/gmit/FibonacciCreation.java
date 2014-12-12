package ie.gmit;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class FibonacciCreation extends UnicastRemoteObject implements RemoteFibonacci
{
	private static final long serialVersionUID = 1L;
	private RemoteFibonacci remoteFibonacci;

	protected FibonacciCreation(int portNum) throws RemoteException 
	{
		super(portNum);		
	}

	public FibonacciCreation(RemoteFibonacci remoteFibonacci) throws RemoteException
	{
		super();
		this.remoteFibonacci = remoteFibonacci;
	}
	
	public String getFibonacciSequence(int length) throws RemoteException 
	{
		if (length < 0) 
		{
			return " ";
        }
		
		else if(length == 1)
		{
			return "0";
		}
		
        else 
        {
        	return getFibonacciSequence(length-1)+getFibonacciSequence(length-2);
        }
	}
	
	public RemoteFibonacci getRemote() 
	{
		return remoteFibonacci;
	}	
}
