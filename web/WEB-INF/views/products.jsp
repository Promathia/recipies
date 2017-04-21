<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <title>Recipes advisor</title>
    <script type="text/javascript" src="<c:url value="/resources/theme1/js/jquery-3.2.0.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/theme1/js/jquery-ui-1.12.1/jquery-ui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/theme1/js/recipes_advisor_page.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/js/jquery-ui-1.12.1/jquery-ui.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/css/recipes_advisor_page.css"/>">

</head>

<body>

<div id="products_list_div">
    <ul id="products_list">
        <c:forEach items="${products}" var="product">
            <li id = ${product.id}>${product.name}</li>
        </c:forEach>
    </ul>
</div>

<div id="bin_div">
    <ul id="bin_list">
    </ul>
</div>

<div id="recipe_advised_div">
    <ul id="recipe_advised_list">
        <c:forEach items="${recipes}" var="recipe">
            <li>${recipe.name}</li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
