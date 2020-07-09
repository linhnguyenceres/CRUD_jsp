<%-- 
    Document   : search
    Created on : Jun 27, 2020, 12:39:58 PM
    Author     : ASUS
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>ten sp</th>
                <th>quy cach</th>
                <th>gia tien</th>
                <th>nha san xuat</th>
            </tr>
            <%
                try{
                    Connection conn = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    Properties connectionProps = new Properties();
                    connectionProps.put("user","root");
                    connectionProps.put("password","");
                    String ConnectionString = "jdbc:mysql://localhost:3306/QuanLyHangHoa";
                    conn = DriverManager.getConnection(ConnectionString, connectionProps);
                    Statement st = conn.createStatement();
                    String search = request.getParameter("search");
                    String sql = "SELECT * FROM SanPham WHERE tensp LIKE '"+search+"%'";
                    ResultSet rs = st.executeQuery(sql);
                    while(rs.next()){
                        %>
                        <tr>
                            <td><%= rs.getInt("id")%></td>
                            <td><%= rs.getString("tensp")%></td>
                            <td><%= rs.getString("quycach")%></td>
                            <td><%= rs.getBigDecimal("gia")%></td>
                            <td><%= rs.getString("nhasx")%></td>
                        </tr>
                        <% }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                %>
        </table>
        <div align="center" style="margin-right:40%">
            <a href="/QuanLySanPham" >Back</a>
        </div>
    </center>
    </body>
</html>
