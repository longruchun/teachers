package com.yangsha.util.clientFunction;

import com.yangsha.biz_impl.MenuBizImpl;
import com.yangsha.biz_impl.roleBizImpl;
import com.yangsha.biz_interface.IBaseBizable;
import com.yangsha.biz_interface.IMenuBiz;
import com.yangsha.biz_interface.IroleBiz;
import com.yangsha.entity.role;
import com.yangsha.util.menu.menuitem;

/**
 * �����еľ�̬��������Ϊǰ����ΪJSTL�Զ��庯��ʹ�ö����
 * @author Administrator
 *
 */
public class ClientFunctions {
   
	/**
	 * �����Զ��ŷָ���id�ַ������õ���Ӧ���� �ַ���
	 * @param Ids
	 * @return
	 */
	public static String getNamesByIds(String Ids) {
		
		IMenuBiz biz=new MenuBizImpl();
		
		String[] Id_s=Ids.split(",");
		
		StringBuffer sb=new StringBuffer();
		for(String s : Id_s) {
			int id=Integer.parseInt(s);
			
			menuitem item=biz.getEntityById(id);
			
			if(item!=null) {
				sb.append(item.getText());
				sb.append(",");
			}
			
		}
		
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	
	
    public static String getRoleNamesByIds(String Ids) {
		
		
		IroleBiz biz=new roleBizImpl();
		
		String[] Id_s=Ids.split(",");
		
		StringBuffer sb=new StringBuffer();
		for(String s : Id_s) {
			int id=Integer.parseInt(s);
			
			role item=biz.getEntityById(id);
			
			if(item!=null) {
				sb.append(item.getRolename());
				sb.append(",");
			}
			
		}
		
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
