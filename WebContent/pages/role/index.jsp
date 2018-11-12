<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="myfn" uri="/WEB-INF/functions.tld" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="/pages/share/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   function besure(id){
	   	if(confirm("确定删除吗?")){
	   		location.href="${pageContext.servletContext.contextPath }/roleServlet?method=delete&id="+id;
	   	}
   }
</script>
</head>
<body>
 <div class="container">
	
	<div>
	<table class="table  col-md-9   table-condensed table-striped"  style="font-size:small;">
	    <caption class="text-center">
	       <em>角色列表</em>
	    </caption>
	    <tr>
	       <td colspan="4" class="text-right">
	          
		             <a href="${pageContext.request.contextPath}/roleServlet?method=add_edit" title="新增角色"><span class="glyphicon glyphicon-plus"></span></a><br/>
		      
	       </td>
	    </tr>
	    <thead>
	        <tr>
	            <th>角色名称</th>
	            <th>角色描述</th>
	            <th>拥有的资源</th>
	            <th>操作</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${roles}" var="role">
	            <tr>
	                <td>${role.rolename}</td>
	                <td>${role.desc}</td>
	                <td>
	                  <c:if test="${not empty  role.resource_ids}">
	                  ${myfn:getNamesByIds(role.resource_ids)}
	                  </c:if>
	                </td>
	                <td>
	                    
	                        <a href="${pageContext.request.contextPath}/roleServlet?method=add_edit&id=${role.id}"  title="修改"><span
											class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;
	                    
	
	                    
	                        <a href="javascript:void(0);" id="${role.id }"
									onclick="besure(this.id);"   title="删除"><span
											class="glyphicon glyphicon-minus"></span></a>
	                    
	                </td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
	</div>
</div>
</body>
</html>