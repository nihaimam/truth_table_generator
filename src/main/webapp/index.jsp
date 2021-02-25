<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var servletURL = window.location.origin;
  </script>
<title>Assignments</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h1>SWE 432 Assignments</h5>
<h2>Authors: Elizabeth Tracy, Niha Imam, Tori Broadnax</h2>
<p>Check out our Projects </p>
<button onclick="window.location.assign(servletURL+'/Logic');">A5: Logic Truth Tables </button>
<button onclick="window.location.assign(servletURL+'/logison');">A7: Truth Tables to File </button>
<button onclick="window.location.assign(servletURL+'/NewLogic');">A8: Truth Tables Asynchronously </button>
</body>
</html>
