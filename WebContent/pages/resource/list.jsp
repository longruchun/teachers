<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@include file="/pages/share/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
      
      <link rel="stylesheet" href="${pageContext.request.contextPath}/Public/css/jquery.treetable.css"> 
      <link rel="stylesheet" href="${pageContext.request.contextPath}/Public/css/jquery.treetable.theme.default.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/Public/css/bootstrap.css"> 
    
    <style>
        #table th, #table td {
            font-size: 14px;
            padding : 8px;
        }

    </style>


</head>
<body>


			<table id="table" width="85%" class="col-md-9   table-condensed table-striped" border="1">
				    <caption class="text-center"><em>部门列表</em></caption>
				    
					<tr>
						
						<td class="text-right" colspan="2" style="padding-right:20px;">
						   <a  href="${pageContext.servletContext.contextPath }/dept?method=addRoot" title="增加根部门"> 
							 <span class="glyphicon glyphicon-plus"></span>
						   </a>
						</td>
					</tr>
					
				    <thead>
				        <tr>
				            <th>名称</th>
				            <th>操作</th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach items="${menus}" var="dept">
				            <tr data-tt-id='${dept.id}' <c:if test="${not dept.rootNode}">data-tt-parent-id='${dept.pid}'</c:if> >
				                <td>${dept.text}</td>
				                
				                <td>
				                    
                                         <a	href="${pageContext.servletContext.contextPath }/dept?method=addSub&pid=${dept.id}" title="增加下级部门"><span class="glyphicon glyphicon-plus"></span></a>&nbsp;
				                    
				
				                    
					                        <a href="${pageContext.servletContext.contextPath }/dept?method=edit&pid=${dept.id}"  target="_self" title="修改">
											   <span class="glyphicon glyphicon-pencil"></span></a>&nbsp;
				                    
				    
				                    
					                    
					                        <a href="javascript:void(0);" id="${dept.id }"
													onclick="besure(this.id);" title="删除"><span
														class="glyphicon glyphicon-minus"></span>
											</a>
					                    
				                   
				                </td>
				            </tr>
				        </c:forEach>
				    </tbody>
				</table>
			

<script src="${pageContext.request.contextPath}/Public/scripts/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/Public/scripts/js/jquery.treetable.js"></script>
<script>
	$(function() {
	    $("#table").treetable({expandable: true }).treetable("expandNode", 1);
	    $(".deleteBtn").click(function() {
	        if(confirm("确认删除吗?")) {
	            location.href = "${pageContext.request.contextPath}/dept/"+$(this).data("id")+"/delete";
	        }
	    });
	});
    
	   function besure(id){
	   			   if(confirm("确定删除吗?")){
	   				   location.href="${pageContext.servletContext.contextPath }/sys/dept/"+id+"/delete";
	                   //doAjax("${pageContext.servletContext.contextPath }/sys/dept/delete?id="+id);   			   
	   			   }
	   }
	   
	   function doAjax(url){
		   $.ajax({
   	        url:url,
   	        type:'GET', //GET
   	        async:true,    //或false,是否异步
   	        timeout:5000,    //超时时间
   	        dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
   	        success:function(datas){
   	        	        alert(datas);
   			            location.reload();
   			},
    		 error:function(data){  
	             alert("出错了！！");  
	             console.log(data);
	   		 }
         })
	   }
	   
	  
</script>		
</body>
</html>