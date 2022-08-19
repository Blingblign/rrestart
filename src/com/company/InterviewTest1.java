package com.company;

import java.util.Date;

//考查多态的笔试题目：
public class InterviewTest1 {

	public static void main(String[] args) {
		Base1 base1 = new Sub1();
		base1.add(1, 2, 3);

		Sub1 s = (Sub1)base1;
//		s.add(1,2,3);
		byte b = 12;
		byte b2 = 13;
		short s1 = 12;
		byte b3 =(byte) (b + 1);//编译不通过
		System.out.println(b == s1);
		char c = 12;
		System.out.println(b == c);
//		System.out.println("hello" == new java.util.Date()); //编译不通过
//		System.out.println(new Date() == new Sub1());
		base1.equals(new Date());
	}
}

class Base1 {
	public void add(int a, int... arr) {
		System.out.println("base");
	}
}

class Sub1 extends Base1 {

	public void add(int a, int[] arr) {
		System.out.println("sub_1");
		if('c' == 7.7){

		}
	}

//	public void add(int a, int b, int c) {
//		System.out.println("sub_2");
//	}

}