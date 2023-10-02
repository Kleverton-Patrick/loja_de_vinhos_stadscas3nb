<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
  <div>
    <h2>Vinhos</h2>
    <table>
        <tr>
            <th>ID</th>
            <td>Nome</td>
            <td>Acao</td>
        </tr>
        <c:forEach var="vinho" items="${vinhos}">
            <tr>
                <td>${vinho.id}</td>
                <td>${vinho.nome}</td>
                <td>
                    <form action="/delete-vinho" method="post">
                        <input type="hidden" id="id" name"id" values="${vinho.id}">
                        <button type="submit">Delete</button>
                        <span> | </span>
                        <a href="index.jsp?id=${vinho.id}&name=${vinho.name}">Update</a>
                    </form>
            </tr>
        </c:forEach>
    </table>
  </div>
</body>
</html>