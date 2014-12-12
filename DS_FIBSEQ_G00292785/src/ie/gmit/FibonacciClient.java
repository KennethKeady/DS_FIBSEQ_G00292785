package ie.gmit;

import java.net.MalformedURLException;
import java.rmi.*;

public class FibonacciClient 
{
	public String rmiRun(int length) throws RemoteException, MalformedURLException, NotBoundException
	{
		RemoteFibonacci fms = (RemoteFibonacci) Naming.lookup("rmi://localhost:1050/fibonacciService");
		String rmiRunner = fms.getFibonacciSequence(length);
		return rmiRunner;
	}

	
}
