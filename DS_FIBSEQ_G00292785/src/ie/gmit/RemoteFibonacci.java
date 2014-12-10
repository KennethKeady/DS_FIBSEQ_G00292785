package ie.gmit;

import java.rmi.*;

public interface RemoteFibonacci extends Remote
{
	public String getFibSequence(int max) throws RemoteException;
}
