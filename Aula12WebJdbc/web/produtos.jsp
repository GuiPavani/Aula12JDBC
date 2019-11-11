<%-- 
    Document   : produtos
    Created on : Nov 7, 2019, 11:01:36 PM
    Author     : Guilherme
--%>

<%@page import="br.com.fatecpg.db.Product"%>
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
        <h1>Produtos</h1>
        <table border ="1">
            <tr>    
                <th>ID Fabrica</th>
                <th>ID Produto</th>
                <th>Codigo do Produto</th>
                <th>Preco</th>
                <th>Disponivel</th1>
                <th>Descricao</th1>
            </tr>
            <% try{ %>
            <%int id = Integer.parseInt(request.getParameter("id"));%>
            <%for (Product p: Product.getList(id)) { %>
                <tr>
                    <td><%= p.getFabid()%></td>
                    <td><%= p.getId()%></td>
                    <td><%= p.getCodigo() %></td>
                    <td><%= p.getPreco() %></td>
                    <td><%= p.getDisp() %></td>
                    <td><%= p.getDesc() %></td>
                </tr>
                <% } %>
                <%} catch(Exception e) {%>
                <tr><td colspan="3"> Erro: <%= e.getMessage() %> </td></tr>
                <% } %>
        </table>
        </div>
    </body>
</html>
