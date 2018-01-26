package com.ek.guide.recursion.demo2;

/**
 * 所谓递归，是指程序调用自身，当然，递归不会无休止地调用下去， 它必然有一个出口，当满足条件时程序也就结束了，不然的话，那就是死循环了。
 * 
 * 提供几个递归实例 1、十进制转换二进制 2、求1+2+3+...+n的和 3、求最大公约数 4、求汉诺塔算法
 * 
 * @author EK
 * @date 2017年7月19日
 */
public class Test1 {

	public static void main(String[] args) {
		System.out.println(jiecheng1(5));
		// bar();
		// foo(9); // 99乘法表
		// System.out.println("5的阶乘是:" + jiecheng(5)); // 阶乘
		// decimalToBinary(103);// 十进制转换二进制
		// System.out.println(sum(100));// 求和
		// yueshu(12, 8); // 求最大公约数
		// hanon(4, 'A', 'B', 'C'); // 求汉诺塔算法
	}

	// 不用递归 九九乘法表
	public static void bar() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " * " + i + " = " + (i * j) + " ");
			}
			System.out.println();
		}
	}

	// 递归方法 九九乘法表
	public static void foo(int i) {
		if (i == 1) {
			System.out.println("1*1=1 ");
		} else {
			foo(i - 1);
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + " ");
			}
			System.out.println();
		}
	}

	
	// 非递归方法 阶乘
	public static int jiecheng1(int n) {
		int j=1;
		for(int i=1; i<n; i++){
			j += j*i;
		}
		return j;
	}
	
	// 递归方法 阶乘
	public static int jiecheng(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * jiecheng(n - 1);
		}
	}

	// 递归方法decimalToBinary，把一个十进制数转换成二进制数
	public static void decimalToBinary(int num) {
		if (num == 0) { // 当num=0时，循环结束
			return;
		} else {
			decimalToBinary(num / 2); // 调用递归方法
			System.out.print(num % 2);
		}
	}

	// 递归方法sum，求 1+2+...+n 的求和
	public static int sum(int num) {
		if (num > 0) {
			return num + sum(num - 1); // 调用递归方法
		} else {
			return 0; // 当num=0时，循环结束
		}
	}

	// 递归方法yueshu,求两个数的最大公约数 ,用两个数的绝对值与这两个数较小的那个一直比较，直到相等为止。
	public static void yueshu(int num1, int num2) {
		if (num1 == num2) {
			System.out.println(num1); // num1=num2时，结束
		} else {
			yueshu(abs(num1 - num2), min(num1, num2)); // 调用递归方法
		}
	}

	// 求两个数绝对值
	public static int abs(int num) {
		return num > 0 ? num : -num;
	}

	// 求两个数较小者
	public static int min(int num1, int num2) {
		return num1 > num2 ? num2 : num1;
	}

	// 递归方法hanon，求汉诺塔算法
	public static void hanon(int n, char a, char b, char c) {
		if (n == 1) {
			move(1, a, c);// 最后一种情况是，把A柱子上盘子移到C柱子上。
			return;
		}
		hanon(n - 1, a, c, b); // 递归，把n-1个盘子从A 盘上借助C盘移到B盘上
		move(n, a, c);// 调用move()方法
		hanon(n - 1, b, a, c);// 递归，把把n-1个盘子从B盘上借助A盘移到C盘上
	}

	public static void move(int n, char a, char c) {
		System.out.println(n + ":" + a + "-->" + c);// 打印移动盘子情况
	}

}