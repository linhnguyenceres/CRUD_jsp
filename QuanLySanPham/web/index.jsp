<%-- 
    Document   : index
    Created on : Jun 26, 2020, 1:05:23 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <jsp:forward page="/SanPhamController?action=listSanPham"/>
    </body>
</html>
