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
<script src="${pageContext.request.contextPath }/Public/scripts/js/bootstrap.min.js"></script>
<script>
    function besure(obj){
    	if(confirm("确定要删除该条记录?")){
     		$(obj).parents("form").submit();
    	}
    }
    
    var theme="table";
    
    $(function(){
    	
    	$("#skin").change(function(){
        	theme=$(this).val();
        })
    	
    	
	 	$(".storeId").click(function(){
	 		$.ajax({
	 			type:"post",
	   			url:"${pageContext.request.contextPath }/do_storePet",
	   			dataType:"json",
	   			data:{store_Id:$(this).html()},
	   			success:function(data){
	   				data=eval(data);
	   				var html="";
	   				if(theme=="table"){
		   				html+="<table class=\"table table-bordered table-condensed table-hover table-responsive table-striped \">"
		   				html+="<th>Id</th><th>Name</th><th>birthday</th><th>store_Id</th><th>price</th><th>photo</th>";
		   				for(var i=0;i<data.length;i++){
		   					//console.log(data[i]);
		   					var pet=data[i];
		   					html+="<tr>";
		   					html+="<td>"+pet.id+"</td>";
		   					html+="<td>"+pet.name+"</td>";
		   					html+="<td>"+pet.birthday+"</td>";
		   					html+="<td>"+pet.store_Id+"</td>";
		   					html+="<td>"+pet.price+"</td>";
		   					html+="<td><img src='${pageContext.request.contextPath }"+pet.photo+"' style=\"width:45px;height:45px;\" /></td>";
		   					html+="</tr>";
		   				}
		   				html+="</table>";
	   				}else if(theme=="dl"){
	   					for(var i=0;i<data.length;i++){
	   						var pet=data[i];
	   						html+="<dl>";
	   						html+="<dt>"+pet.id+"&nbsp;&nbsp;"+pet.name+"&nbsp;&nbsp;"+pet.store_Id+"</dt>";
	   						html+="<dt>"+pet.price+"&nbsp;&nbsp;<img src='${pageContext.request.contextPath }"+pet.photo+"' style=\"width:45px;height:45px;\" />";
	   						html+="</dl>";
	   					}
	   				}
	   				$(".modal-body").html(html);
	   			}
	 		 })
	 	});
 	  
    })

    
    
</script>
</head>
<body>
   <%-- <c:if test="${empty list }">
      <c:redirect url="/do_petlist"></c:redirect>
   </c:if>  --%>
   <div class="pull-right" style="margin-right:50px;">
	    <h4>Skin
	    <select id="skin">
	       <option value="table">table</option>
	       <option value="dl">dl</option>
	    </select>
	    </h4>
   </div>
   <div style="clear:both"></div>
   <table style="width:70%;margin:10px auto;" class="table table-bordered table-condensed table-hover table-responsive table-striped ">
       <caption class="text-center">宠物店列表</caption>
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>balance</th>
          <th style="width:120px;">操作</th>
       </tr>
       
      <tr>
	          <td colspan="11">
	             <a class="btn btn-xs btn-success pull-right" href="${pageContext.request.contextPath }/pages/pet/petStoreadd_edit.jsp?mode=add">
	                     <i class="glyphicon glyphicon-plus-sign"></i> 增加
	             </a>
	          </td>
	       </tr>
       
       <!--  在页面上集成嵌入java代码，只要写在这个特殊标签对中  -->
      
       
       <c:if test="${not empty pagers.datas }">
           <c:forEach items="${pagers.datas }" var="petStore">
                 <tr>
			          <td class="text-center"><a  href="javascript:void(0);" data-toggle="modal" data-target="#myModal" class="btn btn-xm btn-primary storeId" title="点击显示该id下宠物店所有宠物">${petStore.id }</a></td>
			          <td>
			             <c:if test="${fn:length(petStore.name)>12 }"> 
			                 ${fn:substring(petStore.name,0,11) }...
			             </c:if> 
			             <c:if test="${fn:length(petStore.name)<12 }">
			                  ${petStore.name }
			             </c:if>
			          </td>
			          <td>${petStore.balance }</td>
	
			          
			          <td style="vertical-align:middle;">
			             <a class="btn btn-xs btn-warning" href="petStoreadd_edit.jsp?id=${petStore.id }&mode=edit">
			                     <i class="glyphicon glyphicon-pencil"></i> 修改
			             </a>
			             <form  action="do_petStoredelete.jsp" method="post" style="display:inline;">
			                 <a class="btn btn-xs btn-danger" href="javascript:void(0)" onclick="besure(this)">
				                     <i class="glyphicon glyphicon-trash"></i> 删除
				             </a>
			             </form>
			          </td>
			       </tr>
           </c:forEach>
           <tr>
              <td colspan="5">
                   <jsp:include page="/inc/pager.jsp">
                         
						<jsp:param value="${pageContext.request.contextPath}/petStoreServlet" name="url" />
						<jsp:param value="petStoreList" name="method" />
						<jsp:param value="${pagers.totalRecord}" name="items" />
	
					</jsp:include>
              </td>
           </tr>
       </c:if>
       <c:if test="${empty pagers.datas }">
       <tr>
              <td colspan="5">
                    暂时没有宠物数据
              </td>
       </tr>
       </c:if>    
	       
      
   </table>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">宠物店宠物列表</h4>
            </div>
            <div class="modal-body">
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>   
</body>
</html>