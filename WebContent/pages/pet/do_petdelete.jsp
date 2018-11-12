<%@page import="java.io.File"%>
<%@page import="com.yangsha.biz_impl.petBiz_jdbcImpl"%>
<%@page import="com.yangsha.biz_interface.IpetBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
if (request.getMethod().toLowerCase().equals("post")){
   String s_id=request.getParameter("id");
   String deleteFilePath=request.getParameter("deleteFilePath");
   int id=0;
   int val=0;
   if(s_id!=null){
	   
	   if(deleteFilePath!=null&&deleteFilePath!=""){
		   File file=new File(request.getRealPath(request.getContextPath()+deleteFilePath));
	       file.delete();
	   }
	   
	   id=Integer.parseInt(s_id);
	   IpetBiz biz=new petBiz_jdbcImpl();
	   val=biz.delete(id);
	   
	   if(val!=0){
	        out.print("<script>alert('删除成功');location='petlist.jsp';</script>");
	   }else{
		   out.print("<script>alert('删除失败');location='petlist.jsp';</script>");
	   } 
	   
   }
}else{
	 out.print("<script>alert('非法删除');location='petlist.jsp';</script>");
}
%>
<body>

</body>
</html>