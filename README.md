ASSIGNMENT 5
UPDATES:
	Beth: uploaded Logic.java which is the java servlet for the project.
	contains a doGet() function which pushes our original html to the backend.
	additional operations will need to occur within this. Contributions have been
	included & the gifs have been uploaded
	
	everything is pushed to github: swe432_Assign5_NTB



INSTRUCTIONS:

If you work with partners, submit the same assignment and include all names. You can work with the same partners as previous assignments, or with different partners.

For this assignment, you will develop back-end software to support your front-end screen from assignment 3. Your software will have two major components. First, instead of having a flat file HTML page, write a Java servlet to print the front-end web page from your program in response to a GET request. This can be very simple, as in, just a sequence of print statements. The second component will process a logic predicate through a POST request.

Your program will do the following with the predicate:

Parse it into a structure that separates boolean variables and logical operators
Echo the predicate to the user
Print a complete truth table for the predicate, including a column with the result for each row
For example, the logic predicate X ∧ Y would result in a truth table something like:
row	X	Y	result
1.	true	true	true
2.	true	false	false
3.	false	true	false
4.	false	false	false
Note that you are to design the input and screen, design how the truth table is displayed, and design and write code to find clauses within the predicates. I am intentionally not giving you requirements about how the UI will look or behave. You may change your previous HTML form as much as you like.

Above are required elements (RE). I am also providing several optional elements (OE). You will need to complete at least 3 OEs to get full credit for the assignment. (No extra credit for implementing more.)

Optional elements:

Validate the input predicate and report invalid strings to the users in a clear way
Allow parentheses in the predicates, for example, “((A ∨ B) ∧ C)”
Include an additional logical operator—exclusive or
Allow multiple syntaxes for logical operators (for example, “&,” “&&,” “AND,” “and,” etc.
Give the user the option to display the truth-values in the truth table in different formats, such as “t-f,” “T-F,” “1-0,” “true-false,” etc.
Print all partners’ names on all screens!

Deploying and submitting
You can deploy your code through github & Heroku or on AWS. (Student accounts on AWS are free, but we must supply a credit card to create an account.) By default, we will go to your home page on mason.gmu.edu, and look on that page for a link labeled “SWE 432 assignment 5.” You should include links to your executable code (can be on github or AWS), and to your source code. Partners’ websites should both link to the same executable and source.

NOTE: It is your responsibility to make sure your code runs when we access it. Be sure to do deployment testing. We will access each assignment shortly after the due date and not look at your web site afterwards. If you submit an assignment after the stated due date, you must send an email to me & Jai telling us that it is ready. Be sure to include “swe432” in the subject.

Warning: The program is small, but several things may cause this assignment to take more time than you expect. You are using new technologies on an unfamiliar server. Debugging web software is notoriously painful. I strongly suggest you start early and get a minimum viable product (MVP) working, then extend your code until finished.

I advise the following process:

Make sure you can deploy and run an example servlet such as we did in class
Get your HTML exactly as you want it
Embed the HTML into your program and make sure it prints on a GET request
Start working on the back-end software by having it echo the input string
Finally, work on back-end processing of the form data, one element at a time
Remember that when web software crashes, the most common response is a blank browser window (I call it the white screen of frustration).
Grading rubric
(1 point) — Following directions
(2 points) — Correctly displaying the HTML form in response to a GET request
(2 points) — Correctly echoing the predicate in response to a POST request
(5 points) — Correctly printing the truth table with result values
(2 points) — Adherance to all usability concepts we have discussed
(1 point) — Java, HTML, and JavaScript readability, style, and maintainability
(1 point) — Other – to be determined during grading
(2 points) — For each OE that you implement (maximum of 3)
Bonus:
A 5% bonus for working collaboratively. You must include the collaboration summary to receive the collaboration bonus.
A 5% bonus for submitting by the stated due date. (I do not deduct points for submitting after the due date.)


## Follow the original guide
For more details about how to create a Tomcat setup from scratch, go to the Dev Center guide on how to [Create a Java Web Application using Embedded Tomcat](https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat).

## Resources: 

[Git Tutorial](https://kbroman.org/github_tutorial/pages/init.html)

[Heroku Postgres](https://devcenter.heroku.com/articles/heroku-postgresql)

[Heroku Dataclips](https://devcenter.heroku.com/articles/dataclips)

[Java XML writing and reading](https://www.vogella.com/tutorials/JavaXML/article.html)



