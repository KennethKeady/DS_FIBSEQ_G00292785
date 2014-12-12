package ie.gmit;

import java.math.BigInteger;
import java.rmi.RemoteException;
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
		switch(length){
		case 0:
			return "1";
			
		case 1:
			return "1, 1";
			default:
				BigInteger f1 = BigInteger.ONE;
				BigInteger f2 = BigInteger.ONE;
				BigInteger fib = BigInteger.ZERO;
				StringBuffer fibSequence = new StringBuffer("0, 1, 1, ");
				for (int i = 0; i < length-3; i++) {
					fib = f1.add(f2);
					fibSequence.append(fib).append(", ");
					f1 = f2;
					f2 = fib;
				}
				return fibSequence.toString();
		}
	}
	
	public RemoteFibonacci getRemote() 
	{
		return remoteFibonacci;
	}	
}
