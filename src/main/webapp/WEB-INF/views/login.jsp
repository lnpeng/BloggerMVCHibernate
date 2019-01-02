<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Custom Login Page</title>
	
	<style>
		.failed {
			color: red;
		}
	</style>
	
</head>

<body>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" 
		  method="POST">
	    <!-- Check for login error -->
	
		<c:if test="${param.error != null}">
		
			<i class="failed">You entered invalid username/password.</i>
			
		</c:if>
			
		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>
	
	<a href="<c:url value="/" />">Return to home</a>
</body>

</html>