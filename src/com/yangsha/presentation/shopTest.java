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
		System.out.println("�����̵�����");
		
		IPetDao ipd = new PetDaoImpl();
		System.out.println("���г����MySQL������");
		System.out.println("********************");
		List<Pet> list = ipd.getAll();
		Iterator<Pet> it = list.iterator();
		while(it.hasNext()) {
			Pet pet = it.next();
			System.out.println("��"+pet.getId()+"�����"+"���ֽУ�"+pet.getName());
		}
		System.out.println("********************");
		System.out.println();
		
		IPetOwnerDao ipod = new PetOwnerDaoImpl();
		System.out.println("���г������˴�MySQL������");
		System.out.println("********************");
		List<PetOwner> list2 = ipod.getAll();
		Iterator<PetOwner> it2 = list2.iterator();
		while(it2.hasNext()) {
			PetOwner po = it2.next();
			System.out.println("��"+po.getId()+"���������ˣ�"+"���ֽУ�"+po.getName());
		}
		System.out.println("********************");
		System.out.println();
		
		IPetStoreDao ipsd = new PetStoreDaoImpl();
		System.out.println("���г������˴�MySQL������");
		System.out.println("********************");
		List<PetStore> list3 = ipsd.getAll();
		Iterator<PetStore> it3 = list3.iterator();
		while(it3.hasNext()) {
			PetStore ps = it3.next();
			System.out.println("��"+ps.getId()+"������꣬"+"���ֽУ�"+ps.getName());
		}
		System.out.println("********************");
		System.out.println();
		
		System.out.println("��ѡ�������¼ģʽ");
		System.out.println("1.�������˵�¼");
		System.out.println("2.�����̵��¼");
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
