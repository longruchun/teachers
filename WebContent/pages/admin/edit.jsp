<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myfn" uri="/WEB-INF/functions.tld" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/pages/share/head.jsp" %>
<html>
<head>
    <title></title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Public/css/zTreeStyle/zTreeStyle.css">
    <style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
        .l360{
           width:360px;
        }
    </style>
    
    <script>
       $(function(){
    	   $("#_all").click(function(){
    		   var that=$(this);
    		   $(".roles").each(function(){
    			   $(this).prop("checked",that.prop("checked"));
    		   })
    	   });
    	   
           $(".table").on("click",".roles",function(){
        	   var flag=true;
        	   $(".roles").each(function(){
        		   if(!$(this).prop("checked")){
					   flag=false;
					   return false;
				   }
        	   })
        	   $("#_all").prop("checked",flag);
 
    	   });
    	  
       })
    </script>

</head>
<body>
<div id="container">
    <form method="post" action="${pageContext.request.contextPath }/adminServlet?method=edit">
        
        <table class="table col-xs-8 table-condensed table-striped" style="margin-top:25px;font-size:small;">
           <caption class="text-center">用户角色添加</caption>
           
           <tr>
             <td class="text-right" colspan="2">
                <a href="javascript:history.go(-1);">返回</a>
             </td>
          </tr>
           
           <tr>
              <td class="text-right">用户名：</td>
              <td>
                  <input type="hidden" name="id" value="${admin.id }" />
                  <input type="text" name="name"  class="l360" value="${admin.name }"/>
              </td>
           </tr>
           
                     
           <tr>
              <td class="text-right">拥有的角色列表：</td>
              <td>
                
                <input type="checkbox" id="_all">全选
                <hr/> 
                <c:forEach items="${roles}" var="role" varStatus="stat">
                   <input type="checkbox" id="${role.id }_" class="roles" name="roles" value="${role.id }"
                      <c:if test="${fn:contains(admin.roleid,role.id) }">
                          checked
                      </c:if>
                   >${role.rolename }
                   <c:if test="${(stat.index+1)%3==0 }">
                      <br/>
                   </c:if>
                </c:forEach>             
              </td>
           </tr>
           
           <tr>
             <td colspan="2">
              <button>修改</button>
             </td>
           </tr>
        </table>
        
    </form>


    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
        <ul id="tree" class="ztree" style="margin-top:0;" ></ul>
    </div>
</div>
    
    

</body>
</html>