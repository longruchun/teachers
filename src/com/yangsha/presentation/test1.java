package com.yangsha.presentation;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.tomcat.util.security.MD5Encoder;


import com.yangsha.biz_impl.petBiz_jdbcImpl;
import com.yangsha.biz_interface.IpetBiz;
import com.yangsha.entity.Pet;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*IpetBiz biz=new petBiz_jdbcImpl();
        List<Pet> list=biz.getAll();*/
		
		String name="—Ó…Ø";
		String pass="123456";
		
		String password=new Md5Hash(pass,name,3).toString();
		
		System.out.println(password);
		
		Scanner input =new Scanner(System.in);
		
		System.out.println("«Î ‰»Î”√ªß√˚");
		String name1=input.next();
		
		System.out.println("«Î ‰»Î√‹¬Î:");
		String pass1=input.next();
		
		if((new Md5Hash(pass1,name1,3).toString()).equals(password)) {
			System.out.println("µ«¬º≥…π¶ ");
		}else {
			System.out.println("µ«¬º ß∞‹ ");
		}
	}

}
