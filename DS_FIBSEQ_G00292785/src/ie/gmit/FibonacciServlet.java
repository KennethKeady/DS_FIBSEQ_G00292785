package ie.gmit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet("/FibonacciServlet")
public class FibonacciServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	FibonacciService fibService = new FibonacciService();	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	int length = Integer.parseInt(request.getParameter("length"));
        int jobID = fibService.add(length);
                
        PrintWriter out = response.getWriter();
        out.println(
        "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"  \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
        	"<html> \n" +
        		"<head> \n" +
        			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
        			"<title>Fibonacci Sequence</title> \n" +
        		"</head> \n" +
        		"<body> \n" +
        			"<font size=\"10px\" Fibonacci=\"\">" +
        			"Fibonacci sequence length of : "+ length +" chosen" +
        			"\r\nYour job identification number is : "+ jobID +" " +
        			"</font> \n" +
        		"</body> \n" +
        	"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
