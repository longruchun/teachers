package com.yangsha.presentation;

import java.util.Scanner;

public class recursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //����һ�����Ľ׳�
		Scanner input=new Scanner(System.in);
		//System.out.println("������һ����:");
		//int num=input.nextInt();
		
		/*int result=1;
		
		for(int i=num;i>0;i--) {
			result*=i;
		}*/
		
		//System.out.println("���������:"+num+" �Ľ׳���:"+factorial(num));
		
		//�õݹ��㷨����Ʋ���������
		System.out.println("������Ҫ������ٸ��Ʋ�������:");
		int num1=input.nextInt();
		//���һ���� �鷽�������м���,�����num ������ֵ�Ƕ��٣�num1>=3
		
		System.out.println("��"+num1+"������ֵ��:"+fbnq(num1));
	}
	
	//��������ѭ ��������׳˵ģ������������һ������������
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
