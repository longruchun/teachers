package com.yangsha.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.yangsha.biz_impl.PetOwnerBiz_impl;
import com.yangsha.biz_interface.PetOwnerBiz_interface;
import com.yangsha.dao_impl.PetDaoImpl;
import com.yangsha.dao_impl.PetOwnerDaoImpl;
import com.yangsha.dao_impl.PetStoreDaoImpl;
import com.yangsha.dao_interface.IPetDao;
import com.yangsha.dao_interface.IPetOwnerDao;
import com.yangsha.dao_interface.IPetStoreDao;
import com.yangsha.entity.Pet;
import com.yangsha.entity.PetOwner;
import com.yangsha.entity.PetStore;

public class shopTest {

	public static void main(String[] args) {

		startPetShop();
	}

	public static void startPetShop() {
		Scanner sc = new Scanner(System.in);
		System.out.println("宠物商店启动");
		
		IPetDao ipd = new PetDaoImpl();
		System.out.println("所有宠物从MySQL中醒来");
		System.out.println("********************");
		List<Pet> list = ipd.getAll();
		Iterator<Pet> it = list.iterator();
		while(it.hasNext()) {
			Pet pet = it.next();
			System.out.println("第"+pet.getId()+"个宠物，"+"名字叫："+pet.getName());
		}
		System.out.println("********************");
		System.out.println();
		
		IPetOwnerDao ipod = new PetOwnerDaoImpl();
		System.out.println("所有宠物主人从MySQL中醒来");
		System.out.println("********************");
		List<PetOwner> list2 = ipod.getAll();
		Iterator<PetOwner> it2 = list2.iterator();
		while(it2.hasNext()) {
			PetOwner po = it2.next();
			System.out.println("第"+po.getId()+"个宠物主人，"+"名字叫："+po.getName());
		}
		System.out.println("********************");
		System.out.println();
		
		IPetStoreDao ipsd = new PetStoreDaoImpl();
		System.out.println("所有宠物主人从MySQL中醒来");
		System.out.println("********************");
		List<PetStore> list3 = ipsd.getAll();
		Iterator<PetStore> it3 = list3.iterator();
		while(it3.hasNext()) {
			PetStore ps = it3.next();
			System.out.println("第"+ps.getId()+"个宠物店，"+"名字叫："+ps.getName());
		}
		System.out.println("********************");
		System.out.println();
		
		System.out.println("请选择输入登录模式");
		System.out.println("1.宠物主人登录");
		System.out.println("2.宠物商店登录");
		int choice = sc.nextInt();
		switch(choice) {
	    case 1:
	    	PetOwnerBiz_interface pobi = new PetOwnerBiz_impl();
	    	pobi.login();
			 break;
		case 2:
			   break;
		}
		
	}
	
}
