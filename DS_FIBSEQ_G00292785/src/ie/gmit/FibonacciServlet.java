package ie.gmit;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import  com.sun.org.apache.xml.internal.security.Init;
@WebServlet("/FibonacciServlet")
public class FibonacciServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	FibonacciService fibonacciService = new FibonacciService();	
	private LinkedList<FibonacciRequest> inQueue = new LinkedList<FibonacciRequest>();
	private Map<Integer , String> outQueue = new HashMap<Integer , String>();
		
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	String input = request.getParameter("Input").toString();
    	if(input.equals("add"))
    	{
    		//System.out.println("Adding");
    		int length = Integer.parseInt(request.getParameter("length"));
            int jobID = fibonacciService.add(length);
            System.out.println(length);
            System.out.println(jobID);
            
            if(length >0 && length <50)
    		{
            	FibonacciCreation fibonacciCreation = new FibonacciCreation(length);
            	String fibonacciResult = fibonacciCreation.getFibonacciSequence(length);
    			response.setContentType("text/plain"); 
    		    response.setCharacterEncoding("UTF-8");
    		    response.getWriter().write(String.valueOf("\nYou have selected a Fibonacci sequence of length " + String.valueOf(length)));
    		    response.getWriter().write(String.valueOf("\nCurrent Job Number is: " + String.valueOf(jobID)));
    		    response.getWriter().write(String.valueOf("\nRequested Fibonacci Sequence: " + String.valueOf(fibonacciResult)));
    		    inQueue.add(new FibonacciRequest(jobID, length));
    		    outQueue.put(jobID, fibonacciResult);  		    
    		    
    		}
            
            else
            {
            	 response.getWriter().write(String.valueOf("\nPlease enter a number between 1 and 50"));
            }
            /*try
            {
            	//RemoteFibonacci remoteFibonacci = (RemoteFibonacci)Naming.lookup("rmi://localhost:1099/fibonacciService");
            	//String fibonacciSequence = remoteFibonacci.getFibonacciSequence(length);
            	//fibonacciService.put(jobID, fibonacciSequence);
            	//System.out.println(fibonacciSequence);
            	request.setAttribute("JobID", jobID);
            	//request.setAttribute("FibSequence", fibonacciSequence);
            	request.getRequestDispatcher("Polling.jsp").forward(request, response);
            }
            catch (Exception e)//(NotBoundException e)
            {
            	System.out.println("Error in RMI");
            	e.printStackTrace();
            }*/
    	}
    	
    	/*else if(input.equals("poll"))
    	{
    		System.out.println("Polling");
    		String pollRequest = request.getParameter("JobID");
    		if(pollRequest!=null)
    		{
    			request.getRequestDispatcher("Result.jsp").forward(request, response);
    		}
    		else
    		{
    			request.getRequestDispatcher("Polling.jsp").forward(request, response);
    		}
    	}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
