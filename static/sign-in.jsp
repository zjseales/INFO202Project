<%-- 
    Document   : sign-in
    Created on : 24/08/2022, 4:46:12 AM
    Author     : Zac Seales - 6687905
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    
    <body>
        <main>
            <%@include file="WEB-INF/jspf/navigation.jspf"%>
            
            <h1 class="font1">Sign In</h1>
            
            <fieldset>
			<legend>Enter Login details</legend>
                        
                        <%
				String validation = (String)session.getAttribute("validation");
				validation = validation != null ? validation : "";
			%>

			<p><%= validation %></p>

			<form action="sign-in" method="POST">
                                       
                            <label>Username:</label><input type="text" name="username"/>
                            <label>Password:</label><input type="password" name="password"/>
            
                            <button type="submit">Sign-in</button>

			</form>

            </fieldset>

        </main>
    </body>
</html>
