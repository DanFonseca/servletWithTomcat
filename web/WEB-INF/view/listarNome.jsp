
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Listar empresas</title>
</head>


<body>
<p><c:import url="logout.jsp"/>
    <a href="${pageContext.request.contextPath}/listaNomesService?function=json"> | listaJson</a>
    <a href="${pageContext.request.contextPath}/listaNomesService?function=xml"> | listarXML</a>

<ul>
    <p>Olá, ${usuarioLogado}</p>
    <br>
    <c:if test="${empty listNomes}"><h1>Sem nome na lista</h1></c:if>

    <c:forEach var="lista"  items="${listNomes}">
        <li>${lista.nome}
            <fmt:formatDate value="${lista.data}" pattern="dd/MM/yyyy"/>
            <a href="/webApp/controle?function=deletarNome&id=${lista.id}"> -Remover</a>
            <a href="/webApp/controle?function=editarNome&id=${lista.id}"> -Editar</a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
