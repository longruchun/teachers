package com.yangsha.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yangsha.biz_impl.PetOwnerBiz_impl;
import com.yangsha.biz_impl.PetStoreBiz_impl;
import com.yangsha.biz_impl.petBiz_jdbcImpl;
import com.yangsha.biz_interface.IpetBiz;
import com.yangsha.biz_interface.PetOwnerBiz_interface;
import com.yangsha.biz_interface.PetStoreBiz_interface;
import com.yangsha.entity.Pet;
import com.yangsha.util.StringHelper;
import com.yangsha.util.pager;

@WebServlet("/petServlet")
public class petServlet extends BaseServlet {
    public String petList(HttpServletRequest req,HttpServletResponse res) {
    	IpetBiz biz=new petBiz_jdbcImpl();
        PetOwnerBiz_interface  owner_biz=new PetOwnerBiz_impl();
        PetStoreBiz_interface  store_biz =new PetStoreBiz_impl();
       
        //˫��ѯ����ȡ����������ÿҳ����  ����������
        int pageOffset=req.getParameter("pager.offset")==null?0:Integer.parseInt(req.getParameter("pager.offset"));
        int pageSize=req.getParameter("pageSize")==null?4:Integer.parseInt(req.getParameter("pageSize"));
        
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("pageOffset", pageOffset);
        map.put("pageSize",pageSize);
        
        
        List<Pet> petlist=biz.getPager(map);//��ǰ��ҳҪ��Ⱦ������
        List<Pet> totallist=biz.getAll();
        
        pager pager1=new pager();
        pager1.setDatas(petlist);
        pager1.setTotalRecord(totallist.size());
        
        req.setAttribute("pagers",pager1);
        
        
    	return "/pages/pet/petlist.jsp";
    }
    
    public String petAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		
		PrintWriter out= response.getWriter();
	 
       //�����ύ������ ��������ʵ�� ��һ���ϴ�����Ķ����������ϴ�������
	  
	    DiskFileItemFactory factory=new DiskFileItemFactory();
   
        //�ڴ�洢�����ֵ
		//factory.setSizeThreshold(4096);
		
        //���ϴ��ļ�����ʱ��Ҫ����һ����ʱ·��
		//factory.setRepository(new File("c:\\upload"));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		//�����ļ��ϴ���С
		upload.setSizeMax(1000000 * 20);
	
			try {
				
				List<Pet> pets=new ArrayList<Pet>();
				List<FileItem> fileItems = upload.parseRequest(request);
				
				Pet pet=null;
				for(int i=0;i<fileItems.size();i++){
					if(i%10==0){
					   pet=new Pet();
					   pets.add(pet);
					}
					
					
					FileItem item=fileItems.get(i);
					
					//����ͨ�ı�������
					if(item.isFormField()) {
						
						//(map.get(item.getFieldName())).parse(item.getString("UTF-8"));
						//PropertyUtils.setProperty(pet, item.getFieldName(), item.getString("UTF-8"));
						switch(item.getFieldName()){
						case "id":
							pet.setId(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "name":
							pet.setName(item.getString("UTF-8"));
							break;
						case "typeName":
							pet.setTypeName(item.getString("UTF-8"));
							break;
						case "health":
							pet.setHealth(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "love":
							pet.setLove(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "birthday":
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							pet.setBirthday(sdf.parse(item.getString("UTF-8")));
							break;
						case "owner_Id":
							pet.setOwner_Id(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "store_Id":
							pet.setStore_Id(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "price":
							pet.setPrice(Double.parseDouble(item.getString("UTF-8")));
							break;
	
						}
						
						
					}
					//�Ƿ�Ϊinput="type"������
					if (!item.isFormField()) {
						String fileName = item.getName();
						long size = item.getSize();
						if ((fileName == null || fileName.equals("")) && size == 0) {
							continue;
						}
						//��ȡ�ַ��� �磺C:\WINDOWS\Debug\PASSWD.LOG
						//fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
						String fileExtName=fileName.substring(fileName.lastIndexOf("."), fileName.length());
						String temp=StringHelper.getFileTempName()+fileExtName;
						//item.write(new File(uploadPath + itemNo + ".gif"));
						pet.setPhoto("/upload/pet/"+temp);
						item.write(new File(request.getRealPath("/upload/pet/"), temp));
					}
		
				}
		
				IpetBiz biz=new petBiz_jdbcImpl();
				
				for(int i=0;i<pets.size();i++){
					Pet _pet=pets.get(i);
    					biz.add(_pet);
				}
	
			} catch (Exception e) {
					e.printStackTrace();
			}

    	    return "redirect:"+request.getContextPath()+"/pages/pet/petlist.jsp";
    }
    
    public String petEdit(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	     
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		
		PrintWriter out= response.getWriter();
	 
       //�����ύ������ ��������ʵ�� ��һ���ϴ�����Ķ����������ϴ�������
	  
	    DiskFileItemFactory factory=new DiskFileItemFactory();
   
        //�ڴ�洢�����ֵ
		//factory.setSizeThreshold(4096);
		
        //���ϴ��ļ�����ʱ��Ҫ����һ����ʱ·��
		//factory.setRepository(new File("c:\\upload"));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		//�����ļ��ϴ���С
		upload.setSizeMax(1000000 * 20);
    	
            try {
				
				
				List<FileItem> fileItems = upload.parseRequest(request);
				
				Pet pet=new Pet();
				
				String deleteFilePath="";
				for(int i=0;i<fileItems.size();i++){	
					FileItem item=fileItems.get(i);
					
					//����ͨ�ı�������
					if(item.isFormField()) {
						
						//(map.get(item.getFieldName())).parse(item.getString("UTF-8"));
						//PropertyUtils.setProperty(pet, item.getFieldName(), item.getString("UTF-8"));
						switch(item.getFieldName()){
						case "id":
							pet.setId(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "name":
							pet.setName(item.getString("UTF-8"));
							break;
						case "typeName":
							pet.setTypeName(item.getString("UTF-8"));
							break;
						case "health":
							pet.setHealth(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "love":
							pet.setLove(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "birthday":
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							pet.setBirthday(sdf.parse(item.getString("UTF-8")));
							break;
						case "owner_Id":
							pet.setOwner_Id(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "store_Id":
							pet.setStore_Id(Integer.parseInt(item.getString("UTF-8")));
							break;
						case "price":
							pet.setPrice(Double.parseDouble(item.getString("UTF-8")));
							break;
						case "deleteFilePath":	
							deleteFilePath=item.getString("UTF-8");
							break;
						}
						
						
					}
					
					
					
					//�Ƿ�Ϊinput="type"������
					if (!item.isFormField()) {
						String fileName = item.getName();
						long size = item.getSize();
						if ((fileName == null || fileName.equals("")) && size == 0) {
							continue;
						}
						//��ȡ�ַ��� �磺C:\WINDOWS\Debug\PASSWD.LOG
						//fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
						String fileExtName=fileName.substring(fileName.lastIndexOf("."), fileName.length());
						String temp=StringHelper.getFileTempName()+fileExtName;
						//item.write(new File(uploadPath + itemNo + ".gif"));
						pet.setPhoto("/upload/pet/"+temp);
						
						//ɾ��ԭͼ
						if(deleteFilePath!=""){
							File file=new File(request.getRealPath(deleteFilePath));
							if(file.exists()){
						       file.delete();
							}
						}
						
						item.write(new File(request.getRealPath("/upload/pet/"), temp));
					}
			
					
				}
				
				
				IpetBiz biz=new petBiz_jdbcImpl();
						
				biz.update(pet);
					
				

				} catch (Exception e) {
					e.printStackTrace();
				}
		
            return "redirect:"+request.getContextPath()+"/pages/pet/petlist.jsp";
    }
}
