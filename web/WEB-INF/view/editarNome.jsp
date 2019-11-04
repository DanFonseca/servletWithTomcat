<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 12/10/2019
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<html>
<head>
    <title>Edite seu nome</title>
</head>
<body>
    <form action="controle" method="post">
        <input type="text" name="nome" value="${nome}">
        <input type="text" name="data" value=" <fmt:formatDate value="${data}" pattern="dd/MM/yyyy"/>">
        <input type="hidden" value="${index}" name="index">
        <input type="hidden" value="cadastrarNome" name = "function">

        <button  type="submit"> Editar </button>
    </form>

</body>
</html>
