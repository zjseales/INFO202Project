<%-- 
    Document   : create-account
    Created on : 16/08/2022, 6:04:51 PM
    Author     : Zac Seales - 6687905
--%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Creation Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
	<body>
            <main>
		<%@include file="WEB-INF/jspf/navigation.jspf"%>
                        
                <h1 class="font1">Create a new account</h1>

		<fieldset>

		<legend>Customer Details</legend>
                        
                <%
                    String validation = (String)session.getAttribute("validation");
                            validation = validation != null ? validation : "";
                %>

                <p><%= validation %></p>

		<form action="create-account" method="POST">
                    <label>First Name:</label><input type="text" name="firstName"/>
                    <label>Surname:</label><input type="text" name="surname"/>
                    <label>Username:</label><input type="text" name="username"/>
                    <label>Password:</label><input type="password" name="password"/>
                    <label>Email Address:</label><input type="email" name="emailAddress"/>
                    <label>Shipping Address:</label><textarea type="text" name="shippingAddress"></textarea>    
            
                    <button type="submit">Create Account</button>
		</form>

		</fieldset>

            <a class="nav" href="index.jsp">Back to Home</a>

        </main>
    </body>
</html>
