<%-- 
    Document   : purchase
    Created on : Nov 10, 2019, 11:49:32 PM
    Author     : guilh
--%>

<%@page import="br.com.fatecpg.db.Purchase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <h2><a href="manufacturer.jsp">Voltar</a></h2>
        <div align="center">
        <h1>Compras</h1>
        <table border ="1">
            <tr>    
                <th>ID Cliente</th>
                <th>ID Produto</th>
                <th>Quantidade</th>
            </tr>
            <% try{ %>
            <%int id = Integer.parseInt(request.getParameter("id"));%>
            <%for (Purchase p: Purchase.getList(id)) { %>
                <tr>
                    <td><%= p.getId()%></td>
                    <td><%= p.getIdproduto()%></td>
                    <td><%= p.getQuantidade()%></td>
                </tr>
                <% } %>
                <%} catch(Exception e) {%>
                <tr><td colspan="3"> Erro: <%= e.getMessage() %> </td></tr>
                <% } %>
        </table>
        </div>
    </body>
</html>
