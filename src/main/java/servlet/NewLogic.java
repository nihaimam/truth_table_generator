// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// Import Java Libraries
import java.io.*;
import java.util.*;
import java.lang.*;

import java.util.ArrayList;

// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "New Logic", urlPatterns = {"/NewLogic"}) 
public class NewLogic extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{

	static String Domain = "cs.gmu.edu:8443";
	static String Path = "swe432-assign5-ntb.herokuapp.com/Logic";
	static String Servlet = "Logic Tables";


	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html"); // Tells the web container what we're sending back
                PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logic Predicate Servlet</title>");
		out.println("</head>");
		
		out.println("<style>");
		out.println("body { background-color: #D1F2EB; font-family: sans-serif; }");
		out.println("form { margin: 0 auto; width: 400px; padding: 2em; border: 2px solid #000; border-radius: 5em; background-color: #FFFFFF; }");
		out.println("ul { list-style: none; padding: 0; margin: 0; }");
		out.println("li { margin-top: 1em; }");
		out.println("label { display: inline-block; width: 90px; text-align: right; }");
		out.println("input{ font: 1em sans-serif; width: 275px; box-sizing: border-box; border: 2px solid #999; background-color: #D1F2EB; }");
		out.println("h1{ color: black; text-align: center; top: 3%; }");
		out.println(".button { padding-left: 90px; }");
		out.println("button { margin-left: 0.5em; }");
		out.println("</style>");

		out.println("<body>");
		out.println("<h1>** SWE 432 - Assignment 8 **</h1>");
		out.println("<br>");
		out.println("<ul>");
		out.println("<form method=\"post\">");
		out.println("<li>");
		out.println("<h3 align='center'><strong>TRUTH TABLE GENERATOR</strong></h3>");
		out.println("<p align='center'><b>Instructions:</b></p>");
		out.println("<p align='center'>Please enter two different variables to compare in <i>Variable 1</i> and <i>Variable 2</i>.<br>If you want to negate one or more of the variables, please add the following in front of the variable input:<br><li align='center'>! ~</li></p>");
		out.println("<p align='center'>Please enter one of the following operators into the <i>Operator</i> field:</p>");
		out.println("<p><li align='center'>and ^ & &&</li></p>");
		out.println("<p><li align='center'>or v |</li></p>");
		out.println("<p><li align='center'>xor</li></p>");
		out.println("<li>");
		out.println("<label for='variable_1'>Variable 1:</label>");
		out.println("<input type='text' id='v1' name='v1'/>");
		out.println("</li>");
		out.println("<li>");
		out.println("<label for='operation'>Operator:</label>");
		out.println("<input type='text' id='op' name='op'/>");
		out.println("</li>");
		out.println("<li>");
		out.println("<label for='variable_2'>Variable 2:</label>");
		out.println("<input type='text' id='v2' name='v2'/>");
		out.println("</li>");
		out.println("<li class='button'>");
		out.println("<button type='submit'>Submit</button>");
		//out.println("<button onClick='window.location.reload();'>Refresh</button>");
		out.println("</li");
		out.println("<li>");
		out.println("<br><br>");
		out.println("<p>Visit our Git Hub for this project: <a href='https://github.com/etracie/swe432_Assign5_NTB.git'>GitHub Link</a></p>");
		out.println("<p><strong>CONTRIBUTION SUMMARY</strong><br>Beth, Tori, Niha<br><br>Beth started the project by attempting to use Ajax. She set everything up and shifted things aroundwith a basic version but ran into a fatal error she couldn't fix.<br>Niha took over at this point and fixed the error and got further in getting the table up and running through Ajax. However, she also ran into a fatal error.<br>When Tori took over she made the switch to using Forwarding after attempts with Ajax. The end result is using Tori's Forwarding example.</p>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}  // end doGet()
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
	{
		RequestDispatcher rd=request.getRequestDispatcher("LogicForward");  
        rd.forward(request, response); 
	}
	
}  // end 
