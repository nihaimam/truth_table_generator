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
@WebServlet(name = "Logic Predicate Servlet", urlPatterns = {"/Logic"}) 
public class Logic extends HttpServlet // Inheriting from HttpServlet makes this a servlet
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
		out.println("<h1>** SWE 432 - Assignment 5 **</h1>");
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
		out.println("<p><strong>CONTRIBUTION SUMMARY</strong><br>Beth, Tori, Niha<br><br>We all assisted each other with our code - often adjusting each other's work. The below is what each person was responsible for but we did also work on each other's.<br><br><i>Beth</i> built the Java Servlet printing the front end code from A3, updated the format of the input table, and worked on connecting the project with Git Hub and deploying.<br><i>Niha</i> processed the input logic predicate through a POST request, printed the truth tables, and handled incorrect input.<br><i>Tori</i> included the logical operator XOR in the input and in the table, created form validation for errors, and included the option for multiple types of syntax for the logical operators.</p>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}  // end doGet()


	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		ArrayList<Equation> variables = new ArrayList<>();
		ArrayList<Object> equation = new ArrayList<>();
		ArrayList<Object> output = new ArrayList<>();
		
		
		String var1 = request.getParameter("v1");
		String op = request.getParameter("op");
		op = op.replaceAll(" ","");
		String var2 = request.getParameter("v2");

		String input = var1 + " " + op + " " + var2;

		String inop = op;
		boolean validOp = true;
		boolean validVar = true;
		boolean validity = true;		

		if ((op.equals("&")) || (op.equals("&&")) || (op.equals("and")) || (op.equals("^")) || (op.equals("And")) || (op.equals("AND"))) {
			inop = "and";
		}
		else if ((op.equals("V")) || (op.equals("v")) || (op.equals("|")) || (op.equals("||")) || (op.equals("or")) || (op.equals("Or")) || (op.equals("OR"))) {
			inop = "or";
		}
		else if ((op.equals("xor")) || (op.equals("Xor")) || (op.equals("XOR")) || (op.equals("x"))) {
			inop = "xor";
		}
		else {
			validOp = false;
			out.println("<script type='text/javascript'>");
			out.println("alert('Invalid operator. Please try again')");
			out.println("location='Logic';");
			out.println("</script>");
		}

                Equation temp = new Equation(var1,true, 1);
                variables.add(temp);
                equation.add(temp);
                equation.add(op);
                temp = new Equation(var2,true, 2);
                variables.add(temp);
                equation.add(temp);


                //if (variables.size() > 1) {
                if (!(var1.equals("")) && !(var2.equals(""))) {
		        Table table = new Table(variables, equation, inop);
                        output = table.constructTable();
                }
                else {
			validVar = false;
			out.println("<script type='text/javascript'>");
			out.println("alert('Invalid variable. Please try again')");
			out.println("location='Logic';");
			out.println("</script>");
		}	

		// put values in a container for printing
		Properties newvals = new Properties();
		if (!(output.isEmpty()) && validVar && validOp) {
			newvals.put("tv1", var1);
			newvals.put("tv2", var2);
			newvals.put("tv3", "output");
			newvals.put("zero", output.get(0).toString());
			newvals.put("one", output.get(1).toString());
			newvals.put("two", output.get(2).toString());
			newvals.put("three", output.get(3).toString());
			newvals.put("four", output.get(4).toString());
			newvals.put("five", output.get(5).toString());
                	newvals.put("six", output.get(6).toString());
                	newvals.put("seven", output.get(7).toString());
                	newvals.put("eight", output.get(8).toString());
                	newvals.put("nine", output.get(9).toString());
               		newvals.put("ten", output.get(10).toString());
                	newvals.put("eleven", output.get(11).toString());
		}
		else {
			validity = false;
		}
		


		// *************** HTML ***************
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Truth Table Generator</title>");
		
		out.println("<style>");
		out.println("body { background-color: #D1F2EB; font-family: sans-serif; }");
		out.println("table { margin: 0 auto; width: 400px; padding: 2em; border: 2px solid #000; border-radius: 5em; background-color: #FFFFFF; }");
		out.println("td, th { text-align: left; padding: 10px; box-sizing: border-box; border: 2px solid #999; font: 1em sans-serif; }");
		out.println("h1, p { color: black; text-align: center; top: 3%; }");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>** SWE 432 - Assignment 5 **</h1>");
		out.println("<br>");
		out.println("<p>");
		out.println("<button onClick=\"location.href='https://swe432-assign5-ntb.herokuapp.com/Logic'\">Reset</button><br>");
		out.println("<br>");
		//out.print("<button onclick='document.location='https://swe432servlet.herokuapp.com/Logic''>reset</button><br><br>");
		out.print("<strong>YOU ENTERED:</strong><br><br>");
		//if (!validOp) { out.print("invalid operation"); }
		//else if (!validVar) { out.print("invalid or missing variables"); }
		//else if (!validity) { out.print("invalid logical expression"); }
		//else { out.print(input); }
		out.print(input);
		out.print("</p>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th id='tv1'>");
		if (newvals.getProperty("tv1") != null) {
		out.print(newvals.getProperty ("tv1"));
		}
		out.print("</th>");
		out.println("<th id='tv2'>");
		if (newvals.getProperty("tv2") != null) {
                out.print(newvals.getProperty ("tv2"));
		}
                out.print("</th>");
		out.println("<th id='tv3'>");
                if (newvals.getProperty("tv3") != null) {
		out.print(newvals.getProperty ("tv3"));
		}
                out.print("</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th id='zero'>");
		if (newvals.getProperty("zero") != null) {
                out.print(newvals.getProperty ("zero"));
		}
                out.print("</th>");
		out.println("<th id='one'>");
                if (newvals.getProperty("one") != null) {
		out.print(newvals.getProperty ("one"));
		}
                out.print("</th>");
               	out.println("<th id='two'>");
                if (newvals.getProperty("two") != null) {
		out.print(newvals.getProperty ("two"));
		}
                out.print("</th>");
                out.println("</tr>");
               	out.println("<tr>");
                out.println("<th id='three'>");
                if (newvals.getProperty("three") != null) {
		out.print(newvals.getProperty ("three"));
		}
                out.print("</th>");
                out.println("<th id='four'>");
                if (newvals.getProperty("four") != null) {
		out.print(newvals.getProperty ("four"));
		}
                out.print("</th>");
                out.println("<th id='five'>");
                if (newvals.getProperty("five") != null) {
		out.print(newvals.getProperty ("five"));
		}
                out.print("</th>");                
		out.println("</tr>");
               	out.println("<tr>");
                out.println("<th id='six'>");
                if (newvals.getProperty("six") != null) {
		out.print(newvals.getProperty ("six"));
		}
                out.print("</th>");
                out.println("<th id='seven'>");
                if (newvals.getProperty("seven") != null) {
		out.print(newvals.getProperty ("seven"));
		}
                out.print("</th>");
                out.println("<th id='eight'>");
                if (newvals.getProperty("eight") != null) {
		out.print(newvals.getProperty ("eight"));
		}
                out.print("</th>");
                out.println("</tr>");
               	out.println("<tr>");
                out.println("<th id='nine'>");
                if (newvals.getProperty("nine") != null) {
		out.print(newvals.getProperty ("nine"));
		}
                out.print("</th>");
                out.println("<th id='ten'>");
                if (newvals.getProperty("ten") != null) {
		out.print(newvals.getProperty ("ten"));
		}
                out.print("</th>");
                out.println("<th id='eleven'>");
                if (newvals.getProperty("eleven") != null) {
		out.print(newvals.getProperty ("eleven"));
		}
                out.print("</th>");
                out.println("</tr>");
		out.println("</table>");
		out.println("</body");
		out.println("</html>");

	}

}  // end 
