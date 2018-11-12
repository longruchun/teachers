package com.yangsha.presentation;

import java.util.Scanner;

public class recursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //计算一个数的阶乘
		Scanner input=new Scanner(System.in);
		//System.out.println("请输入一个数:");
		//int num=input.nextInt();
		
		/*int result=1;
		
		for(int i=num;i>0;i--) {
			result*=i;
		}*/
		
		//System.out.println("您输入的数:"+num+" 的阶乘是:"+factorial(num));
		
		//用递归算法计算菲波那契数列
		System.out.println("请输入要计算多少个菲波那契数:");
		int num1=input.nextInt();
		//设计一个递 归方法来进行计算,计算第num 个数的值是多少？num1>=3
		
		System.out.println("第"+num1+"个数的值是:"+fbnq(num1));
	}
	
	//以上是用循 环来计算阶乘的，下面我们设计一个方法来计算
	public static int factorial(int num) {
		if(num<=1) {
			return 1;
		}else {
			return num * factorial(num-1);
		}
	}
	
	public static long fbnq(int n) {
		if(n==2||n==1) {
			return 1;
		}else {
			System.out.println(fbnq(n-1)+fbnq(n-2));
			return fbnq(n-1)+fbnq(n-2);
		}
	}

}
