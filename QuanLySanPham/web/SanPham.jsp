<%-- 
    Document   : SanPham
    Created on : Jun 26, 2020, 1:15:41 PM
    Author     : ASUS
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="SanPhamController">
            <table>
                <tr>
                    <th>ID:</th>
                    <td><input type="text" readonly="readonly" name="id" value="<c:out value='${sanpham.id}'/>"/></td>
                </tr>
                <tr>
                    <th>Ten san pham:</th>
                    <td><input type="text" name="tensp" value="<c:out value='${sanpham.tensp}'/>"/></td>
                </tr>
                <tr>
                    <th>Quy cach:</th>
                    <td><input type="text" name="quycach" value="<c:out value='${sanpham.quycach}'/>"/></td>
                </tr>
                <tr>
                    <th>Gia:</th>
                    <td><input type="text" name="gia" value="<c:out value='${sanpham.gia}'/>"/></td>
                </tr>
                 <tr>
                    <th>Nha san xuat:</th>
                    <td><input type="text" name="nhasx" value="<c:out value='${sanpham.nhasx}'/>"/></td>
                </tr>
                 <tr>
                    <td colspan="2"><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form>
                
                <a href="SanPhamController?action=listSanPham">Back</a>
    </body>
</html>
