<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath }/Public/css/bootstrap.css" rel="stylesheet" />
<pg:pager items="${param.items }" url="${param.url }" maxPageItems="4"
	maxIndexPages="5" isOffset="<%=false%>"
	export="pageOffset,currentPageNumber=pageNumber" scope="request">

	<pg:param name="method" value="${param.method }" />
    <pg:param name="pageSize" value="5" />
	<pg:index>
		<center>
			<!--  
        <pg:first>
		    <a href="${pageUrl }&pageNo=<%=pageNumber%>" >首页</a> 
			
		</pg:first> 
		-->
			<table width="65%" class="table table-bordered table-condensed table-hover table-responsive table-striped">
				<tr align=center valign=top>
					<td valign=bottom><font face=arial,sans-serif size=-1>Page:&nbsp;&nbsp;&nbsp;
					</font></td>
					<pg:prev ifnull="true">
						<% if  (pageUrl !=  null ) { %>
						<td align=right><A HREF="<%=pageUrl%>&pageNo=<%=pageNumber%>">
								<b>Previous</b>
						</A></td>
						<% } %>
					</pg:prev>
					<pg:pages>
						<% if  (pageNumber == currentPageNumber) { %>
						<td><font color=#A90A08><%= pageNumber %></font></td>
						<% } else  { %>
						<td><A HREF="<%=pageUrl%>&pageNo=<%=pageNumber%>"> <%=pageNumber%></A></td>
						<% } %>
					</pg:pages>
					<pg:next ifnull="true">
						<% if  (pageUrl !=  null ) { %>
						<td><A HREF="<%=pageUrl%>&pageNo=<%=pageNumber%>"> <b>Next</b></A></td>
						<% } %>
					</pg:next>
					<!--  
        <pg:last>
		    <a href="${pageUrl }&pageNo=<%=pageNumber%>" >尾页</a> 
			
		</pg:last> 
		 -->
				</tr>
			</table>
		</center>
	</pg:index>
</pg:pager>
