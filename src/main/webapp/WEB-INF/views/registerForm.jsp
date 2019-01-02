<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<html>
  <head>
    <title>Microblogs</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/css/style.css" />" >
  </head>
  <body>
	<h1>Register</h1>
	
	<form:form method="POST" >
	 First Name:
	     <input type="text" name="firstName" /><br/>
	 Last Name:
	     <input type="text" name="lastName" /><br/>
	 Email:
	     <input type="text" name="email" /><br/>
	 User Name:
	     <input type="text" name="username" /><br/>
	 Password:
	     <input type="password" name="password" /><br/> 
	 <input type="submit" value="Register" />
	</form:form>
 </body>
</html>