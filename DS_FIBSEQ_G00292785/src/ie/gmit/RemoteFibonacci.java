package ie.gmit;

import java.rmi.*;

public interface RemoteFibonacci extends Remote
{
	public int getFibSequence(int length) throws RemoteException;
}
