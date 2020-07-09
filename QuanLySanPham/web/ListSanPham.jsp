<%-- 
    Document   : ListSanPham
    Created on : Jun 26, 2020, 1:09:00 PM
    Author     : ASUS
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <form action="./search.jsp" method="POST" style="margin-bottom: 20px">
                <label>Search by name: </label>
                <input type="text" name="search"/>
                <input type="submit"/>
            </form>
        </center>       
        <table border="1" align="center" style="margin-bottom: 20px">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ten sp</th>
                    <th>quy cach</th>
                    <th>gia tien</th>
                    <th>nha san xuat</th>
                    <th colspan="2">action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sanphams}" var="sp">
                    <tr>
                        <td><c:out value="${sp.id}"/></td>
                        <td><c:out value="${sp.tensp}"/></td>
                        <td><c:out value="${sp.quycach}"/></td>
                        <td><c:out value="${sp.gia}"/></td>
                        <td><c:out value="${sp.nhasx}"/></td>
                        <td><a href="SanPhamController?action=edit&id=<c:out value="${sp.id}"/>">Edit</a></td>
                        <td><a href="SanPhamController?action=delete&id=<c:out value="${sp.id}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
     <div align="center" style="margin-right:40%">
            <a href="SanPhamController?action=insert" >Create</a>
        </div>
    </body>
</html>
