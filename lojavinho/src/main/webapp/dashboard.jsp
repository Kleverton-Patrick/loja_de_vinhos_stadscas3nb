<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="dashboard.css">

<head>
    <meta charset="UTF-8">
    <title>Painel</title>
</head>
<body>

    <!-- Verifica se o usuário admin está logado -->
    <div class="admin">
        <c:if test="${sessionScope.loggedUser != null}">
            <span>Admin: ${sessionScope.loggedUser}</span>
            <a href="/logout">Logout</a>
        </c:if>
    </div>

    <div class="container">
        <h2>Vinhos</h2>
        <table>
            <tr>
                <th>ID</th>
                <td>Nome</td>
                <c:if test="${sessionScope.loggedUser != null}">
                    <th>Actions</th>
                </c:if>
            </tr>
            <c:forEach var="vinho" items="${vinhos}">
                <tr>
                    <td>${vinho.id}</td>
                    <td>${vinho.name}</td>
                    <c:if test="${sessionScope.loggedUser != null}">
                        <td>
                            <form action="/delete-vinho" method="post">
                                <input type="hidden" id="id" name="id" value="${vinho.id}">
                                <button type="submit">Delete</button>
                                <span> | </span>
                                <a href="index.jsp?id=${vinho.id}&name=${vinho.name}">Update</a>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
