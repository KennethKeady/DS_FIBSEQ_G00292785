package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FibonacciCreation extends UnicastRemoteObject implements RemoteFibonacci
{
	private static final long serialVersionUID = 1L;
	private RemoteFibonacci remoteFib;

	protected FibonacciCreation() throws RemoteException 
	{
		super();		
	}

	public FibonacciCreation(RemoteFibonacci remoteFib) throws RemoteException
	{
		super();
		this.remoteFib = remoteFib;
	}
	
	@Override
	public int getFibSequence(int length) throws RemoteException 
	{
		if (length < 2) 
		{
			return length;
        }
		
        else 
        {
        	return getFibSequence(length-1)+getFibSequence(length-2);
        }
	}
	
	public RemoteFibonacci getRemote() 
	{
		return remoteFib;
	}

}
