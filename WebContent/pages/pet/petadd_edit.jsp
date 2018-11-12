<%@page import="com.yangsha.biz_impl.petBiz_jdbcImpl"%>
<%@page import="com.yangsha.biz_interface.IpetBiz"%>
<%@page import="com.yangsha.entity.Pet"%>
<%@page import="com.yangsha.entity.PetStore"%>
<%@page import="com.yangsha.biz_impl.PetStoreBiz_impl"%>
<%@page import="com.yangsha.biz_interface.PetStoreBiz_interface"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.yangsha.entity.PetOwner"%>
<%@page import="java.util.List"%>
<%@page import="com.yangsha.biz_impl.PetOwnerBiz_impl"%>
<%@page import="com.yangsha.biz_interface.PetOwnerBiz_interface"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../share/head.jsp" %>    
<!DOCTYPE html>
<html>
    <head>
        
        <title>宠物添加</title>
		
		<style type="text/css">
		   
		   tr{
		     vertical-align:middle; 
		   }
		   
		   th{
		     text-align:center;
		   }
		   
		   input.wd66{
		      width:66px;
		   }
		</style>
		
        <script>
           function add_line(){
        	   $("tr:last").clone().appendTo($("table"));
           }
        </script>
    </head>
    <%
        //为了判断本次进入该 页面，是为了做增加，还是做修改，我们要检查url中是否包含id参数
        //如果不包含id参数，说明是添加
        //如果是修改，就要把相应id 的宠物，从数据库取出，填列到相应表单元素中，以供用户修改
        String s_id=request.getParameter("id");
        int id=0;
        
        Pet pet=new Pet();
        
        if(s_id!=null){
        	id=Integer.parseInt(s_id);//得到宠物id,据以查询出对应宠物
        	IpetBiz biz=new petBiz_jdbcImpl();
        	
        	pet=biz.getEntityById(id);
        	
        	
        }
     
        //request.setAttribute("pet",pet);
        pageContext.setAttribute("pet",pet);
    %>
    <body>
    	<form action="${pageContext.request.contextPath }/petServlet?method=${param.method } %>" method="post" enctype="multipart/form-data">
    	<table style="width:60%;margin:10px auto;" class="table table-bordered table-condensed table-hover table-responsive table-striped ">
    		<caption class="text-center">增加宠物</caption>
		       <tr>
		       	 <td colspan="9" class="text-right" style="margin-right:15px;">
		       	 	<a class="btn btn-xs btn-danger" href="javascript:history.go(-1);">
	                     <i class="glyphicon glyphicon-plus-sign"></i> 返回列表
	                </a>
		       	 	<%if(request.getParameter("method").equals("add")){ %>
		       	 	<a class="btn btn-xs btn-warning" href="javascript:void(0)" onclick="add_line();">
	                     <i class="glyphicon glyphicon-plus-sign"></i> 增加一行
	                </a>
	                <%} %>
	                <a class="btn btn-xs btn-success" href="javascript:void(0)" onclick="$('form')[0].submit();">
	                     <i class="glyphicon glyphicon-plus-sign"></i> 提交数据
	                </a>
	                
	                
		       	 </td>
		       </tr>
		       
		       <tr>
		          
		          <th>Name</th>
		          <th>typeName</th>
		          <th>health</th>
		          <th>love</th>
		          <th>birthday</th>
		          <th>owner_Id</th>
		          <th>store_Id</th>
		          <th>price</th>
		          <th>photo</th>
		       </tr>
		       
		       <tr>
		          
		          <td>
		          	<input type="hidden" name="id" value="<%=pet.getId() %>" />
		          	<%-- <input class="wd66" type="text" name="name" value="<%=pet.getName() %>" placeholder="输入名称" /> --%>
		            <input class="wd66" type="text" name="name" value="${pet.name }" placeholder="输入名称" /> 
		           
		          </td>
		          <td>
		            <%-- <input class="wd66" type="text" name="typeName" value="<%=pet.getTypeName() %>" placeholder="输入类型名称" /> --%>
		            <input class="wd66" type="text" name="typeName" value="${pet.typeName }" placeholder="输入类型名称" />
		          </td>
		          <td>
		            <input class="wd66" type="text" name="health" value="<%=pet.getHealth() %>" placeholder="输入健康值" />
		          </td>
		          <td>
		            <input class="wd66" type="text" name="love" value="<%=pet.getLove() %>" placeholder="输入亲密度" /> 
		          </td>
		          <td>
		            <input type="date" name="birthday" value="<%=pet.getBirthday() %>" placeholder="输入日期" />
		          </td>
		          <td>
		            <select  name="owner_Id" >
		            <%
		            	PetOwnerBiz_interface biz=new PetOwnerBiz_impl();
		                List<PetOwner> list=biz.getAll();
		                Iterator<PetOwner> it=list.iterator();
		                
		                while(it.hasNext()){
		                	PetOwner owner=it.next();
		            %>
		                <option value="<%=owner.getId()%>" 
		                  <% 
		                     if(owner.getId()==pet.getOwner_Id()){
		                  %>
		                     selected
		                  <% 
		                     }
		                  %>
		                ><%=owner.getName()%></option>
		            <%
		                }
		            %> 
		            </select>
		          </td>
		          <td>
		             <select  name="store_Id">
		             <%
		                 PetStoreBiz_interface store_biz=new PetStoreBiz_impl();
		                 List<PetStore> store_list=store_biz.getAll();
		                 
		                 Iterator<PetStore> s_it=store_list.iterator();
		                 
		                 while(s_it.hasNext()){
		                	 PetStore ps=s_it.next();
		                 
		             %>
		                 <option value="<%=ps.getId()%>"
		                    <%
		                        if(ps.getId()==pet.getStore_Id()){
		                    %>
		                        selected 
		                    <%
		                        }
		                    %>
		                 ><%=ps.getName()%></option>
		             <%
		                 }
		             %>
		             </select>  
		          </td>
		          <td>
		             <input class="wd66" type="text" name="price" value="<%=pet.getPrice() %>" placeholder="价格">
		          </td>
		          <td>
		             <%
		                    if(request.getParameter("method").equals("edit")){
		             %>
		             <p>
                               原图：<img src="<%=request.getContextPath()+pet.getPhoto() %>" style="width:45px;height:45px" />
		             <input type="hidden" name="deleteFilePath" value="<%=pet.getPhoto() %>" />   
                     </p>
		             <%} %>
		             <input type="file" name="photo" />
		          </td>
		       </tr>
		       
		       
    	</table>
    	
    </form>
 	</body>
</html>