<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%-- jsp 注释客户端看不见 --%>
    <!-- 这个注释会被发送到客户端浏览器 -->
<%
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    out.print("<div style='display:block'>"+sdf.format(new Date())+"</div>");
%> 
<script>
    document.write("Js 取的时间:"+new Date());
</script>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>