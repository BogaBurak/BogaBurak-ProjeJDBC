<%@ page import="java.io.*" %>
<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Proje.Address"%>
<%@page import="ProjeSql.AddressSql"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 List<Address> addr = new AddressSql().getirTumListe();
 request.setAttribute("addr", addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listele</title>
<style>
#tablo {
border-collapse: collapse;
width: 100%;
}
 
#tablo td, #tablo th {
border: 1px solid #ddd;
padding: 8px;
}
 
#tablo tr:nth-child(even){background-color: #f2f2f2;}
 
#tablo tr:hover {
background-color: #ffd129;
color:#fff;
}
 
#tablo th {
padding-top: 12px;
padding-bottom: 12px;
text-align: left;
background-color: #ffa45e;
color: white;
}


    a:link, a:visited {
        background-color: #ffa45e;
        color: white;
        padding: 14px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }
 
 
    a:hover, a:active {
        background-color: #ffd129;
    }

</style>
</head>
<body>
<a href="Ekle.jsp">Ekle</a>
 <table id="tablo">
 <tr>
 <th>Address Code</th>
 <th>Address Type</th>
 <th>Address</th>
 <th>Düzenle</th>
 <th>Sil</th>
 </tr>
 <c:forEach items="${addr}" var="adr">
 <tr>
<td>${adr.ADDRCODE}</td>
<td>${adr.ADDRTYPE}</td>
<td>${adr.ADDRESS}</td>
<td><a href=Duzenle.jsp?id=${adr.IDX}>Düzenle</a></td>
<td><a href=sil?id=${adr.IDX}>Sil</a></td>
 </tr>
 </c:forEach>
 </table>
</body>
</html>