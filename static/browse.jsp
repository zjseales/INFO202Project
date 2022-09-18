<%-- 
    Document   : browse
    Created on : 24/08/2022, 5:45:11 AM
    Author     : Zac Seales - 6687905
--%>

<%@page import="dao.CustomerDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="dao.DaoFactory"%>
<%@page import="domain.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Products Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    
    <body>
        <main>
            <%@include file="WEB-INF/jspf/navigation.jspf"%>
                        
            <h1 class="font1">Products</h1>
            
            <a href="browse.jsp?category=All"><button>All</button></a>

            <%
                ProductDAO dao = DaoFactory.getProductDAO();
                Collection<String> cats = dao.getCategories();

                for (String category : cats) {
            %>
                <a href="browse.jsp?category=<%= category %>"><button><%= category %></button></a>
            <%
                }
            %>
            
            <table>
         <thead>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Available</th>
              </tr>
         </thead>
         <tbody>
            <%
                String category = request.getParameter("category");
                
                Collection<Product> products;
                
                if (category == null || category.equals("All")) {
                    products = dao.getProducts();
                } else {
                    products = dao.filterByCategory(category);
                }
                
                for (Product product : products) {
            %>
            <tr>
                <td><%= product.getName() %></td>
                <td><%= product.getDescription() %></td>
                <td><%= product.getListPrice() %></td>
                <td><%= product.getQuantityInStock() %></td>
                
		<td><button>Buy</button></td>
            </tr>
            <%
                }
            %>
         </tbody>
    </table>

    <a class="nav" href="index.jsp">Return to home</a>
            
        </main>
    </body>
    
</html>
