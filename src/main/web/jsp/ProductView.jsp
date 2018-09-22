<%--
  Created by IntelliJ IDEA.
  User: YanTingting
  Date: 2018/9/20
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Save Produt</title>
    <style type="text/css">
        @import url("<c:url: value="/css/main.css"/>");
    </style>
</head>
<body>
<div id="global">
    <h4>The Product has been saved.</h4>
    <p>
        <h5>Details:</h5>
    Product Name: ${product.name}<br/>
    Description: ${product.description}<br/>
    Price: ${product.price}
    </p>
</div>
</body>
</html>
