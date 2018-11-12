package com.yangsha.biz_impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yangsha.biz_interface.PetOwnerBiz_interface;
import com.yangsha.dao_impl.PetDaoImpl;
import com.yangsha.dao_impl.PetOwnerDaoImpl;
import com.yangsha.dao_interface.IPetDao;
import com.yangsha.dao_interface.IPetOwnerDao;
import com.yangsha.entity.Pet;
import com.yangsha.entity.PetOwner;

public class PetOwnerBiz_impl implements PetOwnerBiz_interface {

	IPetDao pdi = new PetDaoImpl();
	IPetOwnerDao ipod = new PetOwnerDaoImpl();
	@Override
	public void sell(Pet pet) {
		
       pdi.update(pet);
       
	}

	@Override
	public void buy(Pet pet) {
		
        pdi.update(pet);
	}

	@Override
	public boolean login() {
		boolean flag=false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入姓名");
			String name = sc.next();
			System.out.println("请输入密码");
			String password = sc.next();
			int money = 0;
			List<PetOwner> list = ipod.getAll();
			Iterator<PetOwner> it = list.iterator();
			while (it.hasNext()) {
				PetOwner po = it.next();
				if (name.equals(po.getName()) && password.equals(po.getPassword())) {
					money = po.getMoney();
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("恭喜您成功登录");
				System.out.println("您的基本信息：");
				System.out.println("名字：" + name);
				System.out.println("元宝数：" + money);
				System.out.println("登录成功，您可以购买和卖出宠物");
				System.out.println("1:购买宠物");
				System.out.println("2:卖出宠物");
				break;
			} else {
				System.out.println("您的输入有误,请重新输入");
				continue;
			}
		  }
		return flag;
	}

	@Override
	public List<PetOwner> getAll() {
		// TODO Auto-generated method stub
		return ipod.getAll();
	}

	@Override
	public int add(PetOwner t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(PetOwner t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PetOwner getEntityById(int id) {
		// TODO Auto-generated method stub
		return ipod.getEntityById(id);
	}

	@Override
	public List<PetOwner> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(PetOwner t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
