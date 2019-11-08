<%-- 
    Document   : customers
    Created on : Nov 4, 2019, 3:58:26 PM
    Author     : Guilherme
--%>

<%@page import="br.com.fatecpg.db.Manufacturer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabricantes - JavaDB Sample</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <h1>Fabricantes</h1>
        <table border ="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cidade / Estado</th>
                <th>E-mail</th1>
            </tr>
            <% try{ %>
            <%for (Manufacturer m: Manufacturer.getList()) { %>
                <tr>
                    <%int i = m.getId();%>
                    <td><a href="produtos.jsp?i=<%=i%>"><%= m.getId() %></a></td>
                    <td><%= m.getName() %></td>
                    <td><%= m.getCidade()%> / <%= m.getEstado() %></td>
                    <td><%= m.getEmail() %></td>
                </tr>
                <% } %>
                <%} catch(Exception e) {%>
                <tr><td colspan="3"> Erro: <%= e.getMessage() %> </td></tr>
                <% } %>
        </table>
    </body>
</html>
