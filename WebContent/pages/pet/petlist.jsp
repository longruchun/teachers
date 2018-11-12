<%@page import="com.yangsha.biz_impl.PetStoreBiz_impl"%>
<%@page import="com.yangsha.biz_interface.PetStoreBiz_interface"%>
<%@page import="com.yangsha.biz_impl.PetOwnerBiz_impl"%>
<%@page import="com.yangsha.biz_interface.PetOwnerBiz_interface"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List,com.yangsha.biz_impl.petBiz_jdbcImpl,com.yangsha.biz_interface.IpetBiz,com.yangsha.entity.Pet"%>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>宠物列表</title>
<link href="${pageContext.request.contextPath }/Public/css/bootstrap.css" type="text/css" rel="stylesheet" />
<style type="text/css">
   
   th{
     text-align:center;
   }
</style>
<script src="${pageContext.request.contextPath }/Public/scripts/js/jquery-2.1.4.min.js"></script>
<script>
    function besure(obj){
    	if(confirm("确定要删除该条记录?")){
     		$(obj).parents("form").submit();
    	}
    }
</script>
</head>
<body>
   <%-- <c:if test="${empty list }">
      <c:redirect url="/do_petlist"></c:redirect>
   </c:if>  --%>
   <table style="width:70%;margin:10px auto;" class="table table-bordered table-condensed table-hover table-responsive table-striped ">
       <caption class="text-center">宠物列表</caption>
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>typeName</th>
          <th>health</th>
          <th>love</th>
          <th>birthday</th>
          <th>owner_Id</th>
          <th>store_Id</th>
          <th>price</th>
          <th>photo</th>
          <th style="width:120px;">操作</th>
       </tr>
       
      <tr>
	          <td colspan="11">
	             <a class="btn btn-xs btn-success pull-right" 
	                <c:if test="${not sessionScope.permissions.contains('pet:add') }">
	                   href="javascript:void(0)"
	                   disabled
	                </c:if>
	                
	                <c:if test="${sessionScope.permissions.contains('pet:add') }">
	                   href="pages/pet/petadd_edit.jsp?method=petAdd"
	                   
	                </c:if>
	             >
	                     <i class="glyphicon glyphicon-plus-sign"></i> 增加
	             </a>
	          </td>
	       </tr>
       
       <!--  在页面上集成嵌入java代码，只要写在这个特殊标签对中  -->
      
       
       <c:if test="${not empty pagers.datas }">
           <c:forEach items="${pagers.datas }" var="pet">
                 <tr>
			          <td>${pet.id }</td>
			          <td>
			             <c:if test="${fn:length(pet.name)>12 }"> 
			                 ${fn:substring(pet.name,0,11) }...
			             </c:if> 
			             <c:if test="${fn:length(pet.name)<12 }">
			                  ${pet.name }
			             </c:if>
			          </td>
			          <td>${pet.typeName }</td>
			          <td>${pet.health }</td>
			          <td>${pet.love }</td>
			          <td>${pet.birthday }</td>
			          <td>${pet.owner_Id }</td>
			          <td>${pet.store_Id }</td>
			          <td>${pet.price }</td>
			          <td>
			              <img src="${pageContext.request.contextPath}${pet.photo}" style="width:45px;height:45px;" />
			          </td>
			          <td style="vertical-align:middle;">
			             <a class="btn btn-xs btn-warning" href="pages/pet/petadd_edit.jsp?id=${pet.id }&method=petEdit"
			                <c:if test="${not sessionScope.permissions.contains('pet:edit') }">
			                   disabled
			                </c:if>
			             >
			                     <i class="glyphicon glyphicon-pencil"></i> 修改
			             </a>
			             <form  action="do_petdelete.jsp" method="post" style="display:inline;">
			                 <input name="deleteFilePath" type="hidden" value="${pageContext.request.contextPath}${pet.photo}" />
				             <input name="id" type="hidden" value="${pet.id }" />
				             <button class="btn btn-xs btn-danger"  onclick="besure(this)"
				            	 <c:if test="${not sessionScope.permissions.contains('pet:delete') }">
				                   disabled
				                </c:if>
				             >
				                     <i class="glyphicon glyphicon-trash"></i> 删除
				             </button>
			             </form>
			          </td>
			       </tr>
           </c:forEach>
           <tr>
              <td colspan="11">
                   <jsp:include page="/inc/pager.jsp">
                         
						<jsp:param value="${pageContext.request.contextPath}/petServlet" name="url" />
						<jsp:param value="petList" name="method" />
						<jsp:param value="${pagers.totalRecord}" name="items" />
	
					</jsp:include>
              </td>
           </tr>
       </c:if>
       <c:if test="${empty pagers.datas }">
       <tr>
              <td colspan="11">
                    暂时没有宠物数据
              </td>
       </tr>
       </c:if>    
	       
      
   </table>
</body>
</html>