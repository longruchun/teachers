package com.yangsha.presentation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class testJndi {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
        Context cxt=new InitialContext();
        String tj=(String)cxt.lookup("java:comp/env/tjndi");
        
        System.out.println(tj);
	}

}
