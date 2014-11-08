<%@page import="java.util.ArrayList"%>
<%@page import="contact.Contact"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Contacts list</title>
</head>
<body>
<% 
ArrayList<Contact> list = new ArrayList<Contact>();
//storing passed value from jsp
list = (ArrayList<Contact>)request.getAttribute("contacts");

if(list != null) {
	out.println("<table><thead><tr><th>Name</th><th>Email</th><th>Action</th></tr></thead><tbody>");
	for(Contact c : list) {
	    out.println("<tr><td>" + c.getName() + "</td>");
	    out.println("<td>" + c.getMail() + "</td>");
	    String s = "<form action=\"ContactDBManager\" method=\"POST\">";
	    s += "<input type=\"hidden\" name=\"action\" value=\"removeContact\" />";
	    s += "<input type=\"hidden\" name=\"name\" value=\"" + c.getName() + "\" />";
	    s += "<input type=\"hidden\" name=\"mail\" value=\"" + c.getMail() + "\" />";
	    s += "<button type=\"submit\">Delete contact</button>";
	    s += "</form>";
	    out.println("<td>" + s + "</td></tr>");
	}
	out.println("</tbody></table>");
}
%>
<br>
<a href="ContactDBManager?action=createContact">Create new contact</a>
</body>
</html>